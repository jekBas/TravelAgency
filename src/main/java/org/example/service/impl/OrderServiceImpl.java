package org.example.service.impl;

import org.example.dao.OrderDao;
import org.example.model.Orders;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void saveOrder(Orders order) {
        orderDao.saveOrder(order);
    }
}