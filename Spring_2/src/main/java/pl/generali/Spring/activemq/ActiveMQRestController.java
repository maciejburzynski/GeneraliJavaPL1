package pl.generali.Spring.activemq;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import pl.generali.Spring.order.OrderDto;

@RestController
@RequiredArgsConstructor
public class ActiveMQRestController {

    private final JmsTemplate jmsTemplate;


    @GetMapping("/api/messages")
    String testString(@RequestParam String message) {
        jmsTemplate.convertAndSend("test", message);
        return message;
    }

    @GetMapping("/api/object")
    String testObject() {
        OrderDto orderDto = new OrderDto(1L, 2L, 3L);
        jmsTemplate.convertAndSend("test", orderDto);
        return "OBJECT!";
    }


}

