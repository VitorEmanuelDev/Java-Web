package TaskManager.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewTaskForm  implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "forward:formNewTask.jsp";
	}
}
