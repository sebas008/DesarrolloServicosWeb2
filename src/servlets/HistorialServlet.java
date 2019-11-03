package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CarritoDTO;
import beans.UsuarioDTO;
import services.CarritoService;

/**
 * Servlet implementation class HistorialServlet
 */
@WebServlet("/HistorialServlet")
public class HistorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UsuarioDTO u = (UsuarioDTO)request.getSession().getAttribute("usuario");
		ArrayList<CarritoDTO> lista = new ArrayList<CarritoDTO>();
		
		String tipo = request.getParameter("tipo");
		if(tipo == null)
		{
			lista = new CarritoService().listarXcliente(u.getCodigo());
			request.getSession().setAttribute("historial", lista);
		}
		else
		{
			String fecha = request.getParameter("fecha");
			
			lista = new CarritoService().listarXfecha(u.getCodigo(), fecha);
			request.getSession().setAttribute("historial", lista);
		}
		
		request.getRequestDispatcher("Historial.jsp").forward(request, response);
	}
}













