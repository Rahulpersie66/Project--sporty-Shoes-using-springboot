package com.spring.boot.sportyshoes.servicesImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.sportyshoes.entities.Product;
import com.spring.boot.sportyshoes.repositories.ProductDao;
import com.spring.boot.sportyshoes.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	//to get all the products inthe Product table
	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	// to add the product in the Product Table
	@Override
	public boolean addProduct(Product product) {
		Boolean flag= false;
		Product pro=new Product(product.getProductName(),product.getShoeType(),product.getSize(),product.getVendorName(),product.getQuantity(),product.getMrp());
		productDao.save(pro);
		flag=true;
		return flag;
	}

	
	//to get One Product from Product table
	@Override
	public Product getOneProduct(int productId) {
		return productDao.findById(productId).get();
	}

	//view all the products names from product table
	@Override
	public List<String> viewAllProducts() {
		List<Product> allProducts=new ArrayList<Product>(productDao.findAll());
		List<String> allProductsName=new ArrayList<String>();
		for(Product product:allProducts)
			allProductsName.add(product.getProductName());
		return allProductsName;
	}


	//to show product details using productId
	@Override
	public Product showProductDetails(int productId) {
		List<Product> allProducts=new ArrayList<Product>(productDao.findAll());
		for(Product product:allProducts)
			if(product.getProductID()==productId)
				return product;
		return null;
	}

	//to update ProductName using ProductId
	@Override
	public Boolean updateProductName(int productId,String productName) {
		boolean flag=false;
		List<Product> allProducts=new ArrayList<Product>(productDao.findAll());
		for(Product product:allProducts)
			if(product.getProductID()==productId)
				{	Product prod=new Product(product.getProductID(),productName,product.getShoeType(),product.getSize(),product.getVendorName(),product.getQuantity(),product.getMrp());
					productDao.save(prod);
					flag=true;
				}
		return flag;
	}
	
	//to update MSRP using ProductId
	@Override
	public Boolean updateProductMsrp(int productId, double msrp) {
		boolean flag=false;
		List<Product> allProducts=new ArrayList<Product>(productDao.findAll());
		for(Product product:allProducts)
			if(product.getProductID()==productId)
				{	Product prod=new Product(product.getProductID(),product.getProductName(),product.getShoeType(),product.getSize(),product.getVendorName(),product.getQuantity(),msrp);
					productDao.save(prod);
					flag=true;
				}
		return flag;
	}

	
	//to update QuantityInStock using ProductId
	@Override
	public Boolean updateProductQuantityInStock(int productId, int quantity) {
		boolean flag=false;
		List<Product> allProducts=new ArrayList<Product>(productDao.findAll());
		for(Product product:allProducts)
			if(product.getProductID()==productId)
				{	Product prod=new Product(product.getProductID(),product.getProductName(),product.getShoeType(),product.getSize(),product.getVendorName(),quantity,product.getMrp());
					productDao.save(prod);
					flag=true;
				}
		return flag;
	}

	
	//to update VendorName using ProductId
	@Override
	public Boolean updateProductVendorName(int productId, String vendorName) {
		boolean flag=false;
		List<Product> allProducts=new ArrayList<Product>(productDao.findAll());
		for(Product product:allProducts)
			if(product.getProductID()==productId)
				{	Product prod=new Product(product.getProductID(),product.getProductName(),product.getShoeType(),product.getSize(),vendorName,product.getQuantity(),product.getMrp());
					productDao.save(prod);
					flag=true;
				}
		return flag;
	}

	
	//delete the product using productId
	@Override
	public Boolean deleteProduct(int productId) {
		boolean flag=false;
			Product prod=productDao.getById(productId); // or can use .getOne(prodId)
			productDao.delete(prod);
			flag=true;
		return flag;
	}

	
	

}
