package TaskManager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaskManager.action.Action;

//@WebServlet(urlPatterns="/entry")
public class SingleEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAction = request.getParameter("action");
		
		String className = "action" + paramAction;
		
		String description;
		try {
			@SuppressWarnings("rawtypes")
			Class name = Class.forName(className);//carries the class with the name
			
			@SuppressWarnings("deprecation")
			Action action = (Action) name.newInstance();
			description = action.execute(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] adressAndType = description.split(":");
		if(adressAndType[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + adressAndType[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(adressAndType[1]);
		}
		
	}

}
