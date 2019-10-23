package com.invillia.acme.service;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.PaymentRepository;
import com.invillia.acme.repository.filter.PaymentFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> filter(PaymentFilter paymentFilter) {
        return paymentRepository.filter(paymentFilter);
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

}
