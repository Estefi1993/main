package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Empleado;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HttpSession sesion;
       /**
        * Constructor de la clase login.
        * Crea una nueva instancia de la clase login.
        */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * Procesa las solicitudes POST enviadas al servlet.
	 * Este método maneja las solicitudes POST relacionadas con el inicio de sesión de empleados, verifica las credenciales proporcionadas y redirige al cliente a la página de listado de usuarios si las credenciales son válidas.
	 * 
	 * @param request Objeto HttpServletRequest que contiene la solicitud HTTP del cliente.
	 * @param response Objeto HttpServletResponse que contiene la respuesta HTTP que se enviará al cliente.
	 * @throws ServletException Si ocurre un error en la solicitud.
	 * @throws IOException Si ocurre un error  durante la manipulación de la solicitud.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		 String hashedPassword = myMD5(pass);
		Empleado u = new Empleado();
		u.setEmail(email);
		
		
		//proteccion
		
		try {
			if(u.logeo(pass)) {
				sesion = request.getSession();
				
				
				sesion.setAttribute("id", u.getId());
				
				
				response.sendRedirect("ListarUsuarios.html");
				
			}else {
				response.sendRedirect("Iniciar_sesion.html");
				
				
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	}
	
		
	    private String myMD5(String pass) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] messageDigest = md.digest(pass.getBytes());
	            BigInteger number = new BigInteger(1, messageDigest);
	            String hashtext = number.toString(16);

	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            return hashtext;
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	            
	        }
	    }
	}
	
