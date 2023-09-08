package pl.generali.Spring.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api")
public class LaptopRestController {

    private final LaptopService laptopService;


    @GetMapping(path = "/laptops") // api/laptops
    List<Laptop> getAllLaptops(){
      return laptopService.findAll();
    }
}







/*

ILaptopRepository -> LaptopRepository -> LaptopService -> LaptopRestController

 */