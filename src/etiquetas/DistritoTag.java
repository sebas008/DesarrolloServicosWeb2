package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import beans.DistritoDTO;

public class DistritoTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	String seleccionar = "";

	public int doStartTag() throws JspException 
	{
		try 
		{
			JspWriter out = pageContext.getOut();
			
			DistritoDTO[] distritos = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/distritoRest/listar").request(MediaType.APPLICATION_JSON).get(DistritoDTO[].class);
			
			for(DistritoDTO d : distritos)
			{
				if(d.getCodigo().equals(seleccionar))
					out.println("<option value='" + d.getCodigo() + "' selected>" + d.getNombre() + "</option>");
				else
					out.println("<option value='" + d.getCodigo() + "'>" + d.getNombre() + "</option>");
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

	//GET y SET
	public String getSeleccionar() {
		return seleccionar;
	}

	public void setSeleccionar(String seleccionar) {
		this.seleccionar = seleccionar;
	}
}
