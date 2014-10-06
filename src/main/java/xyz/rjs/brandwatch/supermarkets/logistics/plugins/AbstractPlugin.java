package xyz.rjs.brandwatch.supermarkets.logistics.plugins;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class AbstractPlugin {
    @Autowired
    protected EventBus eventBus;

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @PostConstruct
    protected void register() {
        eventBus.register(this);
    }
}
