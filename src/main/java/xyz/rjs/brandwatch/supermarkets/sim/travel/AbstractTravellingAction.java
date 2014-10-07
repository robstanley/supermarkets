package xyz.rjs.brandwatch.supermarkets.sim.travel;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;

import java.util.Random;

public abstract class AbstractTravellingAction {
    private EventBus eventBus;
    private int distance;
    private Random random = new Random();
    private double delayProbability = 0.1;

    public AbstractTravellingAction(EventBus eventBus, int distance) {
        this.eventBus = eventBus;
        this.distance = distance;
        eventBus.register(this);
    }

    @Subscribe
    public void tick(ClockTick tick) {
        if (random.nextDouble() < delayProbability) {
            return;
        }
        if (distance-- <= 0) {
            eventBus.unregister(this);
            arrivalAction();
        }
    }

    protected abstract void arrivalAction();

}
