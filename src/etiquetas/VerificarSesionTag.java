package etiquetas;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import beans.UsuarioDTO;

public class VerificarSesionTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	UsuarioDTO usuario = null;

	public int doStartTag() throws JspException
	{
		if(usuario == null)
		{
			HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
			
			try {
				response.sendRedirect("Login.jsp");
			} 
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException 
	{
		return EVAL_PAGE;
	}

	//GET y SET
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
