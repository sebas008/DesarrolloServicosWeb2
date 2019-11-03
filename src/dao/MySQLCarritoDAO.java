package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.CarritoDTO;
import beans.ProductoDTO;
import interfaces.CarritoDAO;
import services.ProductoService;
import utils.MySQLConexion;

public class MySQLCarritoDAO implements CarritoDAO
{
	@Override
	public ArrayList<CarritoDTO> listarXcliente(String codigo) 
	{
		ArrayList<CarritoDTO> listado = new ArrayList<CarritoDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "{call sp_historial(?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();
			while(rs.next())
			{
				CarritoDTO c = new CarritoDTO();
				c.setFecha(rs.getString(1));
				c.setCodigo(rs.getString(2));
				c.setCantidad(rs.getInt(3));
				c.setSubTotal(rs.getDouble(4));
				
				ProductoDTO p = new ProductoService().buscar(c.getCodigo());
				c.setDescripcion(p.getDescripcion());
				c.setMarca(p.getMarca());
				c.setPrecio(p.getPrecio());
				
				listado.add(c);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al listar carrito, " + e.getMessage());
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
	public ArrayList<CarritoDTO> listarXfecha(String codigo, String fecha) 
	{
		ArrayList<CarritoDTO> listado = new ArrayList<CarritoDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "{call sp_historial_fecha(?, ?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			pst.setString(2, fecha);
			rs = pst.executeQuery();
			while(rs.next())
			{
				CarritoDTO c = new CarritoDTO();
				c.setFecha(rs.getString(1));
				c.setCodigo(rs.getString(2));
				c.setCantidad(rs.getInt(3));
				c.setSubTotal(rs.getDouble(4));
				
				ProductoDTO p = new ProductoService().buscar(c.getCodigo());
				c.setDescripcion(p.getDescripcion());
				c.setMarca(p.getMarca());
				c.setPrecio(p.getPrecio());
				
				listado.add(c);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al listar carrito X fecha, " + e.getMessage());
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
	public ArrayList<CarritoDTO> listarUltimaVenta(String numVenta, String codUsuario) 
	{
		ArrayList<CarritoDTO> listado = new ArrayList<CarritoDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "{call sp_ultima_venta(?, ?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, numVenta);
			pst.setString(2, codUsuario);
			rs = pst.executeQuery();
			while(rs.next())
			{
				CarritoDTO c = new CarritoDTO();
				c.setFecha(rs.getString(1));
				c.setCodigo(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setPrecio(rs.getDouble(4));
				c.setMarca(rs.getString(5));
				c.setCantidad(rs.getInt(6));
				c.setSubTotal(rs.getDouble(7));
				
				listado.add(c);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al listar ultima venta, " + e.getMessage());
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
}
