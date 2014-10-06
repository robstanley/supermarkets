package xyz.rjs.brandwatch.supermarkets.sim;

import com.google.common.util.concurrent.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class Main {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void runSimulation() {
        logger.info("Runnin");
    }

    public static void main(String[] args) throws TimeoutException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SimConfiguration.class);
        context.registerShutdownHook();
        context.refresh();

        Main main = context.getBean(Main.class);
        main.runSimulation();
        ServiceManager simulationServiceManager = context.getBean(ServiceManager.class);
        simulationServiceManager.startAsync();
    }
}
