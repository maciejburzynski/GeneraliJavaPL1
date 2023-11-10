package pl.generali.Spring.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.generali.Spring.order.customer.Customer;
import pl.generali.Spring.order.customer.CustomerRepository;
import pl.generali.Spring.order.customer.CustomerService;
import pl.generali.Spring.order.product.laptop.Laptop;
import pl.generali.Spring.order.product.laptop.LaptopRepository;
import pl.generali.Spring.order.product.laptop.LaptopService;
import pl.generali.Spring.order.product.monitor.Monitor;
import pl.generali.Spring.order.product.monitor.MonitorRepository;
import pl.generali.Spring.order.product.monitor.MonitorService;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final LaptopService laptopService;
    private final MonitorService monitorService;
    private final CustomerService customerService;


    public void verifyAndSave(OrderDto orderDto){

        Order order = new Order(
                Arrays.asList(verifiedLaptop(orderDto)),
                Arrays.asList(verifiedMonitor(orderDto)),
                verifiedCustomer(orderDto));



        orderRepository.save(order);
    }

    List<Order> findAll(){
        return orderRepository.findAll();
    }

    private Laptop verifiedLaptop(OrderDto orderDto) {
        Laptop laptop = laptopService.findLaptopById(orderDto.getLaptopId());
        return laptop;
    }

    private Monitor verifiedMonitor(OrderDto orderDto) {
        Monitor monitor = monitorService.findById(orderDto.getMonitorId());
        return monitor;
    }

    private Customer verifiedCustomer(OrderDto orderDto) {
        Customer customer = customerService.findById(orderDto.getCustomerId());
        return customer;
    }
}
