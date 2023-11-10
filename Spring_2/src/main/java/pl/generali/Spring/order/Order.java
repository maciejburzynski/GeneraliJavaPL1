package pl.generali.Spring.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.generali.Spring.order.customer.Customer;
import pl.generali.Spring.order.product.laptop.Laptop;
import pl.generali.Spring.order.product.monitor.Monitor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_generator")
    @SequenceGenerator(name = "orders_generator", sequenceName = "orders_seq", allocationSize = 1)
    private Long id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Laptop> laptops;
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Monitor> monitors;

    @OneToOne(fetch = FetchType.EAGER)
    private Customer customer;

    private Long price;

    public Order(List<Laptop> laptops, List<Monitor> monitors, Customer customer, Long price) {
        this.laptops = laptops;
        this.monitors = monitors;
        this.customer = customer;
        this.price = price;
    }

    public Order(List<Laptop> laptops, List<Monitor> monitors, Customer customer) {
        this.laptops = laptops;
        this.monitors = monitors;
        this.customer = customer;
    }
}