package com.riadh.ecommerce.notification;

import com.riadh.ecommerce.kafka.order.OrderConfirmation;
import com.riadh.ecommerce.kafka.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Document

public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private PaymentConfirmation paymentConfirmation;
    private OrderConfirmation orderConfirmation;
}
