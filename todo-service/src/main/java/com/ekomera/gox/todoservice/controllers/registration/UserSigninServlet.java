package com.ekomera.gox.todoservice.controllers.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.services.RegistrationService;

@WebServlet (urlPatterns = "/registration.do" )
public class UserSigninServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException{

		request.getRequestDispatcher("/WEB-INF/views/sign-in.jsp").forward(request, respond);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String name = request.getParameter("username");
		String key= request.getParameter("key");

		if(RegistrationService.addNewUser(name, key)) {
			response.sendRedirect("/login.do");
		}else {
			request.setAttribute("errorMessage" ,"This username taken please pick another one!");
			request.getRequestDispatcher("/WEB-INF/views/sign-in.jsp").forward(request, response);
		}

	}

}
