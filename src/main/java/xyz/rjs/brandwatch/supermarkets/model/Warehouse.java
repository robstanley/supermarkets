package xyz.rjs.brandwatch.supermarkets.model;

public class Warehouse {
    private int stock;
    private int distanceFromShop;

    public int getDistanceFromShop() {
        return distanceFromShop;
    }

    public void setDistanceFromShop(int distanceFromShop) {
        this.distanceFromShop = distanceFromShop;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addStock(int stock) {
        this.stock += stock;
    }
}
