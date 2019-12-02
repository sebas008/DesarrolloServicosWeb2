package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import beans.DistritoDTO;

public class BuscarDistritoTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	String codigo = "";
	
	public int doStartTag() throws JspException 
	{
		try
		{
			JspWriter out = pageContext.getOut();
			
			if(codigo != "")
			{
				DistritoDTO d = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/distritoRest/buscar/" + codigo).request(MediaType.APPLICATION_JSON).get(DistritoDTO.class);
				out.println(d.getNombre());
			}
			else
			{
				out.println("Nada");
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
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
