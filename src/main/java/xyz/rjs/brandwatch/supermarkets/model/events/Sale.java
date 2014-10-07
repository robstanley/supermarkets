package xyz.rjs.brandwatch.supermarkets.model.events;

public class Sale {
    private int amountSold;
    private int remainingStock;

    public int getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }

    public int getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(int remainingStock) {
        this.remainingStock = remainingStock;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "amountSold=" + amountSold +
                ", remainingStock=" + remainingStock +
                '}';
    }
}
