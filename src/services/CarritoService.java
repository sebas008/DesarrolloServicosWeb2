package services;

import java.util.ArrayList;

import beans.CarritoDTO;
import dao.DAOFactory;
import interfaces.CarritoDAO;

public class CarritoService implements CarritoDAO
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	CarritoDAO dao = fabrica.getCarritoDAO();
	
	@Override
	public ArrayList<CarritoDTO> listarXcliente(String codigo) 
	{
		return dao.listarXcliente(codigo);
	}

	@Override
	public ArrayList<CarritoDTO> listarXfecha(String codigo, String fecha) 
	{
		return dao.listarXfecha(codigo, fecha);
	}

	@Override
	public ArrayList<CarritoDTO> listarUltimaVenta(String numVenta, String codUsuario) 
	{
		return dao.listarUltimaVenta(numVenta, codUsuario);
	}
}
