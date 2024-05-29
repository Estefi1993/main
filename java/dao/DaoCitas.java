package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;
import modelo.citas;

public class DaoCitas {

	
	
	public static Connection con = null;
	
	public DaoCitas() throws SQLException {
		
		this.con = dbconexion.getConexion();
	}
	
	public void insertar (citas n) throws SQLException {
		String sql = "INSERT INTO citas (nombre,apellidos,fecha,hora,motivo) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, n.getNombre());
		ps.setString(2, n.getApellidos());
		ps.setObject(3, n.getFecha());
		ps.setObject(4, n.getHora());
		ps.setString(5, n.getMotivo());
		
		int fils = ps.executeUpdate();
	}
	
	public ArrayList<citas> listar() throws SQLException{
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM  citas");
		ResultSet rs = ps.executeQuery();
		
		ArrayList<citas>result = null;
		
		while(rs.next()){
			if(result == null) {
				result = new ArrayList<citas>();
			}
			result.add(new citas(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getTime(5),rs.getString(6)));
		}
		return result;
	}
	
	
	public void actualizar(citas u) throws SQLException {
		String sql = "UPDATE citas SET nombre=?,apellidos=?,fecha=?,hora=?,motivo=? WHERE id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setObject(3, u.getFecha());
		ps.setObject(4, u.getHora());
		ps.setString(5, u.getMotivo());
		ps.setInt(6, u.getId());
		
	
		int filas = ps.executeUpdate();
		ps.close();  
	}
	public citas obtenerPorId(int id) throws SQLException {
		
		String sql = "SELECT * FROM citas WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		citas u = new citas(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getTime(5),rs.getString(6));

		return u;
	}
	public void borrar(int id) throws SQLException {
		
		String sql= "DELETE FROM  citas WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		int filas = ps.executeUpdate();
		ps.close();  
	}
	
	public String listarJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}
}
