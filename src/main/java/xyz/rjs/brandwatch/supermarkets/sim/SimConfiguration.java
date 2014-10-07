package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.rjs.brandwatch.supermarkets.logistics.LogisticsConfiguration;
import xyz.rjs.brandwatch.supermarkets.model.Supplier;
import xyz.rjs.brandwatch.supermarkets.model.Warehouse;

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
    public Supplier supplier() {
        Supplier supplier = new Supplier();
        supplier.setDistanceFromWarehouse(15);
        return supplier;
    }

    @Bean
    public Warehouse warehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setDistanceFromShop(17);
        warehouse.setStock(0);
        return warehouse;
    }

    @Bean
    @Autowired
    public ServiceManager simulationServiceManager(EventBus eventBus) {
        return new ServiceManager(ImmutableList.of(
                clockTickService(eventBus),
                new CustomerService(eventBus),
                new Shop(eventBus),
                new RegularOrderService(eventBus, warehouse()),
                new SupplierService(eventBus, supplier())));
    }
}
