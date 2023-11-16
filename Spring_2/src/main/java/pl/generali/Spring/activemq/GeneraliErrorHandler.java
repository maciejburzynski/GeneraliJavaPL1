package pl.generali.Spring.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
@Slf4j
public class GeneraliErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
      log.info("Error message: {}", t.getMessage());
    }
}
