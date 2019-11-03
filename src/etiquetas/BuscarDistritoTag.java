package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.DistritoDTO;
import services.DistritoService;

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
				DistritoDTO d = new DistritoService().buscar(codigo);
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
