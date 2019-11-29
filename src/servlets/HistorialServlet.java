package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import beans.CarritoDTO;
import beans.UsuarioDTO;

/**
 * Servlet implementation class HistorialServlet
 */
@WebServlet("/HistorialServlet")
public class HistorialServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private Client ladoCliente;
	private final String URLServicioCarrito = "http://localhost:8080/ApiFerreteriaSaravia/carritoRest";
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ladoCliente = ClientBuilder.newClient();
		
		UsuarioDTO u = (UsuarioDTO) request.getSession().getAttribute("usuario");
		ArrayList<CarritoDTO> lista = new ArrayList<CarritoDTO>();

		String tipo = request.getParameter("tipo");
		if (tipo == null)
		{
			CarritoDTO[] carrito = ladoCliente.target(URLServicioCarrito + "/listarXcliente/" + u.getCodigo()).request(MediaType.APPLICATION_JSON).get(CarritoDTO[].class);
			for (CarritoDTO c : carrito)
				lista.add(c);
			
			request.getSession().setAttribute("historial", lista);
		}
		else
		{
			String fecha = request.getParameter("fecha");

			CarritoDTO[] carrito = ladoCliente.target(URLServicioCarrito + "/listarXfecha/" + u.getCodigo() + "/" + fecha).request(MediaType.APPLICATION_JSON).get(CarritoDTO[].class);
			for (CarritoDTO c : carrito)
				lista.add(c);
			
			request.getSession().setAttribute("historial", lista);
		}

		request.getRequestDispatcher("Historial.jsp").forward(request, response);
	}
}
