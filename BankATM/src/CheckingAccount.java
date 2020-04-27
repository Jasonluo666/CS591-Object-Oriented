
public class CheckingAccount extends Account {
	CheckingAccount(String id){
		super(id);
	}
	
	@Override
	public void actionWithCharge(String action, Money money) {
		// TODO Auto-generated method stub

		switch(action){
		case "open":
			for(Money currency: balance) {
				currency.setBalance(currency.getBalance() - create_account_fee);
			}
			
			break;
		case "close":
			for(Money currency: balance) {
				currency.setBalance(currency.getBalance() - close_account_fee);
			}
			
			break;
		case "transfer":
			for(Money currency: balance) {
				if(currency.getCurrency().contentEquals(money.getCurrency())) {
					currency.setBalance(currency.getBalance() - money.getBalance() - transfer_fee);
				}
			}
			
			break;
		case "withdraw":
			for(Money currency: balance) {
				if(currency.getCurrency().contentEquals(money.getCurrency())) {
					currency.setBalance(currency.getBalance() - money.getBalance() - withdraw_fee);
				}
			}
			
			break;
		case "save":
			for(Money currency: balance) {
				if(currency.getCurrency().contentEquals(money.getCurrency())) {
					currency.setBalance(currency.getBalance() + money.getBalance());
				}
			}
			
			break;
		}
		
		transactions.add(new Transaction(super.getAccountID(), action, money, balance));
	}
}
