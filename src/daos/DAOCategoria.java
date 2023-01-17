package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Categoria;

public class DAOCategoria {
	
	public ArrayList<Categoria> getCategorias() {
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		Connection con = Conexion.conecta();
		ResultSet rs;
		Statement st;
		
		try {
			
			st = con.createStatement();
			String sql = "select * from categoria";
			rs = st.executeQuery(sql);
			
			while (rs.next()) {	
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre"));
				categoria.setDescripcion(rs.getString("descripcion"));
				categoria.setGuarnicion(rs.getString("guarnicion"));
				categorias.add(categoria);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
		return categorias;
	}
	
}
