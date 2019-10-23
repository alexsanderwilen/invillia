package com.invillia.acme.resource;

import com.invillia.acme.model.Customer;
import com.invillia.acme.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }


    @GetMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String activateCustomer(@PathVariable("id") Long id) {
        return customerService.activeCustomer(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody Customer funcionario) {
        customerService.updateCustomer(funcionario);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathParam("id") Long id) {
        customerService.deleteCustomer(id);
    }
}