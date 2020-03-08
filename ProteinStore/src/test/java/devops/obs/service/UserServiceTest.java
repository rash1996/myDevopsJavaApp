package devops.obs.service;

import static org.junit.Assert.*;

import org.junit.Test;

import devops.obs.model.User;

public class UserServiceTest {

	@Test
	public void testIsAutherozied() {
		User u1 = new User("Rashabihari", "Panda", "rash", "admin", "rashabihari.panda@wipro.com");
		assertEquals(true,new UserService().isAuthorized(u1));
	}

	/*@Test
	public void testUpdatePassword() {
		User u1=new User("","", "rash", "root", "rashabihari.panda@wipro.com");
		assertEquals(true,new UserService().updatePassword(u1));
	}

	@Test
	public void testDoRegistration() {
		User u1=new User("Sam", "Saran", "admin", "admin", "sam12@abc.com");
		assertEquals(true,new UserService().doRegistration(u1));
	}*/

}
