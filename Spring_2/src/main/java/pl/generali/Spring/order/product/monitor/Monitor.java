package pl.generali.Spring.order.product.monitor;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "MONITORS")
@NoArgsConstructor
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monitors_generator")
    @SequenceGenerator(name = "monitors_generator", sequenceName = "monitors_seq", allocationSize = 1)
    private Long id;
    private String make;
    private String model;
    private BigDecimal price;

    public Monitor(String make, String model, BigDecimal price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }
}
