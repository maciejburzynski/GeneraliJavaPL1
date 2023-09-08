package pl.generali.Spring.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
