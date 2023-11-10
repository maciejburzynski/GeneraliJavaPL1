package pl.generali.Spring.order.product.monitor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public List<Monitor> findAllMonitors() {
        return monitorRepository.findAllMonitors();
    }

    public void save(Monitor monitor) {
        monitorRepository.save(monitor);
    }

    public Monitor findById(Long monitorId) {
        return  monitorRepository.findById(monitorId)
                .orElseThrow(() -> new MonitorNotFoundException("Monitor with id " + monitorId + " does not exist"));
    }
}
