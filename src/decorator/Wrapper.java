package decorator;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

import beans.CarritoDTO;

public class Wrapper extends TableDecorator
{
	public String getFormatoPrecio()
	{
		CarritoDTO c = (CarritoDTO)getCurrentRowObject();
		DecimalFormat df = new DecimalFormat("######.00");
		
		return "S/." + df.format(c.getPrecio());
	}
	
	public String getFormatoSubTotal()
	{
		CarritoDTO c = (CarritoDTO)getCurrentRowObject();
		DecimalFormat df = new DecimalFormat("######.00");
		
		return "S/." + df.format(c.getSubTotal());
	}
	
	public String getFormatoFecha() throws ParseException
	{
		CarritoDTO c = (CarritoDTO)getCurrentRowObject();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfUsuario = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdfUsuario.format(sdf.parse(c.getFecha()));
	}
	
	public String getImagen()
	{
		CarritoDTO c = (CarritoDTO)getCurrentRowObject();
		
		return "<img src='img/productos/todos/" + c.getCodigo() + ".jpg' alt='imagen' width='82'>";
	}
	
	public String getEliminar()
	{
		CarritoDTO c = (CarritoDTO)getCurrentRowObject();
		int posicion = getListIndex();
		
		return "<a data-toggle='modal' data-target='#modalH" + posicion + "'><img src='img/tacho.png' alt='tacho'></a>"+
		"<div class='modal fade' id='modalH" + posicion + "' role='dialog'>" +
	    "<div class='modal-dialog modal-sm'>"+
	      "<div class='modal-content'>"+
	        "<div class='modal-body'>"+
	          "<p>Eliminar:</p>"+
	          "<h5><strong>" + c.getDescripcion() + "</strong></h5><br>"+
	          "<a class='btn btn-default' data-dismiss='modal'>NO</a>    "+
	          "<a class='btn btn-info' href='VentaServlet?tipo=eliminar&posicion=" + posicion + "'>SI</a>"+
	        "</div>"+
	      "</div></div></div>";
	}
	
	public String getEditar()
	{
		CarritoDTO c = (CarritoDTO)getCurrentRowObject();
		int posicion = getListIndex();
		
		return "<a data-toggle='modal' data-target='#modalEDT" + posicion + "'>Editar</a>"+
		"<div class='modal fade' id='modalEDT" + posicion + "' role='dialog'>" +
	    "<div class='modal-dialog modal-sm'>"+
	      "<div class='modal-content'>"+
	        "<div class='modal-body'>"+
	          "<p>Editar:</p>"+
	          "<h5><strong>" + c.getDescripcion() + "</strong></h5><br>"+
	          	"<form action='VentaServlet?tipo=editar&posicion=" + posicion + "&codigo=" + c.getCodigo() + "' method='post'>"+
	          		"<input class='form-control' type='number' name='cantidadEDT' placeholder='cantidad' min='1' max='10' required>"+
	          		"<br>"+
	          		"<a class='btn btn-default' data-dismiss='modal'>Cancelar</a>    "+
	          		"<input class='btn btn-info' type='submit' value='OK'>"+
				"</form>"+
	        "</div>"+
	      "</div></div></div>";
	}
}
