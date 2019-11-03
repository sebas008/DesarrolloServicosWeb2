package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion 
{
	public static Connection getConexion() 
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ferreteriaWeb";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException ex) {
			System.out.println("No hay Driver!!");
		} catch (SQLException ex) {
			System.out.println("Error al conectar con la BD");
		}
		return con;
	}
}
