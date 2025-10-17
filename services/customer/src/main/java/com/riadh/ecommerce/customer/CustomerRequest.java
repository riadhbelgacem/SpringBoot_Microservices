package com.riadh.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message ="customer firstname is required")
        String firstname,
        @NotNull(message ="customer lastname is required")
        String lastname,
        @Email(message ="customer email is required")
        @Email(message ="customer email is not a valid email")
        String email,
        Address address


) {

}
