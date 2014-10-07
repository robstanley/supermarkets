package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import xyz.rjs.brandwatch.supermarkets.model.Supplier;
import xyz.rjs.brandwatch.supermarkets.model.Warehouse;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;
import xyz.rjs.brandwatch.supermarkets.model.events.Order;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class RegularOrderService extends AbstractTickingService {

    private Warehouse warehouse;

    public RegularOrderService(EventBus eventBus, Warehouse warehouse) {
        super(eventBus);
        this.warehouse = warehouse;
    }

    public void tick(ClockTick tick) {
        if (tick.getTick() % 7 == 0) {
            Order order = new Order();
            order.setVolume(3);
            order.setWarehouse(warehouse);
            eventBus.post(order);
        }

    }

}
