package teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//teste
@WebServlet(urlPatterns="/test")

public class ServletTest extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

		@Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		 
			PrintWriter out = resp.getWriter();
	        out.println("<html>");
	        out.println("<body>");
	        out.println("<h1>");
	        out.println("This is a test page.");
	        out.println("</h1>");
	        out.println("</body>");
	        out.println("</html>");

	        System.out.println("The test servlet was called.");
	    }

}

