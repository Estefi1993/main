package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;


import dao.DaoRegistro;
;

	/**
	 * Esta clase define el objeto usuario.
	 * Representa a los usuarios registrados en el sistema.
	 * Campos:
	 * - id: identificador único del usuario.
	 * - nombre: nombre del usuario.
	 * - apellidos: apellidos del usuario.
	 * - telefono: número de teléfono del usuario.
	 * - direccion: dirección del usuario.
	 * - email: dirección de correo electrónico del usuario.
	 * -permiso: el permiso asignado a cada usuario.
	 * 
	 * @author Estefanía Vázquez
	 * @version 1.0 (12/05/2024)
	 */

	public class Usuario {

		private int id;
		private String nombre;
		private String apellidos;
		private String telefono;
		private String direccion;
		private String email;
		private int permiso;
		
	
	
	/**
	 * Contructor para generar un objeto vacio de tipo usuario.
	 */
	public Usuario() {
	
	}

	/**
	 * 
	 * @param nombre contructor que inicializa el nombre de un objeto
	 * @param apellidos contructor que inicializa el apellidos de un objeto
	 * @param telefono contructor que inicializa el telefono de un objeto
	 * @param direccion contructor que inicializa el direccion de un objeto
	 * @param email contructor que inicializa el email de un objeto
	 * @param permiso contructor que inicializa el permiso de un objeto
	 */

	public Usuario(String nombre, String apellidos, String telefono, String direccion, String email,int permiso) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.permiso = permiso;
	}

	/**
	 * @param id contructor que inicializa el id de un objeto
	 * @param nombre contructor que inicializa el nombre de un objeto
	 * @param apellidos contructor que inicializa el apellidos de un objeto
	 * @param telefono contructor que inicializa el telefono de un objeto
	 * @param direccion contructor que inicializa el direccion de un objeto
	 * @param email contructor que inicializa el email de un objeto
	 * @param permiso contructor que inicializa el permiso de un objeto
	 */
	public Usuario(int id, String nombre, String apellidos, String telefono, String direccion, String email,
			 int permiso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.permiso = permiso;
	}


	/**
	 * Obtiene el identificador único del usuario.
	 * @return El identificador único del usuario.
	 */

	public int getId() {
		return id;
	}


	/**
	 * Establece el identificador único del usuario.
	 * @param id El nuevo identificador único del usuario.
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * Obtiene el nombre del usuario.
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * Establece el nombre del usuario.
	 * @param nombre El nuevo nombre del usuario.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene los apellidos del usuario.
	 * @return los apellidos del usuario.
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * Establece los apellidos del usuario.
	 * @param apellidos Los nuevos apellidos del usuario.
	 */

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Obtiene el teléfono del usuario.
	 * @return El teléfono del usuario.
	 */


	public String getTelefono() {
		return telefono;
	}



	/**
	 * Establece el número de teléfono del usuario.
	 * @param telefono El nuevo número de teléfono del usuario.
	 */

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene la dirección del usuario.
	 * @return La dirección del usuario.
	 */

	public String getDireccion() {
		return direccion;
	}


	/**
	 * Establece la dirección del usuario.
	 * @param direccion La nueva dirección del usuario.
	 */

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * Obtiene la dirección de correo electrónico del usuario.
	 * @return La dirección de correo electrónico del usuario.
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Establece la dirección de correo electrónico del usuario.
	 * @param email La nueva dirección de correo electrónico del usuario.
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * Obtiene el permiso de casa usuario
	 * @return
	 */
	
	public int getPermiso() {
		return permiso;
	}
	/**
	 * Establece el permiso de cada usuario.
	 * @param permiso
	 */
	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}

	
	
	/**
	 * Obtiene un usuario por su identificador.
	 * @param id  identificador del usuario a obtener.
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public void obtenerPorId(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		
		DaoRegistro dao = new DaoRegistro();
		Usuario aux = dao.obtenerPorId(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setApellidos(aux.getApellidos());
		this.setTelefono(aux.getTelefono());
		this.setDireccion(aux.getDireccion());
		this.setEmail(aux.getEmail());
		this.setPermiso(aux.getPermiso());
		
		
	}
	/**
	 * Obtiene el permiso de un usuario por su identificador.
	 * 
	 * @param id el identificador del usuario del cual se quiere obtener el permiso
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	
	public void obtenerPermisoPorId(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		
		DaoRegistro dao = new DaoRegistro();
		Usuario u = dao.obtenerPermisoPorId(id);
		
		this.setId(u.getId());
		this.setNombre(u.getNombre());
		this.setApellidos(u.getApellidos());
		this.setTelefono(u.getTelefono());
		this.setDireccion(u.getDireccion());
		this.setEmail(u.getEmail());
		this.setPermiso(u.getPermiso());
		
		
	}
	
	/**
	 * Realiza el proceso de inicio de sesión para un usuario.
	 * 
	 * @param hashedPass la contraseña del usuario ya encriptada
	 * @return true si el inicio de sesión es exitoso, false en caso contrario
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	
	public boolean logeo(String hashedPass) throws SQLException {
		
	      boolean ok = false;
	      DaoRegistro dao = new DaoRegistro();
	    
	      Usuario aux = dao.logeando(this, hashedPass);
	      
	      if (aux != null) {
	        
	         this.setId(aux.getId());
	         this.setNombre(aux.getNombre());
	         this.setApellidos(aux.getApellidos());
	         this.setTelefono(aux.getTelefono());
	         this.setDireccion(aux.getDireccion());
	         this.setEmail(aux.getEmail());
	         this.setPermiso(aux.getPermiso());
	         ok = true;
	      }

	      return ok;
	   }

  
	/**
	 * Convierte el objeto Usuario en formato JSON.
	 * @return Una cadena de texto que representa el objeto Usuario en formato JSON.
	 */

	public String dameJson() {
		
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;
		
	}
	
	/**
	 * Actualiza la información del usuario en la base de datos.
	 * @throws SQLException Si ocurre un error al acceder a la base de datos.
	 */
	public void actualizar() throws SQLException {
		DaoRegistro dao = new DaoRegistro();
		dao.actualizar(this);
		
	}

	/**
	 * Inserta un nuevo usuario en la base de datos.
	 * 
	 * @param hashedPass la contraseña del usuario ya encriptada
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public void insertar(String hashedPass) throws SQLException {
		// TODO Auto-generated method stub
		
		DaoRegistro dao = new DaoRegistro();
		dao.insertar(this,  hashedPass);
				
		
	}
	
	/**
	 * Borra el usuario de la base de datos.
	 * @throws SQLException Si ocurre un error al acceder a la base de datos.
	 */
	public void borrrar() throws SQLException {
		DaoRegistro dao = new DaoRegistro();
		dao.borrar(id);
		
	}




	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", email=" + email + ", permiso=" + permiso + "]";
	}



	}

