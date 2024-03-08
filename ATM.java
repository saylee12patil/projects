package saylee;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using ATM");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initialize user's account with a balance of 1000
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            int choice = atm.scanner.nextInt();
            atm.processChoice(choice);
        }
    }
}