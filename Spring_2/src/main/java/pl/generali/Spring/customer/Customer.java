package pl.generali.Spring.customer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMERS")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_generator")
    @SequenceGenerator(name = "customers_generator", sequenceName = "customers_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;

}
