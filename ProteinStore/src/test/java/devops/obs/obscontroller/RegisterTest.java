package devops.obs.obscontroller;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class RegisterTest extends Mockito{
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;
	 @Mock
	 RequestDispatcher rd;
	 @Before
	 public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }

    //@Test
    public void testRegistrationSuccess() throws Exception {
    	when(request.getParameter("firstname")).thenReturn("fname");
    	when(request.getParameter("lastname")).thenReturn("lname");
        when(request.getParameter("email")).thenReturn("abc@xyz.com");
        when(request.getParameter("uName")).thenReturn("test"); 
        when(request.getParameter("pass")).thenReturn("test");
        when(request.getParameter("confirmpass")).thenReturn("test");
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserRegisterController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Successfuly registered...", result);
      
    }
    
    //@Test
    public void testRegistrationFail() throws Exception {
    	when(request.getParameter("firstname")).thenReturn("fname");
    	when(request.getParameter("lastname")).thenReturn("lname");
        when(request.getParameter("email")).thenReturn("abc@xyz.com");
        when(request.getParameter("uName")).thenReturn("test"); 
        when(request.getParameter("pass")).thenReturn("test");
        when(request.getParameter("confirmpass")).thenReturn("admin");
        when(request.getRequestDispatcher("/register.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserRegisterController().doPost(request, response);
     
        verify(rd).include(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("<font color=red>Password and Confirm Password doen't matches</font>", result);
    }
}