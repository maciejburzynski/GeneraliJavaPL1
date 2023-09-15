package pl.generali.Spring.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.generali.Spring.laptop.Laptop;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Laptop> laptops;

    public Order(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
