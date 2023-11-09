package pl.generali.Spring.laptop;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
@Slf4j
public class LaptopRestController {

    private final LaptopService laptopService;

    @GetMapping(path = "/laptops")
    ResponseEntity<?> getAllLaptops(@RequestParam(required = false) Optional<String> make,
                                               @RequestParam(required = false) Optional<String> model) {
        if (make.isPresent() && model.isPresent()) {
            log.info("Returning laptops with make of: {}, model of: {}", make, model);
            return ResponseEntity
                    .ok()
                    .body(laptopService.findLaptopsByMakeAndModel(make.get(), model.get()));
        } else if (make.isPresent()) {
            log.info("Returning laptops with make of: {}", make);
            return ResponseEntity
                    .ok()
                    .body(laptopService.findLaptopsByMake(make.get()));
        } else if (model.isPresent()) {
            log.info("Returning laptops with model of: {}", model);
            return ResponseEntity
                    .ok()
                    .body(laptopService.findLaptopsByModel(model.get()));
        }
            Pageable pageable = PageRequest.of(2, 2);
        if (isFindAllNotEmpty(pageable)) {
            log.info("Returning all laptops");
            return ResponseEntity
                    .ok()
                    .body(laptopService.findAll(pageable));
        } else {
            log.info("There is no laptops to return");
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(List.of());
        }

    }

    @GetMapping(path = "/laptops/{id}")
    ResponseEntity<?> getLaptopById(@PathVariable Long id) {
        log.info("Returning laptop with id: {}", id);
        return ResponseEntity.ok(laptopService.findLaptopById(id));
        //try/catch ---> specific case -> Less specific -> Throwable
    }


    @PostMapping(path = "/laptops")
    ResponseEntity addLaptop(@RequestBody @Valid Laptop laptop) {
        log.info("Adding new laptop: Make: {},  Model: {}, price: {}",
                laptop.getMake(),
                laptop.getModel(),
                laptop.getPriceInPln());
        laptopService.save(laptop);
        return ResponseEntity
                .status(NO_CONTENT)
                .build();
    }

    @PutMapping(path = "/laptops/{id}")
    ResponseEntity updateLaptop(@PathVariable Long id, @RequestBody @Valid Laptop laptop) {
        log.info("Updating Laptop with id: {}, updated laptop: Make: {},  Model: {}, price: {}",
                id, laptop.getMake(), laptop.getModel(), laptop.getPriceInPln());
        laptopService.updateLaptopById(id, laptop);
        return ResponseEntity
                .ok()
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


    private boolean isFindAllNotEmpty(Pageable pageable) {
        return !laptopService.findAll(pageable).isEmpty();
    }
}







/*

ILaptopRepository -> LaptopRepository -> LaptopService -> LaptopRestController

 */