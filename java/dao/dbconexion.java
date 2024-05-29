package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Esta clase proporciona métodos para establecer y obtener una conexión a la base de datos MySQL.
 */
public class dbconexion {

	public static final  String JDBC_URL = "jdbc:mysql://localhost:3306/clinica1";
	public static Connection instance = null;
	
	/**
     * Obtiene una conexión a la base de datos.
     * 
     * @return la conexión a la base de datos
     * @throws SQLException si ocurre un error al conectar a la base de datos
     */
	public static  Connection getConexion () throws SQLException {
		
		if(instance == null) {
			
			//opcional
			Properties  props = new Properties();
			props.put("user", "root");
			props.put("password","");
			props.put("charset", "UTF-8");
			
			
			instance = DriverManager.getConnection(JDBC_URL, "root","");
		
		}
		
			return instance;
		
	}
	
}
