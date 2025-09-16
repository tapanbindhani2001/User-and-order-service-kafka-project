package com.tapan.service;

import com.tapan.Dto.ResponseDto;
import com.tapan.client.UserClient;
import com.tapan.entity.Order;
import com.tapan.entity.User;
import com.tapan.exception.DataNotFoundException;
import com.tapan.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private KafkaTemplate<String,String> template;
    @Autowired
    private OrderRepo repo;
    @Autowired
    private UserClient client;
    private static final String topic="order-events";
    @Override
    public ResponseDto getOrderById(String id) {
        Order order = repo.findById(id).orElseThrow(() -> new DataNotFoundException("User with this " + id + "not found"));
        template.send(topic,"Order Fetching from order id "+order.getId()+"For UserId "+order.getUserId());
        User user = client.getUserById(order.getUserId());
        return new ResponseDto(order, user);

    }

    @Override
    public Order createOrder(Order order) {
        User user = client.getUserById(order.getUserId());
        if(user==null)
            throw  new DataNotFoundException("User not found with this user id "+order.getUserId());
        Order order1 = repo.save(order);
        template.send(topic,"ORDER_CREATED"+order1.getId()+"With UserId "+order1.getUserId());
        return order1;


    }

    @Override
    public Order updateOrder(String id, Order order) {
        Order order1 = repo.findById(id).orElseThrow(() -> new DataNotFoundException("Records Not found with this " + id));
        order1.setPrice(order.getPrice());
        order1.setProduct(order.getProduct());
        Order save = repo.save(order1);
        template.send(topic, "ORDER_UPDATED: " +save.getId() + " for UserID: " + save.getUserId());
        return order1;

    }

    @Override
    public boolean deleteOrder(String id) {
        Order order = repo.findById(id).orElseThrow(() -> new DataNotFoundException("ID not fount " + id));
        repo.delete(order);
        template.send(topic, "ORDER_DELETED: " + order.getId() + " for UserID: " + order.getUserId());
        return true;

    }
}
