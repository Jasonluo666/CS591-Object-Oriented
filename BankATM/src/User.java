import java.util.ArrayList;
import java.util.Random;

public class User {
    private String user_name;
    private String password;
    private ArrayList<Account> accounts;
    private Random random;
    private String desc;

    User(String user_name, String password,String desc){
        random = new Random();
        this.user_name = user_name;
        this.password = password;
        this.desc = desc;
        accounts = new ArrayList<Account>();
    }

    public int getAccountNumber() {
        return accounts.size();
    }

    public String getName() {
        return user_name;
    }

    public boolean validatePSW(String psw) {
        return password.equals(psw);
    }

    public String getDesc() {
        return desc;
    }

    public String createAccount(String type) {
        String id = Integer.toString(Math.abs(random.nextInt()));

        if(type.equals("CheckingAccount")) {
            accounts.add(new CheckingAccount(id));
            System.out.println("Checking account created. ID: " + id);
            return id;
        }
        else if(type.equals("SavingAccount")) {
            accounts.add(new SavingAccount(id));
            System.out.println("Saving account created. ID: " + id);
            return id;
        }
        else if(type.equals("LoanAccount")) {
            accounts.add(new LoanAccount(id));
            System.out.println("Loan account created. ID: " + id);
            return id;
        }
        else {
            System.out.println("Failed to create an account.");
            return "";
        }
    }

    public String[][] retrieveAccountList() {
    	String[][] str = new String[accounts.size()][];
    	
    	for(int i=0; i<accounts.size(); i++) {
    		String info[] = new String[3];
   	
    		info[0] = accounts.get(i).getAccountID();
    		
    		if(accounts.get(i) instanceof CheckingAccount)
    			info[1] = "CheckingAccount";
    		else if(accounts.get(i) instanceof SavingAccount)
    			info[1] = "SavingAccount";
    		else if(accounts.get(i) instanceof LoanAccount)
    			info[1] = "LoanAccount";
    		
    		info[2] = accounts.get(i).toString();
    		
    		str[i] = new String[] {info[0],info[1],info[2]};
    	}
        return str;
    }

    public ArrayList<Account> retrieveAccountByType(String type) {
    	ArrayList<Account> found_accounts = new ArrayList<Account>();
    	
        for(Account account: accounts) {
            if(type.equals("CheckingAccount") && account instanceof CheckingAccount) {
            	found_accounts.add(account);
            }
            else if (type.equals("SavingAccount") && account instanceof SavingAccount) {
            	found_accounts.add(account);
            }
            else if (type.equals("LoanAccount") && account instanceof LoanAccount) {
            	found_accounts.add(account);
            }
        }
        
        if(found_accounts.size() == 0)
        	return null;
        else
        	return found_accounts;
    }

    public Account retrieveAccountByID(String id) {
        for(Account account: accounts) {
            if(account.getAccountID().contentEquals(id)) {
                return account;
            }
        }

        return null;
    }

    public String toString() {
        String report = "";
        for(Account account : accounts) {
            for(Transaction transaction : account.getTransaction())
                report += transaction + "\n";
        }
        return report;
    }
}
