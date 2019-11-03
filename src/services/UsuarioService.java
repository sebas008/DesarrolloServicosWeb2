package services;

import java.util.ArrayList;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

public class UsuarioService implements UsuarioDAO
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	UsuarioDAO dao = fabrica.getUsuarioDAO();

	@Override
	public UsuarioDTO login(String email, String clave) 
	{
		return dao.login(email, clave);
	}

	@Override
	public int registrar(UsuarioDTO u) 
	{
		return dao.registrar(u);
	}

	@Override
	public String ultimoCodUsuario() 
	{
		return dao.ultimoCodUsuario();
	}

	@Override
	public ArrayList<UsuarioDTO> listado() 
	{
		return dao.listado();
	}

	@Override
	public int actualizar(UsuarioDTO u) 
	{
		return dao.actualizar(u);
	}
}
