package pl.generali.Spring.order.product.laptop;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import pl.generali.Spring.order.product.Product;
import pl.generali.Spring.order.product.monitor.Monitor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "LAPTOPS")
public class Laptop extends Product {


}
