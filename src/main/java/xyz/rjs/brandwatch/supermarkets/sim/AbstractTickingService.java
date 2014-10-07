package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.AbstractIdleService;
import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;
import xyz.rjs.brandwatch.supermarkets.model.events.Customer;

import java.util.Locale;

public abstract class AbstractTickingService extends AbstractIdleService {

    protected EventBus eventBus;

    public AbstractTickingService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Subscribe
    public abstract void tick(ClockTick tick);


    @Override
    protected void startUp() throws Exception {
        eventBus.register(this);
    }

    @Override
    protected void shutDown() throws Exception {
        eventBus.unregister(this);
    }
}
