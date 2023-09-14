package pl.generali.Spring.laptop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
@Slf4j
public class LaptopRestController {

    private final LaptopService laptopService;

    @GetMapping(path = "/laptops")
    ResponseEntity<List<Laptop>> getAllLaptops() {
        if (isFindAllNotEmpty()) {
            log.info("Returning all laptops");
            return ResponseEntity
                    .ok()
                    .body(laptopService.findAll());
        } else {
            log.info("There is no laptops to return");
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(List.of());
        }
    }

    @GetMapping(path = "/laptops/{id}")
    ResponseEntity<?> getLaptopById(@PathVariable Long id) {
        return ResponseEntity.ok(laptopService.findLaptopById(id));
    }

    @PostMapping(path = "/laptops")
    ResponseEntity addLaptop(@RequestBody Laptop laptop) {
        log.info("Adding new laptop: Make: {},  Model: {}, price: {}",
                laptop.getMake(),
                laptop.getModel(),
                laptop.getPriceInPln());
        laptopService.save(laptop);
        return ResponseEntity
                .status(NO_CONTENT)
                .build();
    }

    @DeleteMapping(path = "/laptops/{id}")
    ResponseEntity deleteLaptopById(@PathVariable Long id) {
        log.info("Deleting laptop with id of {}", id);
        laptopService.deleteById(id);
        return ResponseEntity
                .status(204)
                .build();
    }


    private boolean isFindAllNotEmpty() {
        return !laptopService.findAll().isEmpty();
    }
}







/*

ILaptopRepository -> LaptopRepository -> LaptopService -> LaptopRestController

 */