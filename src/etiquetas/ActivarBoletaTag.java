package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import beans.VentaDTO;

public class ActivarBoletaTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	String codUsuario = "";

	public int doStartTag() throws JspException 
	{
		try 
		{
			JspWriter out = pageContext.getOut();
			VentaDTO ven = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/ventaRest/ultimaVentaXUsuario/" + codUsuario).request(MediaType.APPLICATION_JSON).get(VentaDTO.class);
			
			if(ven.getNumVenta() != null)
			{
				out.println("<a href='BoletaServlet' class='btn btn-success btn-block' style='color:#FFFFFF'>" +
							"Boleta <span class='glyphicon glyphicon-file'></span></a>");
			}
			else
			{
				out.println("<a href='#' class='btn btn-success btn-block disabled' style='color:#FFFFFF'>" +
							"Boleta <span class='glyphicon glyphicon-file'></span></a>");
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
	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
}
