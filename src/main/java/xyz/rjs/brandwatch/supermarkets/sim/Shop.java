package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.AbstractIdleService;
import xyz.rjs.brandwatch.supermarkets.model.events.Customer;
import xyz.rjs.brandwatch.supermarkets.model.events.Sale;

import static com.google.common.collect.Lists.newArrayList;

public class Shop extends AbstractIdleService {

    private EventBus eventBus;

    public Shop(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    private int stock = 20;

    @Subscribe
    public void handleCustomer(Customer customer) {
        int stockRequested = customer.getStuffNeeded();
        int amountSold = 0;
        if (stock >= stockRequested) {
            stock -= stockRequested;
            customer.setStuffReceived(stockRequested);
            amountSold += stockRequested;
        }
        Sale sale = new Sale();
        sale.setAmountSold(amountSold);
        sale.setRemainingStock(stock);
        eventBus.post(sale);
    }

    @Override
    protected void startUp() throws Exception {
        eventBus.register(this);
    }

    @Override
    protected void shutDown() throws Exception {
        eventBus.unregister(this);
    }
}
