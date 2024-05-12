package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoEmpleados;


	/**
	 * Esta clase define el objeto empleado.
	 * Contiene información sobre los empleados de una empresa.
	 * Campos:
	 * - id: identificador único del empleado.
	 * - nombre: nombre del empleado.
	 * - apellidos: apellidos del empleado.
	 * - telefono: número de teléfono del empleado.
	 * - direccion: dirección del empleado.
	 * - especialidad: especialidad del empleado en el trabajo.
	 * - email: dirección de correo electrónico del empleado.
	 * 
	 * @author Estefanía Vázquez
	 * @version 1.0 (12/05/2024)
	 */

public class Empleado {

	private int id;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String especialidad;
	private String email;


	

	
	/**
	 * Contructor por defecto para generar un objeto empleado.
	 */
	public Empleado() {
				
	}


	 /**
     * Constructor para crear un objeto Empleado con todos los atributos.
     * @param id El ID del empleado.
     * @param nombre El nombre del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param telefono El teléfono del empleado.
     * @param direccion La dirección del empleado.
     * @param especialidad La especialidad del empleado.
     * @param email El correo electrónico del empleado.
     */

	public Empleado(int id, String nombre, String apellidos, String telefono, String direccion, String especialidad,
			String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.especialidad = especialidad;
		this.email = email;
	
	}
	 /**
     * Constructor para crear un objeto Empleado sin el ID.
     * @param id El ID del empleado.
     * @param nombre El nombre del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param telefono El teléfono del empleado.
     * @param direccion La dirección del empleado.
     * @param especialidad La especialidad del empleado.
     * @param email El correo electrónico del empleado.
     */


	public Empleado(String nombre, String apellidos, String telefono, String direccion, String especialidad,
			String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.especialidad = especialidad;
		this.email = email;
		
	}

	 /**
     * Devuelve el ID del empleado.
     * @return El ID del empleado.
     */

	public int getId() {
		return id;
	}
	
	 /**
     * Establece el ID del empleado.
     * @param id El ID del empleado.
     */
	public void setId(int id) {
		this.id = id;
	}

	//Métodos getter y setters para los demás atributos.

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


    /**
     * Actualiza la información del empleado en la base de datos.
     * @throws SQLException Si ocurre un error al actualizar en la base de datos.
     */

	public void actualizar() throws SQLException {
		DaoEmpleados dao = new DaoEmpleados();
		dao.actualizar(this);
		
	}
	/**
	 * Método para borrar la información del empleado en la base de datos.
	 * @throws SQLException
	 */
	public void borrrar() throws SQLException {
		DaoEmpleados dao = new DaoEmpleados();
		dao.borrar(id);
		
	}
	/**
	 * Método para insertar un nuevo registro en la base de datos. 
	 * @throws SQLException Si ocurre un error al interactuar con la base de datos durante la inserción.
	 */
	public void insertar () throws SQLException {
		
		DaoEmpleados dao = new DaoEmpleados();
		dao.insertar(this);
	}
	/**
	 * Proceso de inicio de sesión para el empleado.
	 * 
	 * @param pass La contraseña proporcionada para el inicio de sesión.
	 * @return true si el inicio de sesión es exitoso, false de lo contrario.
	 * @throws SQLException Si ocurre un error al interactuar con la base de datos.
	 */
	
	public boolean logeo(String pass) throws SQLException {
		//variable para almacenar el resultado del inicio de sesion.
		boolean ok = false;
		DaoEmpleados dao = new DaoEmpleados();
		//Realizar inicio de sesion
		Empleado  aux = dao.logeando(this, pass);
				
		
		if(aux !=null) {
			ok=true;
			this.setId(aux.getId());
			this.setNombre(aux.getNombre());
			this.setApellidos(aux.getApellidos());
			this.setTelefono(aux.getTelefono());
			this.setDireccion(aux.getDireccion());
			this.setEspecialidad(aux.getEspecialidad());
			this.setEmail(aux.getEmail());
			
		}
			
			
		return ok;
	}
	

	/**
	 * Devuelve una representación JSON del objeto.
	 * 
	 * @return Una cadena JSON que representa el objeto.
	 */
	
	public String dameJson() {
		//Inicializar una cadena vacía para almacenar el JSON.
		String json = "";
		//Crear un nuevo objeto Gson.
		Gson gson = new Gson();
		//Convertir el objeto actual a JSON utilizando Gson.
		json = gson.toJson(this);
		//Devolver el JSON resultante
		return json;
		
	}
	/**
     * Obtiene la información de un empleado por su ID de la base de datos y actualiza este objeto Empleado con dicha información.
     * @param id El ID del empleado.
     * @throws SQLException Si ocurre un error al obtener la información de la base de datos.
     */
	
	public void obtenerPorId(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		
		DaoEmpleados dao = new DaoEmpleados();
		Empleado aux = dao.obtenerPorId(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setApellidos(aux.getApellidos());
		this.setTelefono(aux.getTelefono());
		this.setDireccion(aux.getDireccion());
		this.setEspecialidad(aux.getEspecialidad());
		this.setEmail(aux.getEmail());
	
		
		
	}

	
	/**
     * Devuelve una representación en forma de cadena del objeto Empleado.
     */
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", especialidad=" + especialidad + ", email=" + email +  "]";
	}
	
	
	
	
	
	
	
	
	
	
}
	

