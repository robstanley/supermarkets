package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import xyz.rjs.brandwatch.supermarkets.model.events.*;

import java.util.Random;

public class Supermarket extends AbstractTickingService {

    private Random random = new Random();
    private int balance = 100 + (random.nextInt(30) - 15);
    private int salePrice = 10;
    private int currentBuyPrice;

    public Supermarket(EventBus eventBus) {
        super(eventBus);
    }

    @Override
    public void tick(ClockTick tick) {
        try {
            if (tick.getTick() % 20 == 0) {
                eventBus.post(new Balance(balance));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void processSale(Sale sale) {
        balance += (sale.getAmountSold() * salePrice);
    }

    @Subscribe
    public void processOrder(Order order) {
        try {
            balance -= (order.getVolume() * currentBuyPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void updatePrice(PriceList prices) {
        currentBuyPrice = prices.getCurrentPrice();
    }
}
