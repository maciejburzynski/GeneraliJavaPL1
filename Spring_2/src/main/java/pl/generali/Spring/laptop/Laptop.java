package pl.generali.Spring.laptop;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "LAPTOPS")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String make;
    String model;
    @Column(name = "PRICE")
    BigDecimal priceInPln;

    public Laptop(String make, String model, BigDecimal priceInPln) {
        this.make = make;
        this.model = model;
        this.priceInPln = priceInPln;
    }
}
