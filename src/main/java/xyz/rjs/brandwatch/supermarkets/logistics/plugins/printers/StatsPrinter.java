package xyz.rjs.brandwatch.supermarkets.logistics.plugins.printers;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xyz.rjs.brandwatch.supermarkets.logistics.plugins.AbstractPlugin;
import xyz.rjs.brandwatch.supermarkets.model.events.ClockTick;

@Component
public class StatsPrinter extends AbstractPlugin {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private volatile int totalEventCount = 0;

    @Subscribe
    public void eventListener(Object o) {
        totalEventCount++;
    }

    @Subscribe
    public void tickListener(ClockTick tick) {
        if (tick.getTick() % 10 == 0) {
            printStats();
        }
    }

    private void printStats() {
        logger.info("Total Events: {}", totalEventCount);
    }
}
