package com.jspider.jdbc_prepared_statement_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jsp.servlet_simple_crud_operation.dto.Product;
import com.jspider.jdbc_prepared_statement_crud_operation.connection.ProductConnection;

@SuppressWarnings("unused")
public class ProductDao 
{
	PreparedStatement ps = null;
	Connection connection =ProductConnection.getProductConnection();
	
	@SuppressWarnings("unused")
	private final String INSERTPRODUCTQUERY = "insert into product1(id ,name, price ,mfd, expd)values(?,?,?,?,?)";
	private final String DISPLAYPRODUCTBYID = "select * from product1 where id=?";
	private final String DELETEPRODUCTBYID = "delete from product1 where id=?";
	private final String DISPLAYALLPRODUCT = "select * from product1";
	private final String UPDATEPRODUCTDETAILSBYID = "update product1 set name=?,price=?,mfd=?,expd=? where id=?";
	
	public Product saveProductDao(Product product)
	{
		try {
			ps = connection.prepareStatement(INSERTPRODUCTQUERY);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setObject(4, product.getMfd());
			ps.setObject(5, product.getExpd());
			ps.execute();
			return product;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Product getProductByIdDao(int id)
	{
		try {
			ps = connection.prepareStatement(DISPLAYPRODUCTBYID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			Product product = null;
			if(rs.next())
			{
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				LocalDate mfd = rs.getDate("mfd").toLocalDate();
				LocalDate expd = rs.getDate("expd").toLocalDate();
				
				product = new Product(id1, name, price, mfd, expd);
			}
			return product;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteProductByIdDao(int id)
	{
		try {
			ps=connection.prepareStatement(DELETEPRODUCTBYID);
			ps.setInt(1, id);
			return ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<Product> displayAllProductDataDao()
	{
		try {
			ps=connection.prepareStatement(DISPLAYALLPRODUCT);
			ResultSet rs = ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				LocalDate mfd = rs.getDate("mfd").toLocalDate();
				LocalDate expd = rs.getDate("expd").toLocalDate();
				
				Product product =new Product(id1, name, price, mfd, expd);
				
				products.add(product);
			}
			return products;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateProductDetailsDao(Product product)
	{
		try {
			ps=connection.prepareStatement(UPDATEPRODUCTDETAILSBYID);
			
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setObject(3, product.getMfd());
			ps.setObject(4, product.getExpd());
			ps.setInt(5, product.getId());
			return ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}

	}
}
