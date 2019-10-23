package com.invillia.acme.resource;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.filter.PaymentFilter;
import com.invillia.acme.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> search(PaymentFilter paymentFilter) {
        return paymentService.filter(paymentFilter);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void savePayment(@RequestBody Payment payment) {
        paymentService.savePayment(payment);
    }
}
