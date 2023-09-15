package pl.generali.Spring.laptop;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import pl.generali.Spring.monitor.Monitor;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "LAPTOPS")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "\\w{2,}", message = "make doen't meet the expected pattern")
    private String make;
    @NotBlank(message = "model mustn't be blank")
    private String model;
    @Column(name = "PRICE")
    @Positive(message = "price mustn't be empty")
    private BigDecimal priceInPln; //PRICE_IN_PLN
    @OneToOne(fetch = FetchType.EAGER)
    private Monitor monitor;

    public Laptop(String make, String model, BigDecimal priceInPln, Monitor monitor) {
        this.make = make;
        this.model = model;
        this.priceInPln = priceInPln;
        this.monitor = monitor;
    }
}
