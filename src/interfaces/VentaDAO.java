package interfaces;

import java.util.ArrayList;

import beans.CarritoDTO;
import beans.VentaDTO;

public interface VentaDAO 
{
	public int transaccion(VentaDTO venta, ArrayList<CarritoDTO> detalleVenta);
	
	public String ultimoNumVenta();
	
	public VentaDTO ultimaVentaXUsuario(String codigoU);
}
