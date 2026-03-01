import java.util.Scanner;

public class ATM {
    private User user;
    private Scanner scanner;
    private boolean sessionActive;

    public ATM(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
        this.sessionActive = false;
    }

    public void start() {
        System.out.println("===== Welcome to ATM =====");
        authenticate();

        if (sessionActive) {
            showMenu();
        }
    }

    private void authenticate() {
        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (user.verifyPin(enteredPin)) {
            sessionActive = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid PIN. Access Denied.");
        }
    }

    private void showMenu() {
        while (sessionActive) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

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
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: ₹" + user.getAccount().getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        user.getAccount().deposit(amount);
        System.out.println("Amount deposited successfully.");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (user.getAccount().withdraw(amount)) {
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void exit() {
        sessionActive = false;
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}