package pl.generali.Spring.order.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@Data
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "\\w{2,}", message = "make doen't meet the expected pattern")
    private String make;
    @NotBlank(message = "model mustn't be blank")
    private String model;
    @Positive(message = "price mustn't be empty")
    private BigDecimal price;
}
