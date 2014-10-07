package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import xyz.rjs.brandwatch.supermarkets.model.Supplier;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;
import xyz.rjs.brandwatch.supermarkets.model.events.Customer;
import xyz.rjs.brandwatch.supermarkets.model.events.Order;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SupplierService extends AbstractTickingService {

    private Supplier supplier;
    private List<MovingOrder> orders = newArrayList();

    public SupplierService(EventBus eventBus, Supplier supplier) {
        super(eventBus);
        this.supplier = supplier;
    }

    public void tick(ClockTick tick) {

    }

    @Subscribe
    public void receiveOrder(Order order) {
        orders.add(new MovingOrder(order, supplier.getDistanceFromWarehouse()));
    }

    private class MovingOrder {
        private Order order;
        private int distanceLeft;

        private MovingOrder(Order order, int distanceLeft) {
            this.order = order;
            this.distanceLeft = distanceLeft;
        }

        public int travel() {
            return distanceLeft--;
        }

        public Order getOrder() {
            return order;
        }
    }

}
