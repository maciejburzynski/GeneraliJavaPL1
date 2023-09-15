package pl.generali.Spring.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LaptopRepository {

    private final ILaptopRepository iLaptopRepository;

    public void save(Laptop laptop) {
        iLaptopRepository.save(laptop);
    }

    public List<Laptop> findAll() {
        return iLaptopRepository.findAll();
    }

    public void deleteById(Long id) {
        iLaptopRepository.deleteById(id);
    }

    public Optional<Laptop> findLaptopById(Long id) {
        return iLaptopRepository.findById(id);
    }

    public void updateLaptopById(Long id, Laptop laptop) {
        iLaptopRepository.updateLaptopById(id,
                laptop.getMake(),
                laptop.getModel(),
                laptop.priceInPln);
    }

    public List<Laptop> findLaptopsByMake(String make) {
        return iLaptopRepository.findLaptopsByMakeEqualsIgnoreCase(make);
    }

    public List<Laptop> findLaptopsByModel(String model) {
        return iLaptopRepository.findLaptopsByModelContainingIgnoreCase(model);
    }

    public List<Laptop> findLaptopsByMakeAndModel(String make, String model) {
        return iLaptopRepository.findLaptopsByMakeEqualsIgnoreCaseAndModelContainingIgnoreCase(make, model);
    }
}
