package com.jsp.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.jsp.servlet_simple_crud_operation.dto.Product;
import com.jspider.jdbc_prepared_statement_crud_operation.dao.ProductDao;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings({ "serial", "unused" })
@WebServlet(value = "/productUpdate")
public class UpdateProductByIdController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String mfd = req.getParameter("mfd");
		String expd = req.getParameter("expd");
		
		Product product = new Product(id, name, price, LocalDate.parse(mfd), LocalDate.parse(expd));
		dao.updateProductDetailsDao(product);
		
		req.getRequestDispatcher("product-display.jsp").forward(req, resp);
		
	}

}
