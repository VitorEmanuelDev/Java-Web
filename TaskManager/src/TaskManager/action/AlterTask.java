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

public class AlterTask implements Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskDescription = request.getParameter("description");
		String paramTaskDeadline = request.getParameter("deadline");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("action alter task " + id);
		
		Date deadline = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			deadline = sdf.parse(paramTaskDeadline);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Database database = new Database();
		Task task = database.lookForTaskById(id);
		task.setDescription(taskDescription);
		task.setDeadline(deadline);
		
		return "entry?action=TaskList";
	
	}
}
