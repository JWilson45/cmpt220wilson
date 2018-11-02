public class Savings extends Account{
	private final double overdraftLimit;
	
	public Savings(){
		overdraftLimit = 0;
	}
	
	public Savings (int id, double balance) {
		super(id,balance);
		overdraftLimit = 0;
	}
	
	@Override
	public void withdraw(double amount) {
		if ((getBalance() - amount) > overdraftLimit) {
			setBalance(getBalance() - amount);
		} else System.out.println("Cannot withdraw more than your current ballence: " + getBalance()); }

	public double getOverdraftLimit() {
		return overdraftLimit;
	}
	
}
