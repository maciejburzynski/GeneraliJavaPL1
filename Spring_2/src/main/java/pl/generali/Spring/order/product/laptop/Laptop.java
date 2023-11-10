package pl.generali.Spring.order.product.laptop;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import pl.generali.Spring.order.product.monitor.Monitor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "LAPTOPS")
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laptops_generator")
    @SequenceGenerator(name = "laptops_generator", sequenceName = "laptops_seq", allocationSize = 1)
    private Long id;
    private String make;
    private String model;
    private BigDecimal price;

    public Laptop(String make, String model, BigDecimal price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }
}
