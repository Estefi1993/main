package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import modelo.Usuario;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dao.DaoRegistro;

import java.sql.SQLException;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HttpSession sesion;
       
       
     
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        
        Usuario u = new Usuario();
        u.setEmail(email);

        try {
        	String hashedPass = hashMD5(pass);
        	
            if (u.logeo(hashedPass)) {
        
                int permiso = u.getPermiso();

                // Establecer la sesión con el ID y el permiso del usuario
                sesion = request.getSession();
                
                sesion.setAttribute("email",email);
                sesion.setAttribute("permiso", permiso);
                
               
                // Redirigir según el permiso del usuario
                if (permiso == 1) {
                    response.sendRedirect("indexUser.html");
                } else {
                    response.sendRedirect("index2.html");
                }
            } else {
                // Si las credenciales son incorrectas, redirigir a la página de inicio de sesión
                response.sendRedirect("Iniciar_sesion.html");
            }
        } catch (SQLException e) {
            // Si hay un error en la base de datos, mostrar un mensaje de error
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud");
        }
	}
        private String hashMD5(String input) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(input.getBytes());
                BigInteger number = new BigInteger(1, messageDigest);
                String hashedText = number.toString(16);

                while (hashedText.length() < 32) {
                    hashedText = "0" + hashedText;
                }
                return hashedText;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        
    }
}