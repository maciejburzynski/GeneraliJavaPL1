package pl.generali.Spring.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final IOrderRepository iOrderRepository;


    void save(Order order) {
        iOrderRepository.save(order);
    }

    public List<Order> findAll() {
        return iOrderRepository.findAll();
    }
}
