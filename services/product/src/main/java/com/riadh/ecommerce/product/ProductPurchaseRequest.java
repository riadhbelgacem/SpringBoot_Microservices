package com.riadh.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(

        @NotNull(message="product is mandatory")
        Integer productId,
        @Positive(message="quantity is mandatory")
        double quantity
) {
}
