package com.riadh.ecommerce.kafka;

import com.riadh.ecommerce.customer.CustomerResponse;
import com.riadh.ecommerce.order.PaymentMethod;
import com.riadh.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
