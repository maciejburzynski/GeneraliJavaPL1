package pl.generali.Spring.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order){
        orderRepository.save(order);
    }

    List<Order> findAll(){
        return orderRepository.findAll();
    }
}
