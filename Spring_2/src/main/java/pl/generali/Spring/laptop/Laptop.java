package pl.generali.Spring.laptop;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
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
    @Pattern(regexp = "\\w{2,}", message = "make doen't meet the expected pattern")
    String make;
    @NotBlank(message = "model mustn't be blank")
    String model;
    @Column(name = "PRICE")
    @Positive(message = "price mustn't be empty")
    BigDecimal priceInPln; //PRICE_IN_PLN

    public Laptop(String make, String model, BigDecimal priceInPln) {
        this.make = make;
        this.model = model;
        this.priceInPln = priceInPln;
    }
}
