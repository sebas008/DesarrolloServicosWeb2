package dao;

import interfaces.CarritoDAO;
import interfaces.DistritoDAO;
import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import interfaces.VentaDAO;

public class MySQLDAOFactory extends DAOFactory
{
	@Override
	public UsuarioDAO getUsuarioDAO() 
	{
		return new MySQLUsuarioDAO();
	}

	@Override
	public DistritoDAO getDistritoDAO() 
	{
		return new MySQLDistritoDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() 
	{
		return new MySQLProductoDAO();
	}

	@Override
	public CarritoDAO getCarritoDAO() 
	{
		return new MySQLCarritoDAO();
	}

	@Override
	public VentaDAO getVentaDAO() 
	{
		return new MySQLVentaDAO();
	}
}
