package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ProductoDTO;
import services.ProductoService;

public class SeccionProductoTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	String codigo = "";
	
	public int doStartTag() throws JspException 
	{
		try 
		{
			JspWriter out = pageContext.getOut();
			ProductoDTO p = new ProductoService().buscar(codigo);
			
			if(p.getStockAct() > 0)
			{
				if(p.getStockAct() <= p.getStockMin())
				{
					out.println(
						"<div class='col-sm-4'>"+
						"<div class='panel panel-danger'>"+
					  		"<div class='panel-heading'>" + p.getDescripcion() + "</div>"+
				        	"<div class='panel-body'><img src='img/productos/todos/" + p.getCodigo() + ".jpg' class='img-responsive' style='width:100%' alt='Image'></div>"+
				        	"<div class='panel-footer'>"+
				        		"<a id='mas' class='btn btn-danger' data-toggle='modal' data-target='#" + p.getCodigo() + "'>"+
				        			"<span class='glyphicon glyphicon-plus'></span></a></div>"+
				        "</div></div>"
					);
				}
				else
				{
					out.println(
						"<div class='col-sm-4'>"+
						"<div class='panel panel-primary'>"+
					  		"<div class='panel-heading'>" + p.getDescripcion() + "</div>"+
				        	"<div class='panel-body'><img src='img/productos/todos/" + p.getCodigo() + ".jpg' class='img-responsive' style='width:100%' alt='Image'></div>"+
				        	"<div class='panel-footer'>"+
				        		"<a id='mas' class='btn btn-primary' data-toggle='modal' data-target='#" + p.getCodigo() + "'>"+
				        			"<span class='glyphicon glyphicon-plus'></span></a></div>"+
				        "</div></div>"
					);
				}
			}
			else
			{
				out.println(
					"<div class='col-sm-4'>"+
					"<div class='panel panel-danger'>"+
							"<div class='panel-heading'>" + p.getDescripcion() + "</div>"+
						"<div class='panel-body'><img src='img/productos/todos/" + p.getCodigo() + ".jpg' class='img-responsive' style='width:100%' alt='Image'></div>"+
						"<div class='panel-footer'>"+
							"<h5 id='agotadoMsg'>Stock agotado</h5></div>"+
					"</div></div>"
				);
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













