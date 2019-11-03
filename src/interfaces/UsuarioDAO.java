package interfaces;

import java.util.ArrayList;

import beans.UsuarioDTO;

public interface UsuarioDAO 
{
	public ArrayList<UsuarioDTO> listado();
	
	public UsuarioDTO login(String email, String clave);
	
	public int registrar(UsuarioDTO u);
	
	public int actualizar(UsuarioDTO u);
	
	public String ultimoCodUsuario();
}
