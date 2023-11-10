package pl.generali.Spring.order.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final iCustomerRepository customerRepository;

    Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }
}
