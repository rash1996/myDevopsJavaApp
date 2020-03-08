package devops.obs.obscontroller;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import devops.obs.obscontroller.UserLoginController;


public class LoginTest extends Mockito{
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

    @Test
    public void testLoginSuccess() throws Exception {
        when(request.getParameter("uName")).thenReturn("rash");
        when(request.getParameter("password")).thenReturn("admin");
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/product.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserLoginController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Login successfull...", result);
      
    }
    
    //@Test
    public void testLoginFail() throws Exception {
        when(request.getParameter("uName")).thenReturn("rash");
        when(request.getParameter("pass")).thenReturn("test");
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserLoginController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Enter Valid Username and Password", result);
      
    }
}