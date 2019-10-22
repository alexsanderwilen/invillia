package com.invillia.acme.service;

import com.invillia.acme.model.Payment;

import java.time.LocalDate;
import java.util.List;

public interface PaymentService {
    Payment getPaymentByOrder(Long order_id);
    List<Payment> getPaymentByPaymentDateBetween(LocalDate paymentDateStart, LocalDate paymentDateEnd);
    List<Payment> getPaymentByStatus(String Status);
}
