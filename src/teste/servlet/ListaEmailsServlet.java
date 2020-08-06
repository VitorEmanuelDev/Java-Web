package teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmailsServlet
 */
@WebServlet("/listaEmails")
public class ListaEmailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database database = new Database();
		List<Email> list = database.getEmails();
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
        out.println("<ul>");
        
        for (Email email : list) {
        	
        	 out.println("<li>" + email.getEmail() + "</li>");
			
		}
        
        out.println("</ul>");
        out.println("</body></html>");
			
	}

}
