package xyz.rjs.brandwatch.supermarkets.sim.travel;

import com.google.common.eventbus.EventBus;
import xyz.rjs.brandwatch.supermarkets.sim.DeliverablePlace;

public class Delivery extends AbstractTravellingAction {
    private DeliverablePlace destination;
    private int amount;

    public Delivery(EventBus eventBus, int distance, DeliverablePlace destination, int amount) {
        super(eventBus, distance);
        this.destination = destination;
        this.amount = amount;
    }

    @Override
    protected void arrivalAction() {
        destination.addStock(amount);
    }
}
