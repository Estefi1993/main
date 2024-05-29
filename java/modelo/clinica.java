package modelo;

public class clinica {

	private int id_clinica;
	private String nombre;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String codigoPostal;
	private String telefono;
	private String email;
	
	
	public clinica() {
		
		
	}


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


	public int getId_clinica() {
		return id_clinica;
	}


	public void setId_clinica(int id_clinica) {
		this.id_clinica = id_clinica;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


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
