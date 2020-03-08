package devops.obs.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import devops.obs.db.UserDb;
import devops.obs.model.User;

public class UserService {
	UserDb userDb;
	public UserService(){
		userDb = new UserDb();
	}
	
	public boolean isAuthorized(User signup){
		boolean isValidUser=false;
		
		if(signup!=null && signup.getUserName()!=null && signup.getPassword()!=null){
			
			Map<String, User> userMapping = UserDb.userProfile;
			
			if (userMapping.containsKey(signup.getUserName())) {
				
				User user = userMapping.get(signup.getUserName());
				if (user.getPassword().equals(signup.getPassword())) {
					isValidUser=true;
				}
				
			}
		}		
		return isValidUser;
	}
	
	public boolean updatePassword(User user){
		boolean isUpdated=false;
		if(user!=null && user.getUserName()!=null){
			
			for (Map.Entry<String, User> entry : UserDb.userProfile.entrySet()) {
				 if(entry.getKey().equals(user.getUserName())){
					 user.setFirstName(entry.getValue().getFirstName());
					 user.setLastName(entry.getValue().getLastName());
					 user.setEmail(entry.getValue().getEmail());
				     entry.setValue(user);
					 isUpdated=true;
				 }	
			}
		}
		return isUpdated;		
	}
	
	public boolean doRegistration(User user){
		boolean isCreated=false;
		if(user!=null && user.getUserName()!=null){			
			UserDb.userProfile.put(user.getUserName(), user);
			isCreated=true;		
		}
		return isCreated;
	}
	
}
