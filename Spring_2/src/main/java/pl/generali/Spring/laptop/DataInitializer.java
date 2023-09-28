package pl.generali.Spring.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.generali.Spring.monitor.Monitor;
import pl.generali.Spring.monitor.MonitorService;
import pl.generali.Spring.order.Order;
import pl.generali.Spring.order.OrderService;
import pl.generali.Spring.security.User;
import pl.generali.Spring.security.UserRole;
import pl.generali.Spring.security.UserService;

import java.math.BigDecimal;
import java.util.List;

import static pl.generali.Spring.laptop.Make.*;
import static pl.generali.Spring.security.UserRole.*;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final LaptopService laptopService;
    private final MonitorService monitorService;
    private final OrderService orderService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @EventListener(ApplicationReadyEvent.class)
    public void populateDataToDb() {
        Monitor monitor = new Monitor("Lenovo", "T-34", BigDecimal.valueOf(2400));
        Monitor monitor1 = new Monitor("Iiyama", "T-34", BigDecimal.valueOf(1400));
        Monitor monitor2 = new Monitor("Xiaomi", "T-34", BigDecimal.valueOf(2000));
        Monitor monitor3 = new Monitor("BenQ", "T-34", BigDecimal.valueOf(1000));
        Monitor monitor4 = new Monitor("Eizo", "T-34", BigDecimal.valueOf(600));
        Monitor monitor5 = new Monitor("Lenovo", "T-34", BigDecimal.valueOf(555));

        monitorService.save(monitor);
        monitorService.save(monitor1);
        monitorService.save(monitor2);
        monitorService.save(monitor3);
        monitorService.save(monitor4);
        monitorService.save(monitor5);

        Laptop laptop = new Laptop(LENOVO.getValue(), "ThinkPad L14", BigDecimal.valueOf(10000), monitor);
        Laptop laptop1 = new Laptop(LENOVO.getValue(), "ThinkPad T15", BigDecimal.valueOf(9000), monitor1);
        Laptop laptop2 = new Laptop(LENOVO.getValue(), "ThinkPad T480", BigDecimal.valueOf(8000), monitor2);
        Laptop laptop3 = new Laptop(LENOVO.getValue(), "ThinkPad T470", BigDecimal.valueOf(4000), monitor3);
        Laptop laptop8 = new Laptop(MACBOOK.getValue(), "Air", BigDecimal.valueOf(3000), monitor4);
        Laptop laptop9 = new Laptop(MACBOOK.getValue(), "PRO M2", BigDecimal.valueOf(12000), monitor5);

        laptopService.save(laptop);
        laptopService.save(laptop1);
        laptopService.save(laptop2);
        laptopService.save(laptop3);
        laptopService.save(laptop8);
        laptopService.save(laptop9);

        Order order = new Order(List.of(laptop, laptop2, laptop3));
        Order order1 = new Order(List.of(laptop1, laptop8, laptop9));

        orderService.save(order);
        orderService.save(order1);

        User user = new User("user", passwordEncoder.encode("user"), USER);
        User admin = new User("admin", passwordEncoder.encode("admin"), ADMIN);

        userService.save(user);
        userService.save(admin);
    }
}
