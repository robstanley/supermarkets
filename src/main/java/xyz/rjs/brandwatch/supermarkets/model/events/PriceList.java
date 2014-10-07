package xyz.rjs.brandwatch.supermarkets.model.events;

public class PriceList {
    private int currentPrice;

    public PriceList(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "currentPrice=" + currentPrice +
                '}';
    }
}
