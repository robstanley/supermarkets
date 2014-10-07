package xyz.rjs.brandwatch.supermarkets.model.events;

import xyz.rjs.brandwatch.supermarkets.model.Warehouse;

public class Order {
    private int volume;
    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Order{" +
                "volume=" + volume +
                ", warehouse=" + warehouse +
                '}';
    }
}
