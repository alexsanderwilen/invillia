package com.invillia.acme.repository;

import com.invillia.acme.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment getPaymentByOrder(Long order_id);
    List<Payment> getPaymentByPaymentDateBetween(LocalDate paymentDateStart, LocalDate paymentDateEnd);
    List<Payment> getPaymentByStatus(String Status);
}
