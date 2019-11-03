package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.DistritoDTO;
import services.DistritoService;

public class DistritoTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	String seleccionar = "";

	public int doStartTag() throws JspException 
	{
		try 
		{
			JspWriter out = pageContext.getOut();
			
			DistritoService servicio = new DistritoService();
			ArrayList<DistritoDTO> listado = servicio.lista();
			
			for(DistritoDTO d : listado)
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
