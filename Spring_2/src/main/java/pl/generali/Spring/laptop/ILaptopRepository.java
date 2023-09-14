package pl.generali.Spring.laptop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

public interface ILaptopRepository extends JpaRepository<Laptop, Long> {


//    @Query(value = "UPDATE Laptop SET make= :make, model= :model, priceInPln= :priceInPln WHERE id= :id", nativeQuery = false)
    @Query(value = "UPDATE LAPTOPS SET make= :make, model= :model, price= :priceInPln WHERE id= :id", nativeQuery = true)
    @Modifying
    @Transactional
    void updateLaptopById(@Param("id") Long id,
                          @Param("make") String make,
                          @Param("model") String model,
                          @Param("priceInPln") BigDecimal priceInPln);

}

//@Query(value = "UPDATE LAPTOPS SET make= null, model= null, price= :priceInPln WHERE id= :id", nativeQuery = true)

