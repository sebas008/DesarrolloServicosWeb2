package beans;

public class ProductoDTO
{
	String codigo, codCategoria, descripcion, marca, uniMed;
	int stockAct, stockMin;
	double precio;
	
	/*
	 * Adicional
	 */
	int cantidadVendida;

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

	public String getCodCategoria()
	{
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria)
	{
		this.codCategoria = codCategoria;
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

	public String getUniMed()
	{
		return uniMed;
	}

	public void setUniMed(String uniMed)
	{
		this.uniMed = uniMed;
	}

	public int getStockAct()
	{
		return stockAct;
	}

	public void setStockAct(int stockAct)
	{
		this.stockAct = stockAct;
	}

	public int getStockMin()
	{
		return stockMin;
	}

	public void setStockMin(int stockMin)
	{
		this.stockMin = stockMin;
	}

	public double getPrecio()
	{
		return precio;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
	}

	public int getCantidadVendida()
	{
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida)
	{
		this.cantidadVendida = cantidadVendida;
	}
}
