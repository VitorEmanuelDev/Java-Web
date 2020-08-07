package teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListEmailsServlet
 */
@WebServlet("/listEmails")
public class ListEmailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database database = new Database();
		List<Email> list = database.getEmails();
			
		 request.setAttribute("emails", list);

		 RequestDispatcher rd = request.getRequestDispatcher("/emailList.jsp");
		 rd.forward(request,response);
	}

}
