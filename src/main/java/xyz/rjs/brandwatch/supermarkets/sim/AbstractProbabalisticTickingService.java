package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;

import java.util.Random;

public abstract class AbstractProbabalisticTickingService extends AbstractTickingService {
    private double probability;
    private Random random = new Random();

    public AbstractProbabalisticTickingService(EventBus eventBus, double probability) {
        super(eventBus);
        this.probability = probability;
    }

    @Override
    public void tick(ClockTick tick) {
        if (random.nextDouble() < probability) {
            probableTick(tick);
        }
    }

    protected abstract void probableTick(ClockTick tick);
}
