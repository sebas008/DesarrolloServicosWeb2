package services;

import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ProductoDAO;

public class ProductoService implements ProductoDAO
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	ProductoDAO dao = fabrica.getProductoDAO();

	@Override
	public ProductoDTO buscar(String codigo) 
	{
		return dao.buscar(codigo);
	}
}
