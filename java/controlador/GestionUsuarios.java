package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoRegistro;

	public class GestionUsuarios extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		HttpSession sesion;
   
    public GestionUsuarios() {
    	
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		sesion = request.getSession();
		
			 
		PrintWriter out = response.getWriter();
	
		
		int opcion = Integer.parseInt(request.getParameter("op"));
	
		if (opcion == 2 ) {
			//proceso logica edicion.
			
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario u = new Usuario ();	
				
				try {
					u.obtenerPorId(id);
					out.print(u.dameJson());
					System.out.println(u.dameJson());
					
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
				
				out.print(usuarios.listarJson());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}else if(opcion==4){
			
			int tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
			System.out.print("Entro en filtro con el tipo " + tipoUsuario);
			
			try {
				DaoRegistro daoRegistro = new DaoRegistro();

				out.print(daoRegistro.listarJson(tipoUsuario));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}    
	       
	        	
	        }
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//se obtienen los parametros del formulario.
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String email= request.getParameter("email");
		String pass = request.getParameter("pass");
		int permiso = Integer.parseInt(request.getParameter("permiso"));
		String id = request.getParameter("id");
		
		Usuario n1 ;
	
		try {
			
			//crear usuario
			n1 = new Usuario(nombre, apellidos, telefono, direccion, email, permiso);
			//cifrar contraseña
			
			
			if (id == null || id.isEmpty()) {
			    // Si el id es nulo o está vacío, insertar un nuevo usuario
			    DaoRegistro dao = new DaoRegistro();
			    dao.insertar(n1,pass);
				
			}else {
				int idInt = Integer.parseInt(id);
				n1.setId(idInt);
				n1.actualizar();
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		response.sendRedirect("index.html");
		
	}
	 
	    }
	
