package com.riadh.ecommerce.payment;

import com.riadh.ecommerce.notification.NotificationProducer;
import com.riadh.ecommerce.notification.PaymentNotificationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor



public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;
    @Autowired
    public void setNotificationProducer(NotificationProducer NotificationProducer) {}
    public Integer createPayment(@Valid PaymentRequest request) {
        var paymemnt = repository.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return paymemnt.getId();

    }
}
