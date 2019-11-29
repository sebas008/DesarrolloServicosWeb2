package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import beans.CarritoDTO;
import beans.ProductoDTO;
import beans.UsuarioDTO;
import beans.VentaDTO;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet("/VentaServlet")
public class VentaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private Client ladoCliente;
	private static final String URLServicioVenta = "http://localhost:8080/ApiFerreteriaSaravia/ventaRest/";
	private static final String URLServicioProducto = "http://localhost:8080/ApiFerreteriaSaravia/productoRest/";
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ladoCliente = ClientBuilder.newClient();
		
		String tipo = request.getParameter("tipo");

		if (tipo.equals("agregar"))
			agregar(request, response);
		else if (tipo.equals("eliminar"))
			eliminar(request, response);
		else if (tipo.equals("comprar"))
			comprar(request, response);
		else if (tipo.equals("editar"))
			editar(request, response);
	}

	/*
	 * TRANSACCION
	 */
	private void comprar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Se obtiene el codigo del cliente que hace la compra
		UsuarioDTO u = (UsuarioDTO) request.getSession().getAttribute("usuario");
		String codUsuario = u.getCodigo();
		
		// Se obtiene la fecha
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fecha = sdf.format(new Date());

		VentaDTO v = new VentaDTO();
		v.setNumVenta(""); // El ultimo numero de venta se obtendrá en el servicio Rest
		v.setFecha(fecha);
		v.setCodCliente(codUsuario);

		// Obtener el carrito de compras
		@SuppressWarnings("unchecked")
		ArrayList<CarritoDTO> carrito = (ArrayList<CarritoDTO>) request.getSession().getAttribute("carrito");
		double totalVenta = (double) request.getSession().getAttribute("totalVenta");

		// Realizar la venta
		int ok = 0;

		if (!carrito.isEmpty())
		{
			ok = ladoCliente.target(URLServicioVenta + "transaccion").request(MediaType.TEXT_PLAIN).post(Entity.entity(v, MediaType.APPLICATION_JSON), Integer.class);
		}
		else
		{
			System.out.println("No hay productos en el carrito");
		}

		// Acciones posteriores
		if (ok != 0)
		{
			System.out.println("Venta exitosa");
			carrito.clear(); // vaciar el carrito
			totalVenta = 0.0; // volver a 0 el total acumulado

			request.setAttribute("ventaOK", "Venta realizada!!!");
			request.getSession().setAttribute("carrito", carrito);
			request.getSession().setAttribute("totalVenta", totalVenta);

			request.getRequestDispatcher("Carrito.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msgBoleta", "No hay productos en el carrito");
			request.getRequestDispatcher("Carrito.jsp").forward(request, response);
		}
	}

	/*
	 * AGREGAR A CARRITO
	 */
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Capturar la cantidad
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));

		// Capturar el codigo del producto
		String codProducto = request.getParameter("codigo");

		// Buscar el producto
		ProductoDTO p = ladoCliente.target(URLServicioProducto + "buscar/" + codProducto).request(MediaType.APPLICATION_JSON).get(ProductoDTO.class);

		// Obtener los datos globales de session
		@SuppressWarnings("unchecked")
		ArrayList<CarritoDTO> carrito = (ArrayList<CarritoDTO>) request.getSession().getAttribute("carrito");
		double totalVenta = (double) request.getSession().getAttribute("totalVenta");

		// Validando y agregando al carrito
		if (p.getStockAct() >= cantidad)
		{
			// Si el producto NO esta en el carrito, puede agregarse
			if (!productoYaEnCarrito(p.getCodigo(), carrito))
			{
				// Asignar los datos del producto al "producto en carrito"
				CarritoDTO pc = new CarritoDTO();
				pc.setCodigo(p.getCodigo());
				pc.setDescripcion(p.getDescripcion());
				pc.setMarca(p.getMarca());
				pc.setPrecio(p.getPrecio());
				pc.setCantidad(cantidad);
				pc.setSubTotal(p.getPrecio() * cantidad);

				// Agregar los productos al carrito
				carrito.add(pc);
				totalVenta += pc.getSubTotal();

				request.getSession().setAttribute("carrito", carrito);
				request.getSession().setAttribute("totalVenta", totalVenta);

				response.sendRedirect("Productos.jsp");
			}
			else
			{
				request.setAttribute("alerta", "El producto " + p.getDescripcion() + " ya esta en el carrito");
				request.getRequestDispatcher("Productos.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("alerta",
					"Solo quedan " + p.getStockAct() + " unidades del producto " + p.getDescripcion());
			request.getRequestDispatcher("Productos.jsp").forward(request, response);
		}
	}

	/*
	 * ELIMINAR
	 */
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int producto = Integer.parseInt(request.getParameter("posicion"));

		@SuppressWarnings("unchecked")
		ArrayList<CarritoDTO> carrito = (ArrayList<CarritoDTO>) request.getSession().getAttribute("carrito");
		double totalVenta = (double) request.getSession().getAttribute("totalVenta");

		// Se obtiene el producto mediante su indice
		CarritoDTO c = carrito.get(producto);

		// Se reduce el total y se elimina el producto del carrito
		totalVenta -= c.getSubTotal();
		carrito.remove(producto);

		request.getSession().setAttribute("carrito", carrito);
		request.getSession().setAttribute("totalVenta", totalVenta);
		response.sendRedirect("Carrito.jsp");
	}

	/*
	 * EDITAR COMPRA
	 */
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int indice = Integer.parseInt(request.getParameter("posicion"));
		int newCantidad = Integer.parseInt(request.getParameter("cantidadEDT"));
		String codigo = request.getParameter("codigo");

		@SuppressWarnings("unchecked")
		ArrayList<CarritoDTO> carrito = (ArrayList<CarritoDTO>) request.getSession().getAttribute("carrito");
		double totalVenta = (double) request.getSession().getAttribute("totalVenta");

		// Editando
		ProductoDTO p = ladoCliente.target(URLServicioProducto + "buscar/" + codigo).request(MediaType.APPLICATION_JSON).get(ProductoDTO.class);
		if (p.getStockAct() >= newCantidad)
		{
			// Se obtiene el producto mediante su indice
			CarritoDTO c = carrito.get(indice);

			// Se reduce el total y se elimina el producto del carrito
			totalVenta -= c.getSubTotal();
			carrito.remove(indice);

			c.setCantidad(newCantidad);
			c.setSubTotal(c.getPrecio() * c.getCantidad());

			// Se vuelve a agregar el producto actualizado, en la posicion donde estaba y el
			// subtotal
			carrito.add(indice, c);
			totalVenta += c.getSubTotal();

			request.getSession().setAttribute("carrito", carrito);
			request.getSession().setAttribute("totalVenta", totalVenta);

			response.sendRedirect("Carrito.jsp");
		}
		else
		{
			request.setAttribute("alerta",
					"Solo quedan " + p.getStockAct() + " unidades del producto " + p.getDescripcion());
			request.getRequestDispatcher("Carrito.jsp").forward(request, response);
		}
	}

	/*
	 * OTROS METODOS
	 */
	boolean productoYaEnCarrito(String codigo, ArrayList<CarritoDTO> productos)
	{
		for (CarritoDTO c : productos)
		{
			if (codigo.equals(c.getCodigo()))
				return true;
		}
		return false;
	}
}
