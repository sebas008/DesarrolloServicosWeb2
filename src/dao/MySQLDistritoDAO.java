package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DistritoDTO;
import interfaces.DistritoDAO;
import utils.MySQLConexion;

public class MySQLDistritoDAO implements DistritoDAO
{

	@Override
	public ArrayList<DistritoDTO> lista() 
	{
		ArrayList<DistritoDTO> listado = new ArrayList<DistritoDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_distrito;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next())
			{
				DistritoDTO d = new DistritoDTO();
				d.setCodigo(rs.getString(1));
				d.setNombre(rs.getString(2));
				
				listado.add(d);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al listar distritos");
		}
		finally
		{
			try
			{
				if(con != null) con.close();
				if(pst != null) pst.close();
			}
			catch(Exception e)
			{
				System.out.println("Error al cerrar");
			}
		}
		
		return listado;
	}

	@Override
	public DistritoDTO buscar(String codDistrito) 
	{
		DistritoDTO d = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_distrito where cod_dis = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, codDistrito);
			rs = pst.executeQuery();
			while(rs.next())
			{
				d = new DistritoDTO();
				d.setCodigo(rs.getString(1));
				d.setNombre(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al loguear");
		}
		finally
		{
			try
			{
				if(con != null) con.close();
				if(pst != null) pst.close();
			}
			catch(Exception e)
			{
				System.out.println("Error al cerrar");
			}
		}
		
		return d;
	}
}












