package pl.generali.Spring.order.product.monitor;

public class MonitorNotFoundException extends RuntimeException {
    public MonitorNotFoundException(String message) {
        super(message);
    }
}
