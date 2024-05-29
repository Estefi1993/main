package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.citas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import dao.DaoCitas;
import dao.DaoRegistro;



/**
 * Servlet implementation class GestionCitas
 */
public class GestionCitas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCitas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
	
		int opcion = Integer.parseInt(request.getParameter("op"));
		
		if (opcion == 2 ) {
			//proceso logica edicion.
			
			int id = Integer.parseInt(request.getParameter("id"));
			citas u = new citas ();	
				
				try {
					u.obtenerPorId(id);
					out.print(u.dameJson());
					System.out.println(u.dameJson());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else if (opcion == 1){
			
			DaoCitas citas;

			try {
				citas = new DaoCitas();
				out.print(citas.listarJson());
		
			} catch (SQLException e) {
		
					e.printStackTrace();
				}
		}else if (opcion==3){
			
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				DaoCitas citas = new DaoCitas();
				citas.borrar(id);
				
				out.print(citas.listarJson());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String fechaSt= request.getParameter("fecha");
		String horaSt = request.getParameter("hora");
		String motivo= request.getParameter("motivo");
	
		
		
		 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	     try {
	    	 LocalDate localDate = LocalDate.parse(fechaSt, dateFormatter);
	         LocalTime localTime = LocalTime.parse(horaSt, timeFormatter);

	        
	         java.sql.Date fecha = java.sql.Date.valueOf(localDate);
	         java.sql.Time hora = java.sql.Time.valueOf(localTime);
	         
	         citas n1 = new citas(nombre, apellidos, fecha, hora, motivo);
	        
	         n1.insertar();
	         response.sendRedirect("index.html");

	     } catch (DateTimeParseException e) {
	         // Manejar excepción si la fecha y hora no son válidas
	         e.printStackTrace();
	         response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de fecha y hora incorrecto");
	     } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		
	
		


	 
	    
	

	}


