public class Checking extends Account{
	private double overdraftLimit;
	
	public Checking(){
		overdraftLimit = -100;
	}
	
	public Checking(int id, double balance, double overdraftLimit) {
		super(id,balance);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		if ((getBalance() - amount) > overdraftLimit) {
			setBalance(getBalance() - amount);
		} else System.out.println("Cannot withdraw more than your current ballence: " + getBalance()); }
	
	@Override
	public String toString() {
		return super.toString() + "\nOverdraft limit: $" + overdraftLimit;
	}
	
}
