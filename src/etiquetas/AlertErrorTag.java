package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AlertErrorTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	String mensaje = "";
	
	public int doStartTag() throws JspException 
	{
		try 
		{
			JspWriter out = pageContext.getOut();
			
			if(!mensaje.equals(""))
			{
				out.println("<div class='alert alert-danger alert-dismissible fade in'>" +
							"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
							"<strong>Error!</strong> " + mensaje +
							"</div>");
			}
		} 
		catch (IOException e) 
		{
			throw new JspException("Error: " + e.getMessage());
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException 
	{
		return EVAL_PAGE;
	}

	//GET Y SET
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
