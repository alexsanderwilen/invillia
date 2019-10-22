package com.invillia.acme.service;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getPaymentByOrder(Long order_id) {
        return paymentRepository.getPaymentByOrder(order_id);
    }

    @Override
    public List<Payment> getPaymentByPaymentDateBetween(LocalDate paymentDateStart, LocalDate paymentDateEnd) {
        return paymentRepository.getPaymentByPaymentDateBetween(paymentDateStart, paymentDateEnd);
    }

    @Override
    public List<Payment> getPaymentByStatus(String Status) {
        return paymentRepository.getPaymentByStatus(Status);
    }
}
