package TaskManager.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaskManager.model.Database;
import TaskManager.model.Task;

public class TaskList implements Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("listing tasks");
		
		Database database = new Database();
		List<Task> list = database.getTask();
		
		request.setAttribute("tasks", list);
		
		return "forward:listOfTasks.jsp";
	}

}
