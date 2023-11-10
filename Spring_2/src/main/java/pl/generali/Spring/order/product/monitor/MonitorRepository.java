package pl.generali.Spring.order.product.monitor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MonitorRepository {

    private final iMonitorRepository iMonitorRepository;

    public List<Monitor> findAllMonitors() {
        return iMonitorRepository.findAll();
    }

    public void save(Monitor monitor) {
        iMonitorRepository.save(monitor);
    }

    public Optional<Monitor> findById(Long monitorId) {
        return iMonitorRepository.findById(monitorId);
    }
}
