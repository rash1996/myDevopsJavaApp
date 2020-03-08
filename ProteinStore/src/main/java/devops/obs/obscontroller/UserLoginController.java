package devops.obs.obscontroller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import devops.obs.model.User;
import devops.obs.service.UserService;

public class UserLoginController extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String uname=request.getParameter("uName");
		String pass=request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("uname", uname);
		if (uname.isEmpty() || pass.isEmpty()){
			response.sendRedirect("index.jsp?msg=Username and Password should not be empty");
			  } else {
				
				  User signUp=new User("", "", uname, pass, "");

					PrintWriter pout= response.getWriter();
					if (new UserService().isAuthorized(signUp)) {
						pout.write("Login successfull...");
						RequestDispatcher rd = request.getRequestDispatcher("/product.jsp");
						rd.forward(request,response);
						return;
					}
					pout.write("Login fail...");
					 
					response.sendRedirect("index.jsp?msg=Enter Valid Username and Password");
					
					
			  }
	}

}