public class Main {
    public static void main(String[] args) {

        // Create bank account with initial balance
        BankAccount account = new BankAccount(10000);

        // Create user with PIN
        User user = new User("1234567890", 1234, account);

        // Create ATM and start session
        ATM atm = new ATM(user);
        atm.start();
    }
}