package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.AbstractIdleService;
import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import org.jfairy.producer.person.PersonProperties;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;
import xyz.rjs.brandwatch.supermarkets.model.events.Customer;

import java.util.Locale;

public class CustomerService extends AbstractTickingService {

    private Fairy fairy = Fairy.create();

    public CustomerService(EventBus eventBus) {
        super(eventBus);
    }

    public void tick(ClockTick tick) {
        if (tick.getTick() % 15 == 0) {
            Customer customer = new Customer();
            Person person = fairy.person();
            customer.setName(person.firstName() + " " + person.lastName());
            customer.setStuffNeeded(1);
            eventBus.post(customer);
        }
    }
}
