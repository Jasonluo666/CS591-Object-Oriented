import java.util.ArrayList;

//I left the accounts as Strings because I don't have the customer class yet
public class Bank {

	/*static */ private ArrayList<User> users;

    public Bank() {
    	users = new ArrayList<User>();
    	
    	// dummy users
    	createUser("YuanZhang", "123","zuidade");
    	createUser("NeilRaya", "456","zuixiaode");
    	createUser("JasonLuo", "789","zuixide");
    	
//    	retrieveUser("YuanZhang").createAccount("CheckingAccount");
//    	retrieveUser("YuanZhang").createAccount("SavingAccount");
//    	retrieveUser("YuanZhang").createAccount("LoanAccount");
    }
    
    /*static */ public boolean createUser(String user_name, String psw, String desc) {
    	for(User user: users) {
    		if(user.getName().equals(user_name)) {
				return false;
    		}
    	}
    	
    	users.add(new User(user_name, psw,desc));
    	return true;
    }
    
    /*static */ public User login(String user_name, String psw) {
    	for(User user: users) {
    		if(user.getName().contentEquals(user_name)) {
    			if(user.validatePSW(psw)) {
    				return user;
    			}
    			else {
					return null;
				}
    		}
    	}
    	
    	return null;
    }

    public String getReport() {
    	String report = "";
    	for(User user : users) {
    		report += user.getName() + ": \n" + user;
		}
    	return report;
    }

    public ArrayList<User> retrieveUserList() {
    	
        return users;
    }

    public User retrieveUser(String user_name) {
    	for(User user: users) {
    		if(user.getName().contentEquals(user_name)) {
    			return user;
    		}
    	}
    	
    	return null;
    }
}
