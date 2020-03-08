package devops.obs.obscontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.obs.db.ProductDb;
import devops.obs.model.Order;
import devops.obs.model.Product;

public class ProductController extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String[] selectedVal= request.getParameterValues("items");
		String[] quantity = request.getParameterValues("quantity");
			
		if(selectedVal == null ){
			response.sendRedirect("product.jsp?msg=Please click on check box and select quantities");
		} 
		else {
			ProductDb product = new ProductDb();
			Order ord;
			ArrayList<Product> prodList = new ArrayList<>();
			ArrayList<Order> orderList = new ArrayList<>();
			ArrayList<String> quantity1 = new ArrayList<>();
			PrintWriter pout= response.getWriter();
			Set entrySet = product.productData.entrySet();
			Iterator it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry pr = (Map.Entry) it.next();
				prodList.add((Product) pr.getValue());
			}
			for(String quan: quantity){
				if(!quan.isEmpty()){
					quantity1.add(quan);
				}
			}
			if(selectedVal.length == quantity1.size()){
			for (int i = 0; i < selectedVal.length; i++) {
				ord = new Order();
				for (Product productList : prodList) {
					if (selectedVal[i].equals(productList.getProduct())) {	
						if (quantity1.get(i) != null || !quantity1.get(i).equals("")) {
							ord.setProduct(productList.getProduct());						
							ord.setPrice(productList.getPrice());						
							ord.setQuantity(Float.parseFloat(quantity1.get(i)));
							ord.setFinalPrice((productList.getPrice()* Float.parseFloat(quantity1.get(i))));
						}
					}					
				}
				if(ord != null)
				orderList.add(ord);
			}
			}
		
			if (orderList.size() != 0) {
				request.setAttribute("finalOrderList", orderList);
				RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
				rd.forward(request, response);
				pout.write("Going to Cart...");
			}
			else{
				response.sendRedirect("product.jsp?msg=Please select items properly");
			}
			
		}
		
	}

}
