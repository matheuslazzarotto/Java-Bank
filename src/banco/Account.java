package banco;

public class Account {

	private double balance;
	private String accountNumber;
	private static int accountCount = 0;
	
	//Account Constructor
	public Account(double initialBalance) {
		this.balance = initialBalance;
		accountCount++;
		this.accountNumber = generateAccountNumber();
		
	}

	private String generateAccountNumber() {
		return "ACC" + accountCount;
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited " + amount + ". New Balance: " + balance);
			
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}
	
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }	
	}

	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

    public static int getTotalAccounts() {
        return accountCount;
    }	
}	
	
