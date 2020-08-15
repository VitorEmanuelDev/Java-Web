package br.com.task.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/taskList")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Database database = new Database();
		List<Task> list = database.getTasks();
		
		request.setAttribute("tasks", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/taskList.jsp");
		rd.forward(request, response);
		
	}
}
