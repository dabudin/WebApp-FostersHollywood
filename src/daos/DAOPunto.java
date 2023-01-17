package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;

public class DAOPunto {
	
	public Integer getPuntosByProducto(int idproducto) {
		
		Integer puntos = 0;
		
		Connection con = Conexion.conecta();
		ResultSet rs;
		PreparedStatement ps;
		
		try {
			
			String sql = "select round(avg(puntos), 0) pts from punto where idproducto=? group by idproducto";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idproducto);
			rs = ps.executeQuery();
			
			rs.next();
			puntos = rs.getInt("pts");
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
		return puntos;
	}
	
	public void insertPuntos(int idproducto, int puntos) {
		
		Connection con = Conexion.conecta();
		PreparedStatement ps;
		Statement st;
		ResultSet rs;
		
		
		try {
			
			String idSql = "select max(id) id from punto";
			st = con.createStatement();
			rs = st.executeQuery(idSql);
			rs.next();
			
			int id = rs.getInt("id") + 1;
			
			rs.close();
			st.close();
				
			String sql = "insert into punto values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, idproducto);
			ps.setInt(3, puntos);
			ps.executeUpdate();
	
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
	}

}
