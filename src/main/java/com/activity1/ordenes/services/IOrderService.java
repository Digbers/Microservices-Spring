package com.activity1.ordenes.services;

import com.activity1.ordenes.controller.DTO.OrderDTO;
import com.activity1.ordenes.entity.OrderEntity;

import java.util.List;

public interface IOrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);

    OrderDTO getOrder(Long id);

    Boolean deleteOrder(Long id);

    List<OrderDTO> getAllOrders();

    OrderDTO updateOrder(Long id , OrderDTO orderDTO);
}
