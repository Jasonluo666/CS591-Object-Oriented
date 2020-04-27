import java.util.ArrayList;

public class BankManager {
	Bank bank;
	
	public BankManager(Bank bank) {
		this.bank = bank;
	}
	
	public String getReport() {
		return bank.getReport();
	}
	
	public ArrayList<User> retrieveUserList() {
    	return bank.retrieveUserList();
    }
	
	public User retrieveUser(String user_name) {
    	return bank.retrieveUser(user_name);
    }
}
