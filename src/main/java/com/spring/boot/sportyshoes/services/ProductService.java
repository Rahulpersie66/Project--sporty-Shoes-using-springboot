package com.spring.boot.sportyshoes.services;

import java.util.List;

import com.spring.boot.sportyshoes.entities.Product;

public interface ProductService {

	//to show all products in the product table
	public List<Product> getAllProducts(); 
	
	//to add the product
	public boolean addProduct(Product product);
	
	//to get One Product by productId-->use findById(ProductId).get()
	public Product getOneProduct(int productID);
	
	//to view all products name from table product
	public List<String> viewAllProducts();
	
	//to show Product details using productId
	public Product showProductDetails(int productId);
	
	//to update ProductName by using productId
	public Boolean updateProductName(int productId, String productName);
	
	//to update MSRP by using productId
	public Boolean updateProductMsrp(int productId, double msrp);
	
	//to update Quantity in stock by using productId
	public Boolean updateProductQuantityInStock(int productId, int quantity);
	
	//to update VendorName by using productId
	public Boolean updateProductVendorName(int productId, String vendorName);
	
	//to delete the product using productId
	public Boolean deleteProduct(int productId);
}
