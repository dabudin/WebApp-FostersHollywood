package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import model.Producto;

public class DAOProducto {
	
	public ArrayList<Producto> getProductosByCategoria(int categoriaid) {
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		Connection con = Conexion.conecta();
		ResultSet rs;
		PreparedStatement ps;
		
		try {
				
			String sql = "select * from producto where categoriaid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, categoriaid);
			rs = ps.executeQuery();
			
			while (rs.next()) {	
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setTitulo(rs.getString("titulo"));
				producto.setBody(rs.getString("body"));
				producto.setCategoriaid(rs.getInt("categoriaid"));
				producto.setImagen(rs.getString("imagen"));
				producto.setFondo(rs.getString("fondo"));
				producto.setSumario(rs.getString("sumario"));
				
				productos.add(producto);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
		return productos;
	}
	
	public Producto getProductoById(int id) {
		
		Producto producto = new Producto();
		
		Connection con = Conexion.conecta();
		ResultSet rs;
		PreparedStatement ps;
		
		try {
				
			String sql = "select * from producto where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			rs.next();
			producto.setId(rs.getInt("id"));
			producto.setTitulo(rs.getString("titulo"));
			producto.setBody(rs.getString("body"));
			producto.setCategoriaid(rs.getInt("categoriaid"));
			producto.setImagen(rs.getString("imagen"));
			producto.setFondo(rs.getString("fondo"));
			producto.setSumario(rs.getString("sumario"));
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
		return producto;
	}

}
