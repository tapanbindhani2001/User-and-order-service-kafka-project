package com.tapan.service;

import com.tapan.Dto.ResponseDto;
import com.tapan.entity.Order;

import java.util.List;

public interface OrderService {

    ResponseDto getOrderById(String id);
    Order createOrder(Order order);
    Order updateOrder(String id,Order order);
    boolean deleteOrder(String id);

}
