package etiquetas;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TotalVentaTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	double decimal = 0.0;

	public int doStartTag() throws JspException 
	{
		try
		{
			JspWriter out = pageContext.getOut();
			DecimalFormat df = new DecimalFormat("######.00");
			
			out.println("S/." + df.format(decimal));
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
	public double getDecimal() {
		return decimal;
	}

	public void setDecimal(double total) {
		this.decimal = total;
	}
}
