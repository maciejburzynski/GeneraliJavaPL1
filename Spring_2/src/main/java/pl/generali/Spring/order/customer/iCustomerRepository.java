package pl.generali.Spring.order.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iCustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);
}
