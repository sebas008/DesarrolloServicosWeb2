package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySQLConexion;

public class MySQLUsuarioDAO implements UsuarioDAO
{
	@Override
	public ArrayList<UsuarioDTO> listado() 
	{
		ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_usuario;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next())
			{
				UsuarioDTO u = new UsuarioDTO();
				u.setCodigo(rs.getString(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setCodDistrito(rs.getString(6));
				u.setDireccion(rs.getString(7));
				u.setTelefono(rs.getString(8));
				u.setDni(rs.getString(9));
				
				usuarios.add(u);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al listar usuarios");
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
		
		return usuarios;
	}
	
	@Override
	public UsuarioDTO login(String email, String clave) 
	{
		UsuarioDTO u = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "{call sp_accesoUsuario(?, ?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, clave);
			
			rs = pst.executeQuery();
			while(rs.next())
			{
				u = new UsuarioDTO();
				u.setCodigo(rs.getString(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setCodDistrito(rs.getString(6));
				u.setDireccion(rs.getString(7));
				u.setTelefono(rs.getString(8));
				u.setDni(rs.getString(9));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al loguear, " + e.getMessage());
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
		
		return u;
	}

	@Override
	public int registrar(UsuarioDTO u) 
	{
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			//insert into tb_usuario values('C001', 'Jose', 'Damaso', 'profe@gmail.com', 'poo', 'D001', 'Av. POO', '927364332', '12645345');
			String sql = "insert into tb_usuario values(?, ?, ?, ?, ?, ?, ?, ?, ?, default);";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getCodigo());
			pst.setString(2, u.getNombre());
			pst.setString(3, u.getApellido());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getClave());
			pst.setString(6, u.getCodDistrito());
			pst.setString(7, u.getDireccion());
			pst.setString(8, u.getTelefono());
			pst.setString(9, u.getDni());
			
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error al registrar, " + e.getMessage());
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
		
		return rs;
	}
	
	@Override
	public int actualizar(UsuarioDTO u) 
	{
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "update tb_usuario set nombre = ?, apellido = ?, email = ?, clave = ?,"
					+ " cod_dis = ?, direccion = ?, telefono = ? where cod_usu = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getCodDistrito());
			pst.setString(6, u.getDireccion());
			pst.setString(7, u.getTelefono());
			pst.setString(8, u.getCodigo());
			
			resultado = pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error al actualizar, " + e.getMessage());
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
		return resultado;
	}

	@Override
	public String ultimoCodUsuario() 
	{
		String codigo = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = MySQLConexion.getConexion();
			String sql = "select max(cod_usu) from tb_usuario;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next())
			{
				codigo = rs.getString(1);
			}
			
			//Generar el codigo
			if(codigo == null)
				codigo = "C001";
			else
			{
				DecimalFormat df = new DecimalFormat("000");
				codigo = "C" + df.format(Integer.parseInt(codigo.substring(1)) + 1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al consultar el ultimo codigo usuario, " + e.getMessage());
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
		
		return codigo;
	}
}



