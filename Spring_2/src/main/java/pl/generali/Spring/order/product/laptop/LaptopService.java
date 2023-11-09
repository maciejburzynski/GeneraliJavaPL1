package pl.generali.Spring.order.product.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public Page<Laptop> findAll(Pageable pageable) {
        return laptopRepository.findAll(pageable);
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
