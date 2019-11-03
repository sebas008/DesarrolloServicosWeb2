package interfaces;

import java.util.ArrayList;

import beans.CarritoDTO;

public interface CarritoDAO 
{
	ArrayList<CarritoDTO> listarXcliente(String codigo);
	ArrayList<CarritoDTO> listarXfecha(String codigo, String fecha);
	ArrayList<CarritoDTO> listarUltimaVenta(String numVenta, String codUsuario);
}
