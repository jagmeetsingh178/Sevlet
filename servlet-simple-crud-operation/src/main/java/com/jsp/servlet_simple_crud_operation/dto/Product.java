package com.jsp.servlet_simple_crud_operation.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Product 
{
	@SuppressWarnings("unused")
	private int id;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private double price;
	@SuppressWarnings("unused")
	private LocalDate mfd;
	@SuppressWarnings("unused")
	private LocalDate expd;
	
	
//	Constructor
	public Product(int id, String name, double price, LocalDate mfd, LocalDate expd) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.mfd = mfd;
	this.expd = expd;
}


//	Getter Setter Method

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public LocalDate getMfd() {
		return mfd;
	}


	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}


	public LocalDate getExpd() {
		return expd;
	}


	public void setExpd(LocalDate expd) {
		this.expd = expd;
	}


	
//	To Generate toString Method
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", mfd=" + mfd + ", expd=" + expd
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getMfd()="
				+ getMfd() + ", getExpd()=" + getExpd() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	//to generate hashcode() and equals Method Alt+Shift+s+h
	@Override
	public int hashCode() {
		return Objects.hash(expd, id, mfd, name, price);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(expd, other.expd) && id == other.id && Objects.equals(mfd, other.mfd)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
	
	
	
	
	
	
	

	
	
	
}
