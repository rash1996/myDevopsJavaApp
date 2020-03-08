package devops.obs.db;

import java.util.HashMap;
import java.util.Map;

import devops.obs.model.Product;

public class ProductDb {
	
	public static final Map<String, Product> productData = new HashMap<>();
	
	String imgFish = "https://5.imimg.com/data5/VI/TA/GLADMIN-43554645/rohu-fish-500x500.png";
	String imgChicken = "https://d27ucmmhxk51xv.cloudfront.net/media/english/illustration/chicken.jpg?version=1.1.91";
	String imgMutton = "https://images.sg.content-cdn.io/cdn//in-resources/8845e144-8902-4204-b80f-9dc7dc2f4bcb/Images/ProductImages/Source/3100156.jpg";

	public ProductDb(){
		Product prod1= new Product("Fish", 180, imgFish);
		Product prod2= new Product("Chicken", 220, imgChicken);
		Product prod3= new Product("Mutton", 650, imgMutton);
		
		productData.put(prod1.getProduct(), prod1);
		productData.put(prod2.getProduct(), prod2);
		productData.put(prod3.getProduct(), prod3);
	}
}
