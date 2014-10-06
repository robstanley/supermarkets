package xyz.rjs.brandwatch.supermarkets.logistics.plugins.printers;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xyz.rjs.brandwatch.supermarkets.logistics.plugins.AbstractPlugin;

@Component
public class EventsPrinter extends AbstractPlugin {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Subscribe
    public void printEvent(Object o) {
        logger.info("{}", o);
    }
}
