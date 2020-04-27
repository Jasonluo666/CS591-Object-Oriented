
public class LoanAccount extends Account {
	LoanAccount(String id){
		super(id);
	}
	
	@Override
	public void actionWithCharge(String action, Money money) {
		// TODO Auto-generated method stub

		switch(action){
		case "open":
			for(Money currency: balance) {
				currency.setBalance(currency.getBalance() + create_account_fee);
			}
			
			break;
		case "close":
			for(Money currency: balance) {
				currency.setBalance(currency.getBalance() + close_account_fee);
			}
			
			break;
		case "interest":
			for(Money currency: balance) {
				currency.setBalance(currency.getBalance() + money.getBalance() * interest_ratio);
			}
			
			break;
		case "loan":
			for(Money currency: balance) {
				currency.setBalance(currency.getBalance() + money.getBalance());
			}
			
			break;
		case "save":
			for(Money currency: balance) {
				if(currency.getCurrency().contentEquals(money.getCurrency())) {
					currency.setBalance(currency.getBalance() - money.getBalance());
				}
			}
			
			break;
		}
		
		transactions.add(new Transaction(super.getAccountID(), action, money, balance));
	}
	
	public String toString() {
		return balance[0].toString();
	}
}
