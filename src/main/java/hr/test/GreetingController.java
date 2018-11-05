package hr.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(String username, double latitude, double longitude, String ipAddress, int port) {
        logger.info("Register method called!");
        return false;
    }

    @RequestMapping(value = "/search-neighbor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserAddress searchNeighbor(@RequestParam(name = "username") String username) {
        logger.info("Search neighbor method called!");
        return new UserAddress();
    }

    @RequestMapping(value = "/store-measurement", method = RequestMethod.POST)
    public boolean storeMeasurement(String username, String parameter, float averageValue) {
        logger.info("Store measurement method called!");
        return true;
    }

}