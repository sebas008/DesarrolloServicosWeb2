package etiquetas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ProductosRandomTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() throws JspException 
	{
		DecimalFormat df = new DecimalFormat("000");
		int generado = 0;
		
		ArrayList<Integer> numeros_usados = new ArrayList<Integer>();
		while(numeros_usados.size() < 6)
		{
			generado = new Random().nextInt(81) + 1;
			
			if(!numeros_usados.contains(generado) && generado != 52)
			{
				numeros_usados.add(generado);
			}
		}
		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		for(int i = 0; i < numeros_usados.size(); i++)
		{
			request.setAttribute("random" + i, "P" + df.format(numeros_usados.get(i)));
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException 
	{
		return EVAL_PAGE;
	}
}
