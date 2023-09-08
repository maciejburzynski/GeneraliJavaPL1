package pl.generali.Spring.laptop;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class LaptopInitializer {

    private final LaptopService laptopService;


    @PostConstruct
    private void populateLaptopsToDb(){
        Laptop laptop = new Laptop("Lenovo", "ThinkPad L14", BigDecimal.valueOf(10000));
        Laptop laptop1 = new Laptop("Lenovo", "ThinkPad T15", BigDecimal.valueOf(9000));
        Laptop laptop2 = new Laptop("Lenovo", "ThinkPad T480", BigDecimal.valueOf(8000));
        Laptop laptop3 = new Laptop("Lenovo", "ThinkPad T470", BigDecimal.valueOf(4000));
        Laptop laptop4 = new Laptop("Lenovo", "ThinkPad X200", BigDecimal.valueOf(2000));
        Laptop laptop5 = new Laptop("Lenovo", "ThinkPad A-210", BigDecimal.valueOf(1500));
        Laptop laptop6 = new Laptop("Lenovo", "ThinkPad T460", BigDecimal.valueOf(7000));
        Laptop laptop7 = new Laptop("Lenovo", "ThinkPad T450", BigDecimal.valueOf(5000));
        Laptop laptop8 = new Laptop("MacBook", "Air", BigDecimal.valueOf(3000));
        Laptop laptop9 = new Laptop("MacBook", "PRO M2", BigDecimal.valueOf(12000));

        laptopService.save(laptop);
        laptopService.save(laptop1);
        laptopService.save(laptop2);
        laptopService.save(laptop3);
        laptopService.save(laptop4);
        laptopService.save(laptop5);
        laptopService.save(laptop6);
        laptopService.save(laptop7);
        laptopService.save(laptop8);
        laptopService.save(laptop9);
    }


}
