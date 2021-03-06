package TaskManager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaskManager.action.Action;


//@WebFilter("/entry")
public class ControllerFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControllerFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");
		String className = "TaskManager.action." + paramAction;
		
		String description;
		try {
			@SuppressWarnings("rawtypes")
			Class name = Class.forName(className);//carries the class with the name
			@SuppressWarnings("deprecation")
			Action action = (Action) name.newInstance();
			description = action.execute(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		String[] adressAndType = description.split(":");
		if(adressAndType[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + adressAndType[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(adressAndType[1]);
		}
	}
	
}
