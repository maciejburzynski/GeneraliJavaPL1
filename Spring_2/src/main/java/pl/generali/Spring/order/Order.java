package pl.generali.Spring.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.generali.Spring.customer.Customer;
import pl.generali.Spring.order.product.Product;
import pl.generali.Spring.order.product.laptop.Laptop;

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
    private List<Product> products;

    @OneToOne(fetch = FetchType.EAGER)
    private Customer customer;

    private Long price;

    public Order(List<Product> products, Customer customer) {
        this.products = products;
        this.customer = customer;
    }
}