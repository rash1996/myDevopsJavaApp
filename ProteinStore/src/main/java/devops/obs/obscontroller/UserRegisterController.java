package devops.obs.obscontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.obs.model.User;
import devops.obs.service.UserService;

public class UserRegisterController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  String fname = request.getParameter("firstname");
		  String lname = request.getParameter("lastname");
		  String uname = request.getParameter("uName");
		  String pass = request.getParameter("pass");
		  String confirmpass = request.getParameter("confirmpass");
		  String email = request.getParameter("email");
		  String registerPage = "/register.jsp";
		 

		  if (fname.isEmpty() || lname.isEmpty() || uname.isEmpty() || pass.isEmpty() || confirmpass.isEmpty() || email.isEmpty()) {
			   RequestDispatcher rd = request.getRequestDispatcher(registerPage);
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request, response);
		  } 
		  else {
			   if(pass.equals(confirmpass)) {

			  User portalNewUser=new User(fname,lname,uname,pass,email);
			
			    if(new UserService().doRegistration(portalNewUser)){   
				   out.println("<font color=green>Successfully Registered</font>");
				   response.sendRedirect("index.jsp?msg1=Successfully Registered");
				}
			    else
			    {
			  	  RequestDispatcher rd = request.getRequestDispatcher(registerPage);
			  	  out.println("<font color=red>Registration fail</font>");
			  	  rd.include(request, response);
			    }
			    
			  }
			  else
			  {
				  out.println("<font color=red>Password and Confirm Password doen't matches</font>");
				  RequestDispatcher rd = request.getRequestDispatcher(registerPage);
				  rd.include(request, response);
			  }
		 }
		 }
}
