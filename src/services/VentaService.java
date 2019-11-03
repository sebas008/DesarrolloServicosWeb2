package services;

import java.util.ArrayList;

import beans.CarritoDTO;
import beans.VentaDTO;
import dao.DAOFactory;
import interfaces.VentaDAO;

public class VentaService implements VentaDAO
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	VentaDAO dao = fabrica.getVentaDAO();
	
	@Override
	public int transaccion(VentaDTO venta, ArrayList<CarritoDTO> detalleVenta) 
	{
		return dao.transaccion(venta, detalleVenta);
	}
	
	@Override
	public String ultimoNumVenta() 
	{
		return dao.ultimoNumVenta();
	}

	@Override
	public VentaDTO ultimaVentaXUsuario(String codigoU) 
	{
		return dao.ultimaVentaXUsuario(codigoU);
	}
}
