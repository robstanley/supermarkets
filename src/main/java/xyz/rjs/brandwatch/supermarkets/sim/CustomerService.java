package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;
import xyz.rjs.brandwatch.supermarkets.model.events.Customer;

import java.util.Random;

public class CustomerService extends AbstractProbabalisticTickingService {

    private Fairy fairy = Fairy.create();
    private Random random = new Random();
    private int minNeeded = 1;
    private int maxNeeded = 7;

    public CustomerService(EventBus eventBus) {
        super(eventBus, 0.1);
    }

    public void probableTick(ClockTick tick) {
        Customer customer = new Customer();
        Person person = fairy.person();
        customer.setName(person.firstName() + " " + person.lastName());
        customer.setStuffNeeded(random.nextInt(maxNeeded - minNeeded) + minNeeded);
        eventBus.post(customer);
    }
}
