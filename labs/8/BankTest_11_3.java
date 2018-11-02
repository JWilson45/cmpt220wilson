public class BankTest_11_3 {

	public static void main(String[] args) {
		Account acc1 = new Account(1, 3);
		Savings savings_account1 = new Savings(2, 40000);
		Checking checking_account1 = new Checking(3, 20, -300);

		acc1.withdraw(500);
		acc1.deposit(48);
		acc1.setAnnualInterestRate(8.0);
		
		savings_account1.withdraw(21000);
		savings_account1.deposit(1010000);
		savings_account1.setAnnualInterestRate(9.0);
		
		checking_account1.withdraw(500);
		checking_account1.deposit(7000);
		checking_account1.setAnnualInterestRate(3.0);

		System.out.println(acc1.toString());
		System.out.println(checking_account1.toString());
		System.out.println(savings_account1.toString());

	}

}
