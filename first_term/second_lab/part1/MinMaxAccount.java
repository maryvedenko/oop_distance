import java.util.LinkedList;
import java.util.List;

public class MinMaxAccount {
    private int balance;

    private int minBalance;
    private int maxBalance;

    private List<String> historyTransaction;
    private List<String> historyBalance;

    public MinMaxAccount(Startup s) {
        this.balance = s.getBalance();
        this.minBalance = this.balance;
        this.maxBalance = this.balance;

        this.historyTransaction = new LinkedList<>();
        this.historyBalance = new LinkedList<>();

        this.historyTransaction.add(valueToHistory(s.getBalance()));
        this.historyBalance.add(toString());
    }

    public void debit(Debit d) {
        this.balance += d.getBalance();
        updateMinMax();
        this.historyTransaction.add(valueToHistory(d.getBalance()));
        this.historyBalance.add(toString());
    }

    public void credit(Credit c) {
        this.balance += c.getBalance();
        updateMinMax();
        this.historyTransaction.add(valueToHistory(c.getBalance()));
        this.historyBalance.add(toString());
    }

    public int getBalance() {
        return this.balance;
    }

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }

    private void updateMinMax() {
        if (balance < minBalance) minBalance = balance;
        if (balance > maxBalance) maxBalance = balance;
    }

    public boolean equals(Object o) {
        if (o instanceof MinMaxAccount) {
            return (getBalance() == ((MinMaxAccount) o).getBalance());
        }
        return false;
    }

    private String valueToHistory(int value) {
        int absValue = Math.abs(value);
        return ((value < 0) ? "-" : "") + "$" + absValue / 100 + "." + absValue % 100 / 10 + absValue % 10;
    }

    public String toString() {
        int absBalance = Math.abs(this.balance);
        return ((this.balance < 0) ? "-" : "") + "$" + absBalance / 100 + "." + absBalance % 100 / 10 + absBalance % 10;
    }
}