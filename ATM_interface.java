
import java.util.Scanner;

// Class representing a user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("🏧 Welcome to the ATM!");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. 💸 Withdraw");
            System.out.println("2. 💰 Deposit");
            System.out.println("3. 📊 Check Balance");
            System.out.println("4. ❌ Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("⚠️ Invalid option. Please try again.");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful. Please collect your cash.");
        } else {
            System.out.println("❌ Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("✅ Deposit successful.");
        } else {
            System.out.println("❌ Deposit failed. Please enter a valid amount.");
        }
    }

    private void handleCheckBalance() {
        System.out.printf("📌 Your current balance is: $%.2f\n", account.getBalance());
    }
}

// Main class to run the program
public class ATM_interface {
    public static void main(String[] args) {
        // Initialize the user's bank account with a starting balance (e.g., $1000)
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
