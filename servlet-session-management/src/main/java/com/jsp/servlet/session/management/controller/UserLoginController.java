package com.jsp.servlet.session.management.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(value="/LoginUser")
public class UserLoginController extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
			
			HttpSession httpSession = req.getSession();
			
			String userName = req.getParameter("username");
			String password = req.getParameter("password");
			
			if(userName.equals("jagmeet") && password.equals("jaggi@1313")) {
				
				httpSession.setAttribute("user", userName);
				
				httpSession.setMaxInactiveInterval(30);
				
				req.getRequestDispatcher("home-page.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("msg", "UserName and Password is Incorrect");
				
				req.getRequestDispatcher("login-page.jsp").forward(req, resp);
			}
		}
}
