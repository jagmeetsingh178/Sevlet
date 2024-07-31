package com.jsp.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.jsp.servlet_simple_crud_operation.dto.Product;
import com.jspider.jdbc_prepared_statement_crud_operation.dao.ProductDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ProductInsertController implements Servlet
{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		ProductDao dao  = new ProductDao();
		
		
		
			PrintWriter printWriter = res.getWriter();
		
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			double price = Double.parseDouble(req.getParameter("price"));
			String mfd = req.getParameter("mfd");
			String expd = req.getParameter("expd");
			
			Product product = new Product(id, name, price, LocalDate.parse(mfd), LocalDate.parse(expd));
			dao.saveProductDao(product);
			
			printWriter.write("<html><body>");
			printWriter.write("<h3> Product-------Details</h3>");
			
			printWriter.write("<h3>id = "+id+"</h3><h3>name = "+name+"</h3> <h3>Price = "+price+"</h3><h3>MFD = "+mfd+"</h3> <h3>EXPD = "+expd+"</h3>");
			
			printWriter.write("</body></html>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("product-register-form.jsp");
			dispatcher.include(req, res);
			
					
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
