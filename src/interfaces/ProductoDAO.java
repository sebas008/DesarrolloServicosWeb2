package interfaces;

import beans.ProductoDTO;

public interface ProductoDAO 
{
	public ProductoDTO buscar(String codigo);
}
