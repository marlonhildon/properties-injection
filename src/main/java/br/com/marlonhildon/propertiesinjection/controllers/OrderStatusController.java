package br.com.marlonhildon.propertiesinjection.controllers;

import br.com.marlonhildon.propertiesinjection.configs.PropertiesConfig;
import br.com.marlonhildon.propertiesinjection.dtos.OrderStatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class OrderStatusController {

    private final PropertiesConfig propertiesConfig;

    @GetMapping(path = "/order-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, OrderStatusDTO>> getAllOrderStatus() {
        return ResponseEntity.ok(propertiesConfig.getOrderStatusDTOMap());
    }

}
