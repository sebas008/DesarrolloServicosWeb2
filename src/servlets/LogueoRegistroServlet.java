package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioDTO;
import services.UsuarioService;

/**
 * Servlet implementation class LogueoRegistroServlet
 */
@WebServlet("/LogueoRegistro")
public class LogueoRegistroServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String tipo = request.getParameter("tipo");
		
		if(tipo.equals("login"))
			login(request, response);
		else if(tipo.equals("registro"))
			registro(request, response);
		else
			actualizar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		UsuarioService servicio = new UsuarioService();
		String mensaje = "Error en los datos";
		
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		String clave_confirm = request.getParameter("clave_confirm");
		String codDistrito = request.getParameter("codDistrito");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String dni = request.getParameter("dni");
		
		UsuarioDTO u = new UsuarioDTO();
		u.setCodigo(codigo);
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setEmail(email);
		u.setClave(clave);
		u.setCodDistrito(codDistrito);
		u.setDireccion(direccion);
		u.setTelefono(telefono);
		u.setDni(dni);
		
		/*
		 * VALIDANDO
		 */
		int resultado = 0;
		
		if(clave_confirm.equals(clave))
		{
			//Se envia 0 como DNI porque no estamos recogiendo el DNI del formulario actualizar
			mensaje = datosDiferentes(email, telefono, dni, servicio.listado(), codigo);
			
			if(mensaje.equals("ok"))
			{
				resultado = servicio.actualizar(u);
			}
		}
		else
			mensaje = "Las contraseñas no son iguales";
		
		/*
		 * RESULTADOS
		 */
		if(resultado != 0)
		{
			request.getSession().invalidate();
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario", u);
			
			response.sendRedirect("Cuenta.jsp");
		}
		else
		{
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("Cuenta.jsp").forward(request, response);
		}
	}

	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		UsuarioService servicio = new UsuarioService();
		String mensaje = "Error en los datos";
		
		//Generar el codigo del usuario
		String codigo = servicio.ultimoCodUsuario();
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		String clave_confirm = request.getParameter("clave_confirm");
		String codDistrito = request.getParameter("codDistrito");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String dni = request.getParameter("dni");
		
		UsuarioDTO u = new UsuarioDTO();
		u.setCodigo(codigo);
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setEmail(email);
		u.setClave(clave);
		u.setCodDistrito(codDistrito);
		u.setDireccion(direccion);
		u.setTelefono(telefono);
		u.setDni(dni);
		
		/*
		 * VALIDANDO
		 */
		int resultado = 0;
		
		if(clave_confirm.equals(clave))
		{
			mensaje = datosDiferentes(email, telefono, dni, servicio.listado(), codigo);
			
			if(mensaje.equals("ok"))
			{
				resultado = servicio.registrar(u);
			}
		}
		else
			mensaje = "Las contraseñas no son iguales";
		
		/*
		 * RESULTADOS
		 */
		if(resultado != 0)
		{
			request.setAttribute("registroOK", "Registro correcto!!!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("mensaje", mensaje);
			
			//Devolver datos para que no tenga que reingresarlos todos
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("email", email);
			request.setAttribute("clave", clave);
			request.setAttribute("distrito", codDistrito);
			request.setAttribute("direccion", direccion);
			request.setAttribute("telefono", telefono);
			request.setAttribute("dni", dni);

			request.getRequestDispatcher("Registro.jsp").forward(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		
		UsuarioService servicio = new UsuarioService();
		UsuarioDTO u = servicio.login(email, clave);
		
		if(u == null)
		{
			request.setAttribute("mensaje", "Email o clave incorrecto");
			request.setAttribute("email", email);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else
		{
			request.getSession().setAttribute("usuario", u);
			response.sendRedirect("Inicio.jsp");
		}
	}
	
	/*
	 * METODOS DE VALIDACION
	 */
	String datosDiferentes(String email, String telefono, String dni, ArrayList<UsuarioDTO> usuarios, String codigo)
	{
		for(UsuarioDTO u : usuarios)
		{
			if(!u.getCodigo().equals(codigo))
			{
				if(email.equals(u.getEmail()))
					return "Un usuario ya tiene este Email";
				if(telefono.equals(u.getTelefono()))
					return "Un usuario ya tiene este N° de telefono";
				if(dni.equals(u.getDni()))
					return "Un usuario ya tiene este DNI";
			}
		}
		return "ok";
	}
}







