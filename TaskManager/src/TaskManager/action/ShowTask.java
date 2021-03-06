package TaskManager.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaskManager.model.Database;
import TaskManager.model.Task;

public class ShowTask  implements Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Showing task description");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database database = new Database();
		
		Task task = database.lookForTaskById(id);
		
		System.out.println(task.getDescription());

		request.setAttribute("task", task);
		
		return "forward:formAlteraEmpresa.jsp";
	}
}
