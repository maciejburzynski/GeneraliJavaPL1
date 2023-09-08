package pl.generali.Spring.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
