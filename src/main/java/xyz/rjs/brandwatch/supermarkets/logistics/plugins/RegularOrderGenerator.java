package xyz.rjs.brandwatch.supermarkets.logistics.plugins;

import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;
import xyz.rjs.brandwatch.supermarkets.model.events.Order;
import xyz.rjs.brandwatch.supermarkets.model.events.PriceList;
import xyz.rjs.brandwatch.supermarkets.sim.Warehouse;

@Component
public class RegularOrderGenerator extends AbstractPlugin {
    @Autowired
    private Warehouse warehouse;

    private boolean priceSeen = false;

    @Subscribe
    public void tickListener(ClockTick tick) {
        if (!priceSeen) {
            return;
        }
        Order order = new Order();
        order.setWarehouse(warehouse);
        order.setVolume(1);
        eventBus.post(order);
    }

    @Subscribe
    public void priceListener(PriceList priceList) {
        priceSeen = true;
    }
}
