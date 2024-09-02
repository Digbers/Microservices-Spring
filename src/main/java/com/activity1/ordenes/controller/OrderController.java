package com.activity1.ordenes.controller;

import com.activity1.ordenes.controller.DTO.OrderDTO;
import com.activity1.ordenes.entity.OrderEntity;
import com.activity1.ordenes.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @PostMapping("/save")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO order = orderService.saveOrder(orderDTO);
        return ResponseEntity.ok(order);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<OrderDTO> updateOrder( @PathVariable Long id,@RequestBody OrderDTO orderDTO) {
        OrderDTO orderEntity = orderService.updateOrder(id, orderDTO);
        return ResponseEntity.ok(orderEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOrder( @PathVariable Long id) {
        Boolean deleted = orderService.deleteOrder(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orderDTOS = orderService.getAllOrders();
        return ResponseEntity.ok(orderDTOS);
    }
}
