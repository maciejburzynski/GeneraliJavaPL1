package pl.generali.Spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "generali.geolocation")
@Component
@Data
public class ElectronicShopConfig {

    private String apiKey;
}

