package br.com.task.manager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showTask")
public class ShowTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database database = new Database();
		
		Task task = database.loofForTaskById(id);
		
		System.out.println(task.getContent());

		request.setAttribute("task", task);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlterTask.jsp");
		rd.forward(request, response);
	}

}
