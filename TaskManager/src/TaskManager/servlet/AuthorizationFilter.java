package TaskManager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/entry")
public class AuthorizationFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AuthorizationFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean userIsNotLogged = (session.getAttribute("loggedUser") == null);
		boolean isProtectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
		
		if(isProtectedAction && userIsNotLogged) {
			response.sendRedirect("entry?action=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}

	
}
