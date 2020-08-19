package TaskManager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(urlPatterns="/entry")
public class MonitoringFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoringFilter");
		
		
		long before = System.currentTimeMillis();
		
		String action = request.getParameter("action");
		
		//executes the action
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		System.out.println("Execution time of " + action + " -> " + (after - before));
		
	}
	
}
