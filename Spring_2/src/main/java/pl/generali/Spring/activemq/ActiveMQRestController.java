package pl.generali.Spring.activemq;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ActiveMQRestController {

    private final JmsTemplate jmsTemplate;


    @PostMapping("/api/message")
    String testQueue(@RequestBody String message) {

        jmsTemplate.convertAndSend("test", message);
        return message;
    }


}

