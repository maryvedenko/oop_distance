import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;
    private List<Item> receipt;
    private double total;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.receipt = new ArrayList<>();
        this.total = 0.0D;
    }

    public void add(Item i) {
        this.receipt.add(i);
        this.total += i.getPrice();
    }

    public double getTotal() {
        return Math.rint(this.total * 100.0D) / 100.0D;
    }

    public Employee getClerk() {
        return this.clerk;
    }

    // Добавил, чтобы DiscountBill мог видеть список товаров корректно
    protected List<Item> getReceipt() {
        return this.receipt;
    }
}