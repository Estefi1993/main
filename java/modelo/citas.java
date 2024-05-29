package modelo;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import com.google.gson.Gson;

import dao.DaoCitas;
import dao.DaoRegistro;




	/**
	 * Esta clase define el objeto citas.
	 * Representa a una cita medica
	 * Campos:
	 * - id: identificador único de la cita.
	 * - nombre: nombre del usuario.
	 * - apellidos: apellidos del usuario.
	 * -fecha: fecha para la cita.
	 * -hora: hora de la cita.
	 * -motivo: motivo de la cita.
	 * 
	 * @author Estefanía Vázquez
	 * @version 1.0 (12/05/2024)
	 */

	public class citas {

	
		private int id;
		private String nombre;
		private String apellidos;
		private Date fecha;
		private Time hora;
		private String motivo;
	
	
		/**
		 * Contructor vacio del objeto citas.
		 */
	public citas() {
		
		
	}
	/**
	 * Constructor de la clase citas que inicializa todos los atributos menos el id.
	 * 
	 * @param id el identificador único de la cita
	 * @param nombre el nombre del ususrio
	 * @param apellidos  los apellidos del usuario.
	 * @param fecha  la fecha de la cita.
	 * @param hora hora de la cita.
	 * @param motivo el motivo de la cita.
	 * 
	 */

	

	public citas(String nombre, String apellidos, Date fecha, Time hora, String motivo) {
		super();
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
	}

	/**
	 * Constructor de la clase citas que inicializa todos los atributos.
	 * 
	 * @param id el identificador único de la cita
	 * @param nombre el nombre del ususrio
	 * @param apellidos  los apellidos del usuario.
	 * @param fecha  la fecha de la cita.
	 * @param hora hora de la cita.
	 * @param motivo el motivo de la cita.
	 * 
	 */

	public citas(int id, String nombre, String apellidos, Date fecha, Time hora,
			String motivo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
	}



	/**
	 * Devuelve el nombre del usuario.
	 * 
	 * @return el nombre del usuario.
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del paciente de la cita.
	 * 
	 * @param nombre el nombre del paciente
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}


	/**
	 * Devuelve los apellidos del paciente de la cita.
	 * 
	 * @return los apellidos del paciente
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * Devuelve el identificador único de la cita.
	 * 
	 * @return el identificador único de la cita
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador único de la cita.
	 * 
	 * @param id el identificador único de la cita
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * Devuelve la fecha de la cita.
	 * 
	 * @return la fecha de la cita
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha de la cita.
	 * 
	 * @param fecha la fecha de la cita
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve la hora de la cita.
	 * 
	 * @return la hora de la cita
	 */
	public Time getHora() {
		return hora;
	}

	/**
	 * Establece la hora de la cita.
	 * 
	 * @param hora la hora de la cita
	 */
	public void setHora(Time hora) {
		this.hora = hora;
	}

	/**
	 * Devuelve el motivo de la cita
	 * 
	 * @return motivo de la cita
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Establece el motivo de la cita
	 * 
	 * @param motivo de la cita
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
	/**
	 * Inserta una nueva cita en la base de datos.
	 * 
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */

	public void insertar() throws SQLException {
		DaoCitas dao =  new DaoCitas();
		dao.insertar(this);
	}
	
	
	/**
	 * Actualiza los datos de una cita en la base de datos.
	 * 
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public void actualizar() throws SQLException {
		DaoCitas dao =  new DaoCitas();
		dao.actualizar(this);
	}
	
	
	/**
	 * Obtiene una cita de la base de datos por su identificador.
	 * 
	 * @param id el identificador de la cita a obtener
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public void obtenerPorId(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		
		DaoCitas dao = new DaoCitas();
		citas aux = dao.obtenerPorId(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setApellidos(aux.getApellidos());
		this.setFecha(aux.getFecha());
		this.setHora(aux.getHora());
		this.setMotivo(aux.getMotivo());
	
	}
	
	/**
	 * Elimina una cita de la base de datos.
	 * 
	 * @throws SQLException si ocurre un error al acceder a la base de datos
	 */
	public void borrrar() throws SQLException {
		DaoRegistro dao = new DaoRegistro();
		dao.borrar(id);
		
	}
	
	/**
	 * Devuelve la representación JSON de la cita.
	 * 
	 * @return la representación JSON de la cita
	 */
	public String dameJson() {
		
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;
		
	}
	

	@Override
	public String toString() {
		return "citas [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha=" + fecha + ", hora="
				+ hora + ", motivo=" + motivo + "]";
	}

	
	
	
}
