package pl.generali.Spring.order.product.laptop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface ILaptopRepository extends JpaRepository<Laptop, Long> {


//    @Query(value = "UPDATE Laptop SET make= :make, model= :model, priceInPln= :priceInPln WHERE id= :id", nativeQuery = false)
    @Query(value = "UPDATE LAPTOPS SET make= :make, model= :model, price= :priceInPln WHERE id= :id", nativeQuery = true)
    @Modifying
    @Transactional
    void updateLaptopById(@Param("id") Long id,
                          @Param("make") String make,
                          @Param("model") String model,
                          @Param("priceInPln") BigDecimal priceInPln);

    List<Laptop> findLaptopsByMakeEqualsIgnoreCase(String make);
    List<Laptop> findLaptopsByModelContainingIgnoreCase(String model);
    List<Laptop> findLaptopsByMakeEqualsIgnoreCaseAndModelContainingIgnoreCase(String make, String model);

}
