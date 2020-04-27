import java.util.ArrayList;
import java.util.Collections;

public abstract class Account {
	protected String id;
	protected Money[] balance;

	private static final int CURRENCY_LIMIT = 3;
	
	static public Double create_account_fee = 10.0;
	static public Double close_account_fee = 10.0;
	static public Double transfer_fee = 10.0;
	static public Double withdraw_fee = 10.0;
	static public Double interest_ratio = 0.1;
	static public Double interest_bar = 1000.0;
	
	ArrayList<Transaction> transactions;
	
	Account(String id){
		this.id = id;
		transactions = new ArrayList<Transaction>();
		balance = new Money[CURRENCY_LIMIT];
		for(int i = 0; i < CURRENCY_LIMIT; i++) {
			balance[i] = new Money();
		}
	}
	
	public String getAccountID() {
		return id;
	}
	
	public ArrayList<Transaction> getTransaction(){
		return transactions;
	}
	
	public void setCurrency(int index, String currency) {
		balance[index].setCurrency(currency);
		balance[index].setBalance(0.0);
	}

	public String[] getCurrencies() {
		String[] res = new String[balance.length];
		for(int i = 0; i < balance.length; i++) {
			res[i] = balance[i].getCurrency();
		}
		return res;
	}
	
	public String toString() {
		return balance[0] + " | " + balance[1] + " | " + balance[2];
	}
	
	public ArrayList<Transaction> getTranscation(){
		return transactions;
	}
	
	abstract public void actionWithCharge(String action, Money money);
}
