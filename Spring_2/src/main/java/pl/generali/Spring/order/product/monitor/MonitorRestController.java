package pl.generali.Spring.order.product.monitor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/monitors")
public class MonitorRestController {

    private final MonitorService monitorService;

    @GetMapping()
    ResponseEntity<?> findAllMonitors() {
        return ResponseEntity.ok(monitorService.findAllMonitors());
    }
}
