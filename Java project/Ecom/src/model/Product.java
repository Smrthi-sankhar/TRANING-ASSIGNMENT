package model;

public class Product {
	private int  productId;
    private String name;
    private double price;
    private int categoryId;
    
	public Product() {	}

	public Product(int  productId, String name, double price, int categoryId) {
		super();
		this.productId =  productId;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int  productId) {
		this.productId =  productId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Product [id=" + productId + ", name=" + name + ", price=" + price + ", categoryId=" + categoryId + "]";
	}
}
