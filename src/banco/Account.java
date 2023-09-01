package banco; // Specifies the package name, which is "banco" in this case.

// Class definition for Account
public class Account {

    // Private instance variables
	private double balance;          // The balance amount for the account.
	private String accountNumber;    // The unique account number for this account.

    // Private static variable
	private static int accountCount = 0; // A class-level variable to keep track of the total number of accounts created.
	
	// Account Constructor
    // Initializes a new Account object with an initial balance.
	public Account(double initialBalance) {
		this.balance = initialBalance; // Set the initial balance.
		accountCount++;                 // Increment the account count.
		this.accountNumber = generateAccountNumber(); // Generate a new account number.
	}

    // Private method to generate account numbers.
	private String generateAccountNumber() {
		return "ACC" + accountCount; // The account number is formed by appending the accountCount to "ACC".
	}
	
    // Public method to deposit money into the account.
	public void deposit(double amount) {
		if (amount > 0) { // Check if the deposit amount is positive.
			balance += amount; // Add the amount to the balance.
			System.out.println("Deposited " + amount + ". New Balance: " + balance); // Display a success message.
		} else {
			System.out.println("Invalid deposit amount."); // Display an error message.
		}
	}
	
    // Public method to withdraw money from the account.
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) { // Check if the withdrawal amount is positive and less than or equal to the current balance.
			balance -= amount; // Subtract the amount from the balance.
			System.out.println("Withdrew " + amount + ". New Balance: " + balance); // Display a success message.
		} else {
			System.out.println("Invalid withdrawal amount or insufficient funds."); // Display an error message.
		}
	}

    // Getter method to retrieve the account balance.
	public double getBalance() {
		return balance;
	}
	
    // Getter method to retrieve the account number.
	public String getAccountNumber() {
		return accountNumber;
	}

    // Static method to get the total number of accounts created.
    public static int getTotalAccounts() {
        return accountCount;
    }	
}
