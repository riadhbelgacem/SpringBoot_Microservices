package com.riadh.ecommerce.payment;

import com.riadh.ecommerce.customer.CustomerResponse;
import com.riadh.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer



) {
}
