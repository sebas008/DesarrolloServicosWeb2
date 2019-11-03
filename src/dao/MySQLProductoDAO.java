package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySQLConexion;

public class MySQLProductoDAO implements ProductoDAO
{
	@Override
	public ProductoDTO buscar(String codigo) 
	{
		ProductoDTO p = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_producto where cod_prod = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();
			while(rs.next())
			{
				p = new ProductoDTO();
				p.setCodigo(rs.getString(1));
				p.setCodCategoria(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setMarca(rs.getString(4));
				p.setUniMed(rs.getString(5));
				p.setStockAct(rs.getInt(6));
				p.setStockMin(rs.getInt(7));
				p.setPrecio(rs.getDouble(8));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al buscar, " + e.getMessage());
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
		return p;
	}
}
