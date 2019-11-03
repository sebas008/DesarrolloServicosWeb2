package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import beans.CarritoDTO;
import beans.VentaDTO;
import interfaces.VentaDAO;
import utils.MySQLConexion;

public class MySQLVentaDAO implements VentaDAO
{
	@Override
	public int transaccion(VentaDTO venta, ArrayList<CarritoDTO> detalleVenta) 
	{
		int ok = 0;
		Connection con = null;
		PreparedStatement pst0 = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			//Iniciar transaccion
			/*
			 * REGISTRAR VENTA
			 */
			String sql0 = "insert into tb_ventas values(?, ?, ?);";
			pst0 = con.prepareStatement(sql0);
			pst0.setString(1, venta.getNumVenta());
			pst0.setString(2, venta.getFecha());
			pst0.setString(3, venta.getCodCliente());
			
			ok = pst0.executeUpdate();
			
			/*
			 * REGISTRAR DETALLE DE VENTA (PRODUCTOS EN CARRITO)
			 */
			String sql1 = "insert into tb_detalle_venta values(?, ?, ?, ?);";
			
			for(CarritoDTO c : detalleVenta)
			{
				pst1 = con.prepareStatement(sql1);
				pst1.setString(1, venta.getNumVenta());
				pst1.setString(2, c.getCodigo());
				pst1.setInt(3, c.getCantidad());
				pst1.setDouble(4, c.getSubTotal());
				
				ok = pst1.executeUpdate();
			}
			
			/*
			 * ACTUALIZAR EL STOCK DEL PRODUCTO
			 */
			String sql2 = "update tb_producto set stock_act = stock_act - ? where cod_prod = ? and stock_act - ? >= 0;";
			
			for(CarritoDTO c : detalleVenta)
			{
				pst2 = con.prepareStatement(sql2);
				pst2.setInt(1, c.getCantidad());
				pst2.setString(2, c.getCodigo());
				pst2.setInt(3, c.getCantidad());
				
				ok = pst2.executeUpdate();
			}
			
			//Fin de la transaccion
			con.commit();
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
				System.out.println("Error al comprar(transaccion), " + e.getMessage());
				ok = 0;
			}
			catch(SQLException ex)
			{
				System.out.println("Error en el rollback, " + ex.getSQLState());
			}
		}
		finally
		{
			try
			{
				if(con != null) con.close();
				if(pst0 != null) pst0.close();
				if(pst1 != null) pst1.close();
				if(pst2 != null) pst2.close();
			}
			catch(Exception e)
			{
				System.out.println("Error al cerrar");
			}
		}
		return ok;
	}

	@Override
	public String ultimoNumVenta() 
	{
		String ultimo = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "select max(num_venta) from tb_ventas;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next())
			{
				ultimo = rs.getString(1);
			}
			
			//Generar ultimo numVenta
			if(ultimo == null)
				ultimo = "V001";
			else
			{
				DecimalFormat df = new DecimalFormat("000");
				ultimo = "V" + df.format(Integer.parseInt(ultimo.substring(1)) + 1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al trar el ultimo numVenta, " + e.getMessage());
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
		
		return ultimo;
	}

	@Override
	public VentaDTO ultimaVentaXUsuario(String codigoU) 
	{
		VentaDTO ultimo = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "select max(num_venta), max(fec_Venta), cod_usu from tb_ventas where cod_usu = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigoU);
			rs = pst.executeQuery();
			while(rs.next())
			{
				ultimo = new VentaDTO();
				ultimo.setNumVenta(rs.getString(1));
				ultimo.setFecha(rs.getString(2));
				ultimo.setCodCliente(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al trar el ultimo numVenta por usuario, " + e.getMessage());
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
		
		return ultimo;
	}
}












