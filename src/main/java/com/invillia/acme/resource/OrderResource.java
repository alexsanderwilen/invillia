package com.invillia.acme.resource;

import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.model.Order;
import com.invillia.acme.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResource {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable("id") Long id){
        return orderService.getOrder(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(@RequestBody Order order ){
        orderService.saveOrder(order);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathParam("id") Long id){
        orderService.deleteOrder(id);
    }
}
