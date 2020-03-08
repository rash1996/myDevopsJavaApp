package devops.obs.model;

public class Product {
	
	String productName;
	double price;
	String productImage;
	public String getProduct() {
		return productName;
	}
	public void setProduct(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Product(String productName, double price, String productImage) {
		super();
		this.productName = productName;
		this.price = price;
		this.productImage = productImage;
	}
}
