package interfaces;

import java.util.ArrayList;

import beans.DistritoDTO;

public interface DistritoDAO 
{
	public ArrayList<DistritoDTO> lista();
	
	public DistritoDTO buscar(String codDistrito);
}
