package xyz.rjs.brandwatch.supermarkets.model.events;

public class Balance {
    private int balance;

    public Balance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                '}';
    }
}
