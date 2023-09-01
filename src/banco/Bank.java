package banco;

import java.util.ArrayList;
import java.util.Scanner;

// Class definition for Bank
public class Bank {
    // Private instance variable
    // ArrayList to store multiple Account objects.
    private ArrayList<Account> accounts = new ArrayList<>();

    // Public method to create a new Account object.
    public void createAccount(double initialBalance) {
        Account newAccount = new Account(initialBalance);  // Create new Account with initial balance.
        accounts.add(newAccount);  // Add the new Account to the accounts ArrayList.
        System.out.println("Account created with Account Number: " + newAccount.getAccountNumber());
    }

    // Public method to get an Account object based on accountNumber.
    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {  // Loop through each Account in the ArrayList.
            if (acc.getAccountNumber().equals(accountNumber)) {  // Check if the account number matches.
                return acc;  // Return the matching Account object.
            }
        }
        return null;  // Return null if no Account object is found with the given accountNumber.
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        Bank myBank = new Bank();  // Create a new Bank object.
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to take user input.

        // Continuous loop for menu options.
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();  // Take the user's menu choice.

            // Switch case to handle menu options.
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
                    scanner.close();  // Close the Scanner.
                    System.exit(0);  // Terminate the program.
            }
        }
    }
}
