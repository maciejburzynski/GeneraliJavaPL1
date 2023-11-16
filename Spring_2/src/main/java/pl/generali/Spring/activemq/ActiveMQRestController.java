package pl.generali.Spring.activemq;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ActiveMQRestController {

    private final JmsTemplate jmsTemplate;


    @GetMapping("/api/messages")
    String testQueue(@RequestParam String message) {

        jmsTemplate.convertAndSend("test", message);
        return message;
    }


}

