import java.util.*;
interface BankAcc {
    void deposit(double amount);
    boolean withdraw(double amount);
    double checkBalance();
}
interface atm {
    void displayMenu();
    void handleMenu();
}
class UserBankAcc implements BankAcc {
    private double balance;
    public UserBankAcc() {
        this.balance = 0;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public double checkBalance() {
        return balance;
    }
}
public class ATMMachine implements atm {
    private BankAcc acc;
    public ATMMachine(BankAcc account) {
        this.acc = account;
    }
    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    public void handleMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter depositing amount: ");
                    double depositAmount = input.nextDouble();
                    acc.deposit(depositAmount);
                    System.out.println("Deposit done.");
                    break;
                case 2:
                    System.out.print("Enter amount withdrawn: ");
                    double withdrawAmount = input.nextDouble();
                    if (acc.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal done. Take the money");
                    } else {
                        System.out.println("Insufficient funds. in your account");
                    }
                    break;
                case 3:
                    System.out.println("Your balance is: " + acc.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
        input.close();
    }

    public static void main(String[] args) {
        BankAcc bankAccount = new UserBankAcc();
        atm atm = new ATMMachine(bankAccount);
        atm.handleMenu();
    }
}
