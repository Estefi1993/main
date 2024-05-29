package modelo;

public class clinica {
	
	/**
	 * Esta clase representa una clínica.
	 * - id_clinica: identificador único de la clinica.
	 * - nombre: nombre de la clinica.
	 * - direccion: direccion de la clinica
	 * - poblacion: poblacion de la clinica
	 * - provincia:  provincia de la clinica
	 * - codigoPostal: el Cp de la clinica
	 * -telefono: telefono de la clinica
	 * -email: email de la clinica.
	 * 
	 * @author Estefanía Vázquez
	 * @version 1.0 (12/05/2024)
	 * 
	 * 
	 */
	
	
	private int id_clinica;
	private String nombre;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String codigoPostal;
	private String telefono;
	private String email;
	
	/**
	 * Contructor vacio del objeto clinica
	 */
	public clinica() {
		
		
	}
	/**
	 * Constructor de la clase clinica que inicializa todos los atributos.
	 * 
	 * @param id_clinica el identificador único de la clínica
	 * @param nombre el nombre de la clínica
	 * @param direccion la dirección de la clínica
	 * @param poblacion la población donde se encuentra la clínica
	 * @param provincia la provincia donde se encuentra la clínica
	 * @param codigoPostal el código postal de la clínica
	 * @param telefono el número de teléfono de la clínica
	 * @param email el correo electrónico de la clínica
	 */

	public clinica(int id_clinica, String nombre, String direccion, String poblacion, String provincia,
			String codigoPostal, String telefono, String email) {
		super();
		this.id_clinica = id_clinica;
		this.nombre = nombre;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.email = email;
	}
	/**
	 * Devuelve el identificador único de la clínica.
	 * 
	 * @return el identificador único de la clínica
	 */

	public int getId_clinica() {
		return id_clinica;
	}

	/**
	 * Establece el identificador único de la clínica.
	 * 
	 * @param id_clinica el identificador único de la clínica
	 */
	public void setId_clinica(int id_clinica) {
		this.id_clinica = id_clinica;
	}
	/**
	 * Devuelve el nombre de la clínica.
	 * 
	 * @return el nombre de la clínica
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la clínica.
	 * 
	 * @param nombre el nombre de la clínica
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la direccion de la clínica.
	 * 
	 * @return  direccion de la clínica
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la direccion
	 * @param direccion de la clinica
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Devuelve la poblacion de la clínica.
	 * 
	 * @return  poblacion de la clínica
	 */

	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Establece la direccion
	 * @param direccion de la clinica
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * Devuelve la poblacion de la clínica.
	 * 
	 * @return  poblacion de la clínica
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Establece la provincia
	 * @param provincia de la clinica
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * Devuelve la codigoPostal de la clínica.
	 * 
	 * @return  codigopostal de la clínica
	 */

	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	
	/**
	 * Establece codigoPostal
	 * @param codigoPostal de la clinica
	 */

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * Devuelve el telefono de la clínica.
	 * 
	 * @return  telefono de la clínica
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el dtelefono
	 * @param telefono de la clinica
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve el email de la clínica.
	 * 
	 * @return  email de la clínica
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el email
	 * @param email de la clinica
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "clinica [id_clinica=" + id_clinica + ", nombre=" + nombre + ", direccion=" + direccion + ", poblacion="
				+ poblacion + ", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}
	
	
	
}
