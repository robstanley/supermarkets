package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.AbstractIdleService;
import xyz.rjs.brandwatch.supermarkets.model.events.Sale;

public class WarehouseManagementService extends AbstractIdleService {

    private EventBus eventBus;
    private Warehouse warehouse;
    private Shop shop;

    public WarehouseManagementService(EventBus eventBus, Warehouse warehouse, Shop shop) {
        this.eventBus = eventBus;
        this.warehouse = warehouse;
        this.shop = shop;
    }

    @Subscribe
    public void sendStock(Sale sale) {
        int warehouseStock = warehouse.getStock();
        if (sale.getRemainingStock() == 0 && warehouseStock > 0) {
            warehouse.setStock(0);
            shop.addStock(warehouseStock);
        }
    }

    @Override
    protected void startUp() throws Exception {
        eventBus.register(this);
    }

    @Override
    protected void shutDown() throws Exception {
        eventBus.unregister(this);
    }
}
