package Default;

import java.util.Scanner;

public class Account {
    // Declare properties
    double balance;
    double previousTransaction;
    String customerName;
    String customerID;

    // Class constructor
    Account(String cname, String cid) {
        this.customerName = cname;
        this.customerID = cid;
    }

    // Function for depositing $
    void deposit(double amount) {
        if(amount != 0) {
            this.balance = balance + amount;
            this.previousTransaction = amount;
        }
    }

    // Function for withdrawing $
    void withdraw(int amount) {
        if(amount != 0) {
            this.balance = balance - amount;
            this.previousTransaction = -amount;
        }
    }

    // Function showing the previous transaction
    void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: $" + previousTransaction);
        } else if(previousTransaction < 0) {
            System.out.println("Withdrew: $" + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction has occurred");
        }
    }

    // Function calculating the interest of current $ after x num of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    // Function showing the main menu
    void showMenu() {
        char choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What can we help you with today?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char choice1 = scanner.next().charAt(0);
            choice = Character.toUpperCase(choice1);
            System.out.println();

            switch(choice) {
                // Case 'A' checks balance
                case 'A' :
                    String balanceFormat =  String.format("%.2f", balance);
                    System.out.println("====================================");
                    System.out.println("Balance = $" + balanceFormat);
                    System.out.println("====================================");
                    System.out.println();
                    break;
                // Case 'B' deposits $
                case 'B' :
                    System.out.println("Enter an amount to deposit: ");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    System.out.println();
                    break;
                // Case 'C' withdraws $
                case 'C' :
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                // Case 'D' views previous transaction
                case 'D' :
                    System.out.println("====================================");
                    getPreviousTransaction();
                    System.out.println("====================================");
                    System.out.println();
                    break;
                // Case 'E' calculates interest
                case 'E' :
                    System.out.println("Enter number of years to simulate interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                // Case 'F' exits
                case 'F' :
                    System.out.println("====================================");
                    break;
                // The default lets user know to enter valid chars
                default :
                    System.out.println("Error: invalid option selected. Please enter A, B, C, D, E, or F");
                    break;
            }
        } while(choice != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
