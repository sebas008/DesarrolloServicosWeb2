package beans;

import java.util.ArrayList;

public class VentaDTO
{
	String numVenta, codCliente, fecha;
	
	/*
	 * Adicionales
	 */
	ArrayList<CarritoDTO> detalle;

	/*
	 * Get y Set
	 */
	public String getNumVenta()
	{
		return numVenta;
	}

	public void setNumVenta(String numVenta)
	{
		this.numVenta = numVenta;
	}

	public String getCodCliente()
	{
		return codCliente;
	}

	public void setCodCliente(String codCliente)
	{
		this.codCliente = codCliente;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	public ArrayList<CarritoDTO> getDetalle()
	{
		return detalle;
	}

	public void setDetalle(ArrayList<CarritoDTO> detalle)
	{
		this.detalle = detalle;
	}
}
