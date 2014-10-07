package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;
import xyz.rjs.brandwatch.supermarkets.model.events.Order;
import xyz.rjs.brandwatch.supermarkets.model.events.PriceList;
import xyz.rjs.brandwatch.supermarkets.sim.travel.Delivery;

import java.util.Random;

public class Supplier extends AbstractProbabalisticTickingService {

    private int price = 1;
    private Random random = new Random();
    private int distanceFromWarehouse = 20 + (random.nextInt(10) - 5);

    public Supplier(EventBus eventBus) {
        super(eventBus, 0.07);
        probableTick(new ClockTick(0));
    }

    @Override
    public void probableTick(ClockTick tick) {
        int change = 1 - random.nextInt(3);
        if (price + change >= 1) {
            price = price + change;
        }
        eventBus.post(new PriceList(price));
    }

    @Subscribe
    public void receiveOrder(Order order) {
        new Delivery(eventBus, distanceFromWarehouse, order.getWarehouse(), order.getVolume());
    }

}
