package Models;

public class CreditCard {
    private float balance;

    public CreditCard(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }
    public void decreaseBalance(float decreaseAmount) {
        this.balance -= decreaseAmount;
    }
}
