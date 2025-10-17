package com.riadh.ecommerce.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/order-lines")
@RestController
@RequiredArgsConstructor


public class OrderLineController {
    private final OrderLineService service;
    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findByOrsderId(
            @PathVariable("order-id") Integer orderId
    ){
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }

}
