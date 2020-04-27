
public class Transaction {
	private String opr_type;
	private Money money;
	private Money[] current_balance;
	private String account_id;
	
	Transaction(String account_id, String opr_type, Money money, Money[] current_balance) {
		this.account_id = account_id;
		
		setType(opr_type);
		setBalance(current_balance);
		setAmount(money);
	}
	
	public void setType(String opr_type) {
		this.opr_type = opr_type;
	}
	
	public void setAmount(Money money) {
		this.money = money;
	}
	
	public void setBalance(Money[] current_balance) {
		this.current_balance = new Money[current_balance.length];
		for(int i = 0; i < current_balance.length; i++) {
			this.current_balance[i] = new Money(current_balance[i]);
		}
	}

	//This is to print the balance of the affected currency
	private Double findCurrencyBalance() {
		String s = money.getCurrency();
		for(Money m : current_balance){
			if(m.getCurrency().equals(s)) {
				return m.getBalance();
			}
		}
		return Double.valueOf(0);
	}
	
	public String toString() {
		return "Account ID: " + account_id + " | Action type: " + opr_type + " | " + money + " | " + "Current balance of " + money.getCurrency() + ": " + findCurrencyBalance();
	}
}
