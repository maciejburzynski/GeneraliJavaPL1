package pl.generali.Spring.order.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with this id does not exist"));
    }

}
