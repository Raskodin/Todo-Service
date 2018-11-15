package com.ekomera.gox.todoservice.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = { "*.do" })
public class LoginRequiredFilter implements Filter {
	private static final List<String> ALLOWED_PATHS = Arrays.asList("/login.do", "/registration.do");

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
		boolean loggedIn = (request.getSession() != null && request.getSession().getAttribute("isloggedin") != null);
		boolean allowedPath = ALLOWED_PATHS.contains(path);

		if(allowedPath || loggedIn){
			chain.doFilter(servletRequest, servletResponse);
		}else {
			request.getRequestDispatcher("/login.do").forward(servletRequest, servletResponse);
		}


	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
