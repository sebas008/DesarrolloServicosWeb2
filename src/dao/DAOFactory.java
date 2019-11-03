package dao;

import interfaces.CarritoDAO;
import interfaces.DistritoDAO;
import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import interfaces.VentaDAO;

public abstract class DAOFactory 
{
	public static final int MYSQL = 1;
	
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract DistritoDAO getDistritoDAO();
	public abstract ProductoDAO getProductoDAO();
	public abstract CarritoDAO getCarritoDAO();
	public abstract VentaDAO getVentaDAO();
	
	//CONSTRUCTOR DE UNA CLASE ABSTRACTA
	public static DAOFactory getDAOFactory(int db)
	{
		switch(db)
		{
			case MYSQL:
				return new MySQLDAOFactory();
			default:
				return null;
		}
	}
}
