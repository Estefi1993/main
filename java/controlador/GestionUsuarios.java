package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoRegistro;



/**
 * Servlet para gestionar usuarios.
 * Servlet implementation class GestionUsuario
 */
@MultipartConfig
	public class GestionUsuarios extends HttpServlet {
		private static final long serialVersionUID = 1L;
       
    /**
     * crea una nueva instancia de la clase GestionUsuarios.
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsuarios() {
    	
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * Procesa las solicitudes GET enviadas al servlet.
     * Este método maneja las solicitudes GET, como la obtención, edición y eliminación de usuarios, y envía las respuestas correspondientes.
     * 
     * @param request Objeto HttpServletRequest que contiene la solicitud HTTP del cliente.
     * @param response Objeto HttpServletResponse que contiene la respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error en la solicitud.
     * @throws IOException Si ocurre un error durante la manipulación de la solicitud.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
	
		
		int opcion = Integer.parseInt(request.getParameter("op"));
	
		if (opcion == 2 ) {
			//proceso logica edicion.
			
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario u = new Usuario ();	
				
				try {
					u.obtenerPorId(id);
					out.print(u.dameJson());
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else if (opcion == 1){
			
			DaoRegistro usuarios;

			try {
				usuarios = new DaoRegistro();
				out.print(usuarios.listarJson());
		
			} catch (SQLException e) {
		
					e.printStackTrace();
				}
		}else if (opcion==3){
			
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				DaoRegistro usuarios = new DaoRegistro();
				usuarios.borrar(id);
				System.out.println("Estoy borrando " + id);
				System.out.println("Estoy opcion " + opcion);
				out.print(usuarios.listarJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	
	}
	
	

	/**
	 * Procesa las solicitudes POST enviadas al servlet.
	 * Este método maneja las solicitudes POST, como la creación y actualización de usuarios, y redirige al cliente a una página de listado de usuarios después de completar la solicitud.
	 * @param request Objeto HttpServletRequest que contiene la solicitud HTTP del cliente.
	 * @param response Objeto HttpServletResponse que contiene la respuesta HTTP que se enviará al cliente.
	 * @throws ServletException Si ocurre un error en la solicitud.
	 * @throws IOException Si ocurre un error  durante la manipulación de la solicitud.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String email= request.getParameter("email");
		String id = request.getParameter("id");
		
		Usuario n1 ;
		try {
			
			n1 = new Usuario(nombre, apellidos, telefono, direccion, email);
			if(id == " ") {
				
				DaoRegistro dao = new DaoRegistro();
				dao.insertar(n1);
				
			}else {
				int idInt = Integer.parseInt(id);
				n1.setId(idInt);
				n1.actualizar();
				
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		response.sendRedirect("ListarUsuarios.html");
	}
	}


