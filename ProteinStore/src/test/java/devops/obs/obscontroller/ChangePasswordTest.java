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


public class ChangePasswordTest extends Mockito{
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
    public void testChangePassword() throws Exception {
        when(request.getParameter("uname")).thenReturn("root");
        when(request.getParameter("newpassword")).thenReturn("admin");
        when(request.getParameter("confirmpassword")).thenReturn("admin");
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserPasswordController().doPost(request, response);
     
        verify(rd).include(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Successfully updated password", result);
      
    }
   
}