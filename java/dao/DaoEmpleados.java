package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Empleado;


public class DaoEmpleados {

	
	
public static Connection con = null;
	
	public DaoEmpleados() throws SQLException {
		
		this.con = dbconexion.getConexion();
	
	}

	
	public void insertar(Empleado u) throws SQLException {
		
		String sql = "INSERT INTO empleado (nombre,apellidos,telefono,direccion,especialidad,email) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setString(3, u.getTelefono());
		ps.setString(4, u.getDireccion());
		ps.setString(5, u.getEspecialidad());
		ps.setString(6, u.getEmail());
	
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	
	public void actualizar(Empleado u) throws SQLException {
		String sql = "UPDATE empleado SET nombre=?,apellidos=?,telefono=?,direccion=?,especialidad=?,email=? WHERE id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setString(3, u.getTelefono());
		ps.setString(4, u.getDireccion());
		ps.setString(5, u.getEspecialidad());
		ps.setString(6, u.getEmail());
		ps.setInt(7,u.getId());
		
	
		int filas = ps.executeUpdate();
		ps.close();  
		}
	
	public void borrar(int id) throws SQLException {
		
		String sql= "DELETE FROM  empleado WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		int filas = ps.executeUpdate();
		ps.close();  
	}
	

	public Empleado obtenerPorId (int id) throws SQLException {
		
		String sql = "SELECT * FROM empleado WHERE id = ?";
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		Empleado u = new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		return u;
	}

	
		public Empleado logeando(Empleado u, String pass) throws SQLException {
			
		String sql = "SELECT * FROM empleado WHERE email= ? AND pass=?";
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setString(1, u.getEmail());
		ps.setString(2, pass);
			
		ResultSet rs = ps.executeQuery();
		rs.next();
			

		Empleado aux = new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		return aux;
		
		
	}
	
	public ArrayList<Empleado> listar() throws SQLException{
		String sql = "SELECT * FROM empleado ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Empleado> ls = null;
		
		while(rs.next()) {
			
			if(ls == null) {
				ls = new ArrayList<Empleado>();
				}
				ls.add(new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
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
