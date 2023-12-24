package br.com.marlonhildon.propertiesinjection.controllers;

import br.com.marlonhildon.propertiesinjection.dtos.OrderStatusDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class OrderStatusControllerTest {

    @Autowired
    private Map<String, OrderStatusDTO> orderStatusDTOMap;

    private static final String SUCCESS_KEY = "SUCCESS";
    private static final String INTEGRATION_ERROR_KEY = "INTEGRATION_ERROR";
    private static final String CANCELLED_KEY = "CANCELLED";

    @Test
    void getAllOrderStatusTestSuccessExpectedValuesOk() {
        Assertions.assertNotNull(orderStatusDTOMap);

        Assertions.assertTrue(orderStatusDTOMap.containsKey(SUCCESS_KEY));
        Assertions.assertTrue(orderStatusDTOMap.containsKey(INTEGRATION_ERROR_KEY));
        Assertions.assertTrue(orderStatusDTOMap.containsKey(CANCELLED_KEY));

        final OrderStatusDTO successOrderStatus = orderStatusDTOMap.get(SUCCESS_KEY);
        final OrderStatusDTO integrationFailedOrderStatus = orderStatusDTOMap.get(INTEGRATION_ERROR_KEY);
        final OrderStatusDTO cancelledOrderStatus = orderStatusDTOMap.get(CANCELLED_KEY);

        Assertions.assertEquals("OK", successOrderStatus.getCode());
        Assertions.assertEquals("The order was processed successfully!", successOrderStatus.getMessage());

        Assertions.assertEquals("NOK", integrationFailedOrderStatus.getCode());
        Assertions.assertEquals("Integration failed, please retry.", integrationFailedOrderStatus.getMessage());

        Assertions.assertEquals("CANCEL", cancelledOrderStatus.getCode());
        Assertions.assertEquals("The order was cancelled. The payment will be returned.", cancelledOrderStatus.getMessage());
    }
}