package devops.obs.obscontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.obs.model.User;
import devops.obs.service.UserService;

public class UserPasswordController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String newpass = request.getParameter("newpassword");
		String confirmpass = request.getParameter("confirmpassword");
		String uname = request.getParameter("uname");

		if (newpass.isEmpty() || confirmpass.isEmpty() || uname.isEmpty()) {
			out.println("<font color=red>Please fill all the fields</font>");
		} 
		else {
			if (newpass.equals(confirmpass)) {

				User updatePwd = new User("", "", uname, newpass, "");
				if (new UserService().updatePassword(updatePwd)) {
					response.sendRedirect("index.jsp?msg1=Successfully updated password");
				}	
				else {
					response.sendRedirect("index.jsp?msg=Update password failed. User is not registered.");
				}
			}

			else {
				response.sendRedirect("forgotpassword.jsp?msg=Password and Confirm Password doesn't matches");
			}
		}
	}
}
