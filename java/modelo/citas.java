package modelo;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import com.google.gson.Gson;

import dao.DaoCitas;
import dao.DaoRegistro;


public class citas {

	
	private int id;
	private String nombre;
	private String apellidos;
	private Date fecha;
	private Time hora;
	private String motivo;
	
	
	public citas() {
		
		
	}



	public citas(String nombre, String apellidos, Date fecha, Time hora, String motivo) {
		super();
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
	}



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



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public void insertar() throws SQLException {
		DaoCitas dao =  new DaoCitas();
		dao.insertar(this);
	}

	public void actualizar() throws SQLException {
		DaoCitas dao =  new DaoCitas();
		dao.actualizar(this);
	}
	
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
	public void borrrar() throws SQLException {
		DaoRegistro dao = new DaoRegistro();
		dao.borrar(id);
		
	}
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
