package br.com.marlonhildon.propertiesinjection.configs;

import br.com.marlonhildon.propertiesinjection.dtos.OrderStatusDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "order-status")
    public Map<String, OrderStatusDTO> getOrderStatusDTOMap() {
        return new HashMap<>();
    }

}
