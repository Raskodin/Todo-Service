package com.ekomera.gox.todoservice.controllers.loginoper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns="/logout.do")
public class LogoutServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException{

		request.getSession().invalidate();
		respond.sendRedirect("/login.do");

	}

}
