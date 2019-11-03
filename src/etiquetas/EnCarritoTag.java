package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.CarritoDTO;

public class EnCarritoTag extends TagSupport
{
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException 
	{
		try
		{
			JspWriter out = pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			
			ArrayList<CarritoDTO> productos = (ArrayList<CarritoDTO>)request.getSession().getAttribute("carrito");
			int cantProductos = productos.size();
			
			if(cantProductos > 0)
				out.println("<span class='label label-danger'>" + cantProductos + "</span>");
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
}
