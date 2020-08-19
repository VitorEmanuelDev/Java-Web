package TaskManager.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaskManager.model.Database;

public class RemoveEmpresa  implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Action revoming task");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Database database = new Database();
		database.removeTask(id);
		
		return "entry?action=TaskList";
	
	}
}
