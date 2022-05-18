package com.spring.boot.sportyshoes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products_Sporty_Shoes")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productID;
	
	private String productName;
	private String shoeType;
	private int size;
	private String vendorName;
	private int quantity;
	private double mrp;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getShoeType() {
		return shoeType;
	}
	public void setShoeType(String shoeType) {
		this.shoeType = shoeType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	
	public Product() {
		super();
	}
	public Product( String productName, String shoeType, int size, String vendorName, int quantity,
			double mrp) {
		super();
		this.productName = productName;
		this.shoeType = shoeType;
		this.size = size;
		this.vendorName = vendorName;
		this.quantity = quantity;
		this.mrp = mrp;
	}
	public Product(int productID, String productName, String shoeType, int size, String vendorName, int quantity,
			double mrp) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.shoeType = shoeType;
		this.size = size;
		this.vendorName = vendorName;
		this.quantity = quantity;
		this.mrp = mrp;
	}
	
	
	
	
}
