package xyz.rjs.brandwatch.supermarkets.model.events;

import xyz.rjs.brandwatch.supermarkets.sim.DeliverablePlace;

public class ArrivalNotification {
    private DeliverablePlace place;
    private int amount;

    public ArrivalNotification(DeliverablePlace place, int amount) {
        this.place = place;
        this.amount = amount;
    }

    public DeliverablePlace getPlace() {
        return place;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ArrivalNotification{" +
                "place=" + place +
                ", amount=" + amount +
                '}';
    }
}
