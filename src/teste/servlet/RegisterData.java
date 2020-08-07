package teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterData
 */
@WebServlet(urlPatterns = "/register")
public class RegisterData extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Registering new data...");
		
        String emailUser = request.getParameter("data");
        
        Email email = new Email();
        
        email.setEmail(emailUser);
        
        Database database = new Database();
        database.add(email);
        
        //Call JSP
        RequestDispatcher rd = request.getRequestDispatcher("/newEmail.jsp");
        request.setAttribute("email", email.getEmail());
        rd.forward(request, response);
	}

}
