package pl.generali.Spring.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    public void deleteById(Long id) {
        laptopRepository.deleteById(id);
    }

    public Laptop findLaptopById(Long id) {
        return laptopRepository
                .findLaptopById(id)
                .orElseThrow(() -> new LaptopNotFoundException("Laptop with id: " + id + " not found"));
    }

    public void updateLaptopById(Long id, Laptop laptop) {
        laptopRepository.updateLaptopById(id, laptop);
    }

    public List<Laptop> findLaptopsByMake(String make) {
        return laptopRepository.findLaptopsByMake(make);
    }

    public List<Laptop> findLaptopsByModel(String model) {
        return laptopRepository.findLaptopsByModel(model);
    }

    public List<Laptop> findLaptopsByMakeAndModel(String make, String model) {
        return laptopRepository.findLaptopsByMakeAndModel(make, model);
    }
}
