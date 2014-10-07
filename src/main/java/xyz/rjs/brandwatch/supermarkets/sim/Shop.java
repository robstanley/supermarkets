package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import xyz.rjs.brandwatch.supermarkets.model.events.Customer;
import xyz.rjs.brandwatch.supermarkets.model.events.Sale;

public class Shop extends DeliverablePlace {

    public Shop(EventBus eventBus) {
        super(eventBus);
    }

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

}
