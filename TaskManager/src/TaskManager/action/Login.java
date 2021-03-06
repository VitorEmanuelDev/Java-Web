package TaskManager.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TaskManager.model.Database;
import TaskManager.model.User;

public class Login implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		System.out.println("Logging in " + login);
		
		Database database = new Database();
		User user = database.userExists(login,password);
		
		if(user != null) {
			System.out.println("User exists");
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", user);
			return "entry?action=TaskList";
		} else {
			return "redirect:entry?action=LoginForm";
		}
		
		
	}

}
