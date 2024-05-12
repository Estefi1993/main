package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Empleado;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoEmpleados;





	/**
	 * Servlet implementation class GestionEmpleado
	 */
	public class GestionEmpleado extends HttpServlet {
		private static final long serialVersionUID = 1L;
		HttpSession sesion;
       /**
        * Constructor de la clase GestionEmpleado.
        * Crea una nueva instancia de la clase GestionEmpleado.
        */
    public GestionEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	    /**
	     * Procesa las solicitudes GET enviadas al servlet.
	     * Este método maneja las solicitudes GET relacionadas con la gestión de empleados, como la obtención, edición y eliminación de empleados, y envía las respuestas correspondientes.
	     * @param request Objeto HttpServletRequest que contiene la solicitud HTTP del cliente.
	     * @param response Objeto HttpServletResponse que contiene la respuesta HTTP que se enviará al cliente.
	     * @throws ServletException Si ocurre un error en la solicitud.
	     * @throws IOException Si ocurre un error durante la manipulación de la solicitud.
	     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
	
		sesion = request.getSession();
		
		int idSesion = (int)sesion.getAttribute("id");
		
		
		if(idSesion !=0) {
			
		
		PrintWriter out = response.getWriter();
		
		int opcion = Integer.parseInt(request.getParameter("op"));
		
		if (opcion == 2 ) {
			//proceso logica edicion.
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Empleado u = new Empleado ();	
				
				try {
					u.obtenerPorId(id);
					out.print(u.dameJson());
					System.out.println(u.dameJson());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else if (opcion == 1){
			
			DaoEmpleados Empleado;

			try {
				Empleado = new DaoEmpleados();
				out.print(Empleado.listarJson());
		
			} catch (SQLException e) {
		
					e.printStackTrace();
			}
		}else if (opcion==3){
			
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				DaoEmpleados Empleado = new DaoEmpleados();
				Empleado.borrar(id);
				System.out.println("Estoy borrando " + id);
				System.out.println("Estoy opcion " + opcion);
				out.print(Empleado.listarJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}else {
			
			System.out.println("No puedes entrar");
			response.sendRedirect("Iniciar_sesion.html");
		}
	
	}
	
	
		/**
		 * Procesa las solicitudes POST enviadas al servlet.
		 * Este método maneja las solicitudes POST relacionadas con la creación y actualización de empleados, y redirige al cliente a una página de listado de empleados después de completar la solicitud.
		 * 
		 * @param request Objeto HttpServletRequest que contiene la solicitud HTTP del cliente.
		 * @param response Objeto HttpServletResponse que contiene la respuesta HTTP que se enviará al cliente.
		 * @throws ServletException Si ocurre un error en  la solicitud.
		 * @throws IOException Si ocurre un error  durante la manipulación de la solicitud.
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			String especialidad = request.getParameter("especialidad");
			String email= request.getParameter("email");
			int permiso = Integer.parseInt(request.getParameter("permiso"));
			String id = request.getParameter("id");
			
			Empleado n1 ;
			
			try {
				
				n1 = new Empleado(nombre, apellidos, telefono, direccion, especialidad, email, permiso);
				if(id == "") {
					
					DaoEmpleados dao = new DaoEmpleados();
					dao.insertar(n1);
					
				}else {
					
					int idInt = Integer.parseInt(id);
					n1.setId(idInt);
					n1.actualizar();
		
					
				}
				
			
			}catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			response.sendRedirect("index2.html");
	}

}
