public class DiscountBill extends GroceryBill {
    public static final double ZERO_DISCOUNT = 0.0D;

    private boolean regularCustomer;

    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0D;
    }

    @Override
    public void add(Item i) {
        super.add(i);

        if (regularCustomer && i.getDiscount() > 0.0D) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double full = super.getTotal();
        if (!regularCustomer) return full;

        double res = full - discountAmount;
        return Math.rint(res * 100.0D) / 100.0D;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        if (!regularCustomer) return ZERO_DISCOUNT;
        return Math.rint(discountAmount * 100.0D) / 100.0D;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return ZERO_DISCOUNT;

        double full = super.getTotal();
        double paid = getTotal();

        if (full == 0.0D) return 0.0D;

        double percent = 100.0D - (paid * 100.0D) / full;
        return Math.rint(percent * 100.0D) / 100.0D;
    }
}