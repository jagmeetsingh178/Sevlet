package com.jsp.servlet.session.management.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(value="/profile-page")
public class OpenProfileController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession  httpSession = req.getSession();
			if(httpSession.getAttribute("user")!=null) {
				req.getRequestDispatcher("profile.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Your Session is Expire---Re Login");
				req.getRequestDispatcher("login-page.jsp").forward(req, resp);
			}
			
			
		}
}
