package devops.obs.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devops.obs.model.User;

public class UserDb {

	public static final Map<String, User> userProfile = new HashMap<>();

	public UserDb() {

		User u1 = new User("Rashabihari", "Panda", "rash", "admin", "rashabihari.panda@wipro.com");
		User u2 = new User("abc", "xyz", "root", "root", "rash@wipro.com");
		
		userProfile.put(u1.getUserName(), u1);
		userProfile.put(u2.getUserName(), u2);

		
	}

}
