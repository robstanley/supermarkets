package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.rjs.brandwatch.supermarkets.logistics.LogisticsConfiguration;

@Configuration
@Import(LogisticsConfiguration.class)
public class SimConfiguration {
    @Bean
    public Main main() {
        return new Main();
    }

    private ClockTickService clockTickService(EventBus eventBus) {
        ClockTickService clockTickService = new ClockTickService(eventBus);
        clockTickService.setTicksPerSecond(1);
        return clockTickService;
    }

    @Bean
    @Autowired
    public ServiceManager simulationServiceManager(EventBus eventBus) {
        return new ServiceManager(ImmutableList.of(
                clockTickService(eventBus),
                new CustomerService(eventBus),
                new SupplierService(eventBus)));
    }
}
