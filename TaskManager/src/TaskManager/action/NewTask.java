package TaskManager.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaskManager.model.Database;
import TaskManager.model.Task;

public class NewTask  implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Registering new task.");
		
		String taskDescription = request.getParameter("description");
		String paramTaskDeadline = request.getParameter("deadline");
		
		Date deadLine = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			deadLine = sdf.parse(paramTaskDeadline);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Task task = new Task();
		task.setDescription(taskDescription);
		task.setDeadline(deadLine);
		
		Database database = new Database();
		database.add(task);
		
		request.setAttribute("task", task.getDescription());
		
		return "entry?action=TaskList";
	
	}
}
