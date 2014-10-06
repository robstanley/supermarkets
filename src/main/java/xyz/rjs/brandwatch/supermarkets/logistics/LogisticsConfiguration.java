package xyz.rjs.brandwatch.supermarkets.logistics;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("xyz.rjs.brandwatch.supermarkets.logistics")
public class LogisticsConfiguration {
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
