package com.invillia.acme.resource;

import com.invillia.acme.model.OrderItem;
import com.invillia.acme.service.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderItems")
public class OrderItemResource {

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @GetMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItem> getOrderItems(@PathVariable("orderId") Long orderId){
        return orderItemService.getOrderItems(orderId);
    };

    @GetMapping("/order/item/{orderId}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItem getOrderItem(@PathVariable("orderId") Long orderId, @PathVariable("id") Long id){
        return orderItemService.getOrderItem(orderId, id);
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrderItem(@RequestBody OrderItem orderItem ){
        orderItemService.saveOrderItem(orderItem);
    };

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderItem(OrderItem orderItem){
        orderItemService.updateOrderItem(orderItem);
    };

    @DeleteMapping("/order/item/{orderId}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderItem(Long orderId, Long id){
        orderItemService.deleteOrderItem(orderId, id);
    };

    @DeleteMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderItems(Long orderId){
        orderItemService.deleteOrderItems(orderId);
    };
}
