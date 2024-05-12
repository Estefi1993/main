package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;


import modelo.Usuario;

//TAD  clase arrayList enviar al cliente la lista hacer una clase tad -DAO persistencia
public class DaoRegistro {

	
	public static Connection con = null;
	
	public DaoRegistro() throws SQLException {
		
		this.con = dbconexion.getConexion();
	}
	
	/**Método de insercion en la BD del objeto usuario.
	 * 
	 * @param u Objeto tipo usuarios.
	 * @throws SQLException
	 */
	public void insertar(Usuario  u) throws SQLException {
		String sql = "INSERT INTO altausuario (nombre,apellidos,direccion,telefono,email) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setString(3, u.getTelefono());
		ps.setString(4, u.getDireccion());
		ps.setString(5, u.getEmail());
	
		int filas = ps.executeUpdate();
		ps.close();
	}
	

	
	public void actualizar(Usuario u) throws SQLException {
		String sql = "UPDATE altausuario SET nombre=?,apellidos=?,telefono=?,direccion=?,email=? WHERE id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setString(3, u.getTelefono());
		ps.setString(4, u.getDireccion());
		ps.setString(5, u.getEmail());
		ps.setInt(6, u.getId());
	
		int filas = ps.executeUpdate();
		ps.close();  
		}
	
	public void borrar(int id) throws SQLException {
		
		String sql= "DELETE FROM  altausuario WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		int filas = ps.executeUpdate();
		ps.close();  
	}
	
	public Usuario obtenerPorId (int id) throws SQLException {
		
		String sql = "SELECT * FROM altausuario WHERE id = ?";
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1,id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		Usuario  u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
		return u;
	}

	
	public ArrayList<Usuario> listar() throws SQLException{
		
		String sql = "SELECT * FROM altausuario";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;
		
		while(rs.next()) {
			
			if(ls == null) {
				ls = new ArrayList<Usuario>();
				
				}
			
				ls.add(new Usuario (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
		}
		
		return ls;
		
		
	}
	
	public String listarJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}
	
}
