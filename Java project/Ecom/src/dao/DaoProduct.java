package dao;

import java.util.List;

import model.Product;

public interface DaoProduct {
	void insertProduct(Product product);
	List<Product>getProductsByCategoryId(int categoryId);

}
