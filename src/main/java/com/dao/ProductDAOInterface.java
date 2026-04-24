package com.dao;

import java.math.BigDecimal;
import java.util.List;

import com.model.Product;

public interface ProductDAOInterface {
	public List<Product> getAllProducts();

	public List<Product> getAllActiveProducts();

	public BigDecimal getProductPrice(int productId);

	public String addProduct(Product p);

	public String updateProductQuantity(int productId, int quantity);

	public String updateProduct(Product p);
}
