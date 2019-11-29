package beans;

public class CarritoDTO
{
	String codigo, descripcion, marca, fecha;
	int cantidad;
	double precio, subTotal;

	/*
	 * Get y Set
	 */
	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public int getCantidad()
	{
		return cantidad;
	}

	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}

	public double getPrecio()
	{
		return precio;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
	}

	public double getSubTotal()
	{
		return subTotal;
	}

	public void setSubTotal(double subTotal)
	{
		this.subTotal = subTotal;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}
}
