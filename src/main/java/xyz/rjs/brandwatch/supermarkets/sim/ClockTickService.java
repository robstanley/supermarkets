package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.AbstractScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;

import java.util.concurrent.TimeUnit;

public class ClockTickService extends AbstractScheduledService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private int ticksPerSecond;
    private EventBus eventBus;

    private volatile int ticks = 0;

    public ClockTickService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setTicksPerSecond(int ticksPerSecond) {
        this.ticksPerSecond = ticksPerSecond;
    }

    @Override
    protected void runOneIteration() throws Exception {
        eventBus.post(new ClockTick(ticks++));
    }

    @Override
    protected Scheduler scheduler() {
        int millis = 1000/ticksPerSecond;
        return AbstractScheduledService.Scheduler.newFixedRateSchedule(millis, millis, TimeUnit.MILLISECONDS);
    }
}
