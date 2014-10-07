package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.AbstractIdleService;
import xyz.rjs.brandwatch.supermarkets.model.events.ArrivalNotification;

public abstract class DeliverablePlace extends AbstractIdleService {
    protected EventBus eventBus;
    protected int stock;

    public DeliverablePlace(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    protected void startUp() throws Exception {
        eventBus.register(this);
    }

    @Override
    protected void shutDown() throws Exception {
        eventBus.unregister(this);
    }

    public void addStock(int stock) {
        this.stock += stock;
        eventBus.post(new ArrivalNotification(this, stock));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "stock=" + stock +
                '}';
    }

    public int getStock() {
        return stock;
    }
}
