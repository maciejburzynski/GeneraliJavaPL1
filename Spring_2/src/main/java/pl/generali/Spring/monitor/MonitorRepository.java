package pl.generali.Spring.monitor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
