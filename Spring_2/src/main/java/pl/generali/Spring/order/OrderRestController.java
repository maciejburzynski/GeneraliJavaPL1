package pl.generali.Spring.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/orders")
public class OrderRestController {

    private final OrderService orderService;


    @RequestMapping(method = GET)
    @ResponseStatus(HttpStatus.OK)
    List<Order> findAll() {
        return orderService.findAll();
    }

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.OK)
    void addOrder(@RequestBody OrderDto order) {
        orderService.verifyAndSave(order);
    }

}
