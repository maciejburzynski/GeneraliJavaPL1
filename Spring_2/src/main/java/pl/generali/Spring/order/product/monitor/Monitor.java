package pl.generali.Spring.order.product.monitor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.generali.Spring.order.product.Product;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@Data
@Table(name = "MONITORS")
public class Monitor extends Product {

}
