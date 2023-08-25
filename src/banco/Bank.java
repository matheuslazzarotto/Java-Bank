package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank{
	private ArrayList<Account> accounts = new ArrayList<>();
	
	public void createAccount(double initialBalance) {
		Account newAccount = new Account(initialBalance);
		accounts.add(newAccount);
		System.out.println("Account created with Account Number: " + newAccount.getAccountNumber());
	}
	
	public Account getAccount(String accountNumber) {
		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				return acc;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Bank myBank = new Bank();
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    myBank.createAccount(initialBalance);
                    break;
                case 2:
                    System.out.println("Enter Account Number: ");
                    String accNumber = scanner.next();
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    Account acc1 = myBank.getAccount(accNumber);
                    if (acc1 != null) {
                        acc1.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account Number: ");
                    accNumber = scanner.next();
                    System.out.println("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    Account acc2 = myBank.getAccount(accNumber);
                    if (acc2 != null) {
                        acc2.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter Account Number: ");
                    accNumber = scanner.next();
                    Account acc3 = myBank.getAccount(accNumber);
                    if (acc3 != null) {
                        System.out.println("Account Balance: " + acc3.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
