package com.invillia.acme.resource;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.PaymentRepository;
import com.invillia.acme.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPaymentByOrder(@PathVariable("order_id") Long order_id){
        return paymentService.getPaymentByOrder(order_id);
    }

    @GetMapping("/between/paymentDate/{paymetnDateStart}/{paymentDateEnd}")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getPaymentByPaymentDateBetween(@PathVariable("paymetnDateStart") LocalDate paymentDateStart, @PathVariable("paymentDateEnd") LocalDate paymentDateEnd){
        return paymentService.getPaymentByPaymentDateBetween(paymentDateStart, paymentDateEnd);
    }

    @GetMapping("/verify/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getPaymentByStatus(@PathVariable("status") String status){
        return paymentService.getPaymentByStatus(status);
    }


}
