public class User {
    private String cardNumber;
    private int pin;
    private BankAccount account;

    public User(String cardNumber, int pin, BankAccount account) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.account = account;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public BankAccount getAccount() {
        return account;
    }
}