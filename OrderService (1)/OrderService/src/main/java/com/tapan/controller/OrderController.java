package com.tapan.controller;

import com.tapan.Dto.ResponseDto;
import com.tapan.entity.Order;
import com.tapan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
 @Autowired
  private OrderService service;
 @GetMapping("/{id}")
 public ResponseEntity<ResponseDto> getOrder(@PathVariable String id)
 {
     ResponseDto orderById = service.getOrderById(id);
     return ResponseEntity.ok(orderById);
 }
    @PostMapping("/create")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order order1 = service.createOrder(order);
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order order)
    {
        Order updated = service.updateOrder(id, order);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)
    {
        boolean deleted = service.deleteOrder(id);
        if(deleted)
        {
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Order deleted successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }

    }






}
