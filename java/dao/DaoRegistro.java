package dao;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	
	 private boolean existe(Usuario u) {
		 
		 
		 return true;
	}
	 
	/**Método de insercion en la BD del objeto usuario.
	 * 
	 * @param u Objeto tipo usuarios.
	 * @throws SQLException
	 */
	public void insertar(Usuario  u, String pass) throws SQLException {
		String hashedPass = hashMD5(pass);
	
		String sql = "INSERT INTO altausuario (nombre,apellidos,telefono,direccion,email,pass,permiso) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
	
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setString(3, u.getTelefono());
		ps.setString(4, u.getDireccion());
		ps.setString(5, u.getEmail());
		ps.setString(6, hashedPass);
		ps.setInt(7, u.getPermiso());
		
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * Actualiza los datos de un usuario en la base de datos.
	 * 
	 * @param u el usuario con los datos actualizados
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */

	public void actualizar(Usuario u) throws SQLException {
		String sql = "UPDATE altausuario SET nombre=?,apellidos=?,telefono=?,direccion=?,email=?,permiso=? WHERE id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setString(3, u.getTelefono());
		ps.setString(4, u.getDireccion());
		ps.setString(5, u.getEmail());
		ps.setInt(6, u.getPermiso());
		ps.setInt(7, u.getId());
		
	
		int filas = ps.executeUpdate();
		ps.close();  
	}
	
	
	/**
	 * Elimina un usuario de la base de datos por su identificador.
	 * 
	 * @param id el identificador del usuario a eliminar
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	
	public void borrar(int id) throws SQLException {
		
		String sql= "DELETE FROM  altausuario WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		int filas = ps.executeUpdate();
		ps.close();  
	}
	
	/**
	 * Obtiene un usuario de la base de datos por su identificador.
	 * 
	 * @param id el identificador del usuario a obtener
	 * @return el usuario obtenido
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public Usuario obtenerPorId (int id) throws SQLException {
		
		String sql = "SELECT * FROM altausuario WHERE id =?";
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1,id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		Usuario  u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
		return u;
	}

	/**
	 * Obtiene una lista de todos los usuarios almacenados en la base de datos.
	 * 
	 * @return una lista de usuarios
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public ArrayList<Usuario> listar() throws SQLException{
		
		PreparedStatement ps = con.prepareStatement("SELECT id, nombre, apellidos, telefono, direccion, email, permiso FROM altausuario");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;
		
		while(rs.next()) {
			
			if(ls == null) {
				ls = new ArrayList<Usuario>();
				
				}
			
				ls.add(new Usuario (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
		}
		
		return ls;
		
	}
	/**
	 * Obtiene una lista de usuarios de la base de datos filtrados por tipo.
	 * 
	 * @param tipo el tipo de usuario a filtrar
	 * @return una lista de usuarios del tipo especificado
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	
     public ArrayList<Usuario> listar(int tipo) throws SQLException{
		
		String sql = "SELECT id, nombre, apellidos, telefono, direccion, email, permiso FROM altausuario WHERE permiso=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, tipo);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;
		
		while(rs.next()) {
			
			if(ls == null) {
				ls = new ArrayList<Usuario>();
				
				}
			
				ls.add(new Usuario (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
				
		}
		
		return ls;
		
	}
     
     /**
      * Realiza el proceso de inicio de sesión para un usuario.
      * 
      * @param u el usuario que intenta iniciar sesión
      * @param hashedPass la contraseña del usuario ya encriptada
      * @return el usuario si el inicio de sesión es exitoso, null en caso contrario
      * @throws SQLException si ocurre un error al acceder a la base de datos
      */
    
     public Usuario logeando(Usuario u, String hashedPass) throws SQLException {
    	    
    	 String sql = "SELECT id, nombre, apellidos, telefono, direccion, email, permiso FROM altausuario WHERE email=? AND pass=?";
    	    PreparedStatement ps = con.prepareStatement(sql);
    	    
    	    ps.setString(1, u.getEmail());
    	    ps.setString(2, hashedPass);
    	    
    	    ResultSet rs = ps.executeQuery();
    	    
    	    if (rs.next()) {
    	    
    	       Usuario aux = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
    	        return aux;
    	    } else {
    	    
    	        return null;
    	    }
    	}
     
     /**
      * Obtiene un usuario de la base de datos por su identificador, incluyendo su permiso.
      * 
      * @param id el identificador del usuario a obtener
      * @return el usuario obtenido, incluyendo su permiso
      * @throws SQLException si ocurre un error al acceder a la base de datos
      */
    
     public Usuario obtenerPermisoPorId (int id) throws SQLException {
 		
 		String sql = "SELECT * FROM altausuario WHERE id =?";
 		PreparedStatement ps = con.prepareStatement (sql);
 		ps.setInt(1,id);
 		
 		ResultSet rs = ps.executeQuery();
 		rs.next();
 		
 		Usuario  u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
 		return u;
 	}

     /**
      * Devuelve la representación JSON de todos los usuarios almacenados en la base de datos.
      * 
      * @return la representación JSON de los usuarios
      * @throws SQLException si ocurre un error al acceder a la base de datos
      */
	public String listarJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}
	
	private String hashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashedText = number.toString(16);

            // Padding to ensure the hash length is 32 characters
            while (hashedText.length() < 32) {
                hashedText = "0" + hashedText;
            }
            return hashedText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * Devuelve la representación JSON de todos los usuarios almacenados en la base de datos filtrados por tipo.
	 * 
	 * @param tipoUsuario el tipo de usuario a filtrar
	 * @return la representación JSON de los usuarios del tipo especificado
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public String listarJson(int tipo) throws SQLException {
 		
		String json = "";	
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar(tipo));
		
		return json;
	
	  }
	
    
	
	}
