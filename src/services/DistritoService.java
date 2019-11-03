package services;

import java.util.ArrayList;

import beans.DistritoDTO;
import dao.DAOFactory;
import interfaces.DistritoDAO;

public class DistritoService implements DistritoDAO
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	DistritoDAO dao = fabrica.getDistritoDAO();

	@Override
	public ArrayList<DistritoDTO> lista() 
	{
		return dao.lista();
	}

	@Override
	public DistritoDTO buscar(String codDistrito) 
	{
		return dao.buscar(codDistrito);
	}
}
