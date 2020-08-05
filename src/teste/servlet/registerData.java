package teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerData
 */
@WebServlet(urlPatterns = "/register")
public class registerData extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Registering new data...");
		
        String dataInput = request.getParameter("data");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>Your input, " + dataInput + ", was successfully registered!</body></html>");
    //type: http://ip:port/folder/url_pattern?variable=data_input
    //ex: http://localhost:8080/webPage/register?data=test
	}

}
