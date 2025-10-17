package com.riadh.ecommerce.kafka.order;

import com.riadh.ecommerce.kafka.order.Customer;
import com.riadh.ecommerce.kafka.order.Product;
import com.riadh.ecommerce.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products

) {
}
