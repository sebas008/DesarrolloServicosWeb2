package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import beans.ProductoDTO;

public class ModalProductoTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	String codigo = "";
	
	public int doStartTag() throws JspException 
	{
		try 
		{
			JspWriter out = pageContext.getOut();
			ProductoDTO p = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/productoRest/buscar/" + codigo).request(MediaType.APPLICATION_JSON).get(ProductoDTO.class);

			out.println(
				"<div id='" + codigo + "' class='modal fade' role='dialog'>" +
					"<div class='modal-dialog'>" +
			
						"<div class='modal-content'>" +
							"<div class='modal-header'>" +
								"<button type='button' class='close' data-dismiss='modal'>&times;</button>" +
								"<h4 class='modal-title'><strong>" + p.getDescripcion() + "</strong></h4>" +
							"</div>" +
							
							"<div class='modal-body'>" +
								"<form action='VentaServlet?tipo=agregar' method='post' class='form-horizontal'>" +
									"<!-- Input oculto que almacenara el codigo -->" +
									"<input type='hidden' name='codigo' value='" + p.getCodigo() + "'>" +
									"<!------------------------------------------->" +
									"<div id='imgCont'>" +
										"<div class='easyzoom easyzoom--overlay'>"+
											"<a href='img/productos/todos/" + p.getCodigo() + ".jpg'>"+
												"<img id='imgProd' src='img/productos/todos/" + p.getCodigo() + ".jpg' alt='Lights'>" +
											"</a>" +
									"</div></div>" +
									
									"<div class='form-group'>" +
										"<label class='control-label col-sm-2'>Marca:</label>" +
										"<div class='col-sm-10'>" +
											"<p class='form-control-static'>" + p.getMarca() + "</p>" +
										"</div>" +
									"</div>" +
									"<div class='form-group'>" +
										"<label class='control-label col-sm-2'>Stock:</label>" +
										"<div class='col-sm-10'>" +
											"<p class='form-control-static'>" + p.getStockAct() + "</p>" +
										"</div>" +
									"</div>" +
									"<div class='form-group'>" +
										"<label class='control-label col-sm-2'>Precio:</label>" +
										"<div class='col-sm-10'>" +
											"<p class='form-control-static'> S/." + p.getPrecio() + "</p>" +
										"</div>" +
									"</div>" +
									"<div class='form-group'>" +
										"<label class='control-label col-sm-2'>Cantidad:</label>" +
										"<div class='col-sm-10'>" +
											"<input id='txtCantidad' class='form-control' name='cantidad' type='number' placeholder='cantidad' min='1' max='10' required>" +
										"</div>" +
									"</div>" +
									"<div class='form-group'>" +
										"<div class='col-sm-12'>" +
											"<input type='submit' id='btnAgregar' class='btn btn-lg btn-block' value='Agregar al carrito'>" +
										"</div>" +
									"</div>" +
								"</form>" +
							"</div>" +
							
							"<div class='modal-footer'>" +
								"<button type='button' class='btn btn-sm' id='cerrarModal' data-dismiss='modal'>Cerrar</button>" +
							"</div>" +
						"</div>" +
						
					"</div>" +
				"</div>"
			);
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
