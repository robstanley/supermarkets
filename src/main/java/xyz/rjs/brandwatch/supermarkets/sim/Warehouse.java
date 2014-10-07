package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;

public class Warehouse extends DeliverablePlace {

    public Warehouse(EventBus eventBus) {
        super(eventBus);
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
