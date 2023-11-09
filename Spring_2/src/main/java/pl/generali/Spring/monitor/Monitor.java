package pl.generali.Spring.monitor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@Data
@Table(name = "MONITORS")
public class Monitor {

    @Id
    @GeneratedValue(strategy = AUTO)
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
