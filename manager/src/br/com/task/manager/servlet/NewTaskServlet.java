package br.com.task.manager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewTaskSrvlet
 */
@WebServlet("/newTask")
public class NewTaskServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Registering new task.");
		
		String taskName = request.getParameter("name");
		String paramTaskDate = request.getParameter("date");
		
		Date deadline = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			deadline = sdf.parse(paramTaskDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Task task = new Task();
		task.setContent(taskName);
		task.setDeadline(deadline);
		
		Database database = new Database();
		database.add(task);
		
		request.setAttribute("task", task.getContent());
		
		response.sendRedirect("tasksList");
		
//		//call JSP or Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/tasksList");
//		request.setAttribute("task", task.getContent());
//		rd.forward(request, response);
	}

}
