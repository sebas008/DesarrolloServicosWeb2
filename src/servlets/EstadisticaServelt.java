package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import beans.ProductoDTO;
import beans.UsuarioDTO;
import beans.VentaDTO;

/**
 * Servlet implementation class EstadisticaServelt
 */
@WebServlet("/EstadisticaServelt")
public class EstadisticaServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			/*
			 * Clientes
			 */
			UsuarioDTO[] usuariosArreglo = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/usuarioRest/usuariosConMasCompras").request(MediaType.APPLICATION_JSON).get(UsuarioDTO[].class);
			for (UsuarioDTO u : usuariosArreglo)
			{
				VentaDTO[] ventasArreglo = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/ventaRest/ventasXUsuario/" + u.getCodigo()).request(MediaType.APPLICATION_JSON).get(VentaDTO[].class);
				request.setAttribute("ventas" + u.getCodigo(), ventasArreglo);
			}
			
			/*
			 * Productos
			 */
			ProductoDTO[] productosArreglo = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/productoRest/productoMasVendidos").request(MediaType.APPLICATION_JSON).get(ProductoDTO[].class);
			int progressBarTope = productosArreglo[0].getCantidadVendida();
			
			for (ProductoDTO p : productosArreglo)
			{
				if (p.getCantidadVendida() > progressBarTope)
					progressBarTope = p.getCantidadVendida();
				
				UsuarioDTO[] usuariosXproducto = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/usuarioRest/clientesXproducto/" + p.getCodigo()).request(MediaType.APPLICATION_JSON).get(UsuarioDTO[].class);
				request.setAttribute("usuarios" + p.getCodigo(), usuariosXproducto);
			}
			
			request.setAttribute("usuariosConMasCompras", usuariosArreglo);
			request.setAttribute("productosMasVendidos", productosArreglo);
			request.setAttribute("progressBarTope", progressBarTope);
			request.getRequestDispatcher("Estadisticas.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			request.getRequestDispatcher("Estadisticas.jsp").forward(request, response);
		}
	}
}
