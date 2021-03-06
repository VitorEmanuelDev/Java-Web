package TaskManager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import TaskManager.model.Database;
import TaskManager.model.Task;


@WebServlet("/tasks")
public class TaskService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Task> tasks = new Database().getTask();
		
		String value = request.getHeader("Accept");
		
		System.out.println(value);
		
		if(value.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("task", Task.class);
			String xml = xstream.toXML(tasks);  
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);		
		} else if(value.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(tasks);  
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
	}
}








