package com.activity1.ordenes.services;

import com.activity1.ordenes.controller.DTO.OrderDTO;
import com.activity1.ordenes.entity.OrderEntity;
import com.activity1.ordenes.exception.OrderServiceException;
import com.activity1.ordenes.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        try {
            OrderEntity orderEntity = OrderServiceImpl.convertToEntity(orderDTO);
            OrderEntity order = orderRepository.save(orderEntity);
            return OrderServiceImpl.convertToDTO(order);
        } catch (Exception e) {
            throw new OrderServiceException("Error al guardar la orden", e);
        }
    }

    @Override
    public OrderDTO getOrder(Long id) {
        try {
            OrderEntity order = orderRepository.findById(id).orElse(null);
            if (order != null) {
                return OrderServiceImpl.convertToDTO(order);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new OrderServiceException("Error al obtener la orden con id: " + id, e);
        }
    }

    @Override
    public Boolean deleteOrder(Long id) {
        try {
            orderRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new OrderServiceException("Error al eliminar la orden con id: " + id, e);
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        try {
            List<OrderDTO> orderDTOS = orderRepository.findAll().stream().map(OrderServiceImpl::convertToDTO).toList();
            return orderDTOS;
        } catch (Exception e) {
            throw new OrderServiceException("Error al obtener todas las órdenes", e);
        }
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderEntity) {
        try {
            OrderEntity order = orderRepository.findById(id).orElse(null);
            if (order != null) {
                order.setDescription(orderEntity.getDescription());
                order.setStatus(orderEntity.getStatus());
                order.setFechaEmision(orderEntity.getFechaEmision());
                order.setUsername(orderEntity.getUsername());
                order.setUsuarioCreacion(orderEntity.getUsuarioCreacion());
                order.setUsuarioActualizacion(orderEntity.getUsuarioActualizacion());
                orderRepository.save(order);
                return OrderServiceImpl.convertToDTO(order);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new OrderServiceException("Error al actualizar la orden con id: " + id, e);
        }
    }
    public static OrderEntity convertToEntity(OrderDTO orderDTO) {
        return OrderEntity.builder()
                .id(orderDTO.getId())
                .description(orderDTO.getDescription())
                .status(orderDTO.getStatus())
                .fechaEmision(orderDTO.getFechaEmision())
                .username(orderDTO.getUsername())
                .usuarioCreacion(orderDTO.getUsuarioCreacion())
                .usuarioActualizacion(orderDTO.getUsuarioActualizacion())
                .build();
    }

    public static OrderDTO convertToDTO(OrderEntity orderEntity) {
        return OrderDTO.builder()
                .id(orderEntity.getId())
                .description(orderEntity.getDescription())
                .status(orderEntity.getStatus())
                .fechaEmision(orderEntity.getFechaEmision())
                .username(orderEntity.getUsername())
                .usuarioCreacion(orderEntity.getUsuarioCreacion())
                .usuarioActualizacion(orderEntity.getUsuarioActualizacion())
                .build();

    }
}
