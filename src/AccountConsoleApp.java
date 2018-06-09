import prGuiAccount.Account;

public class AccountConsoleApp {
	public static void main(String args[]) {
		Account account = new Account(5000);
		account.deposit(3000);
		double realExt = account.withdraw(6000);

		System.out.println("Balance     = " + account.getBalance());
		System.out.println("Withdraw    = " + realExt);
	}
}
