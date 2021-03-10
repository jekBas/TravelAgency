package org.example.dao;

import org.example.model.Orders;

public interface OrderDao {

    void saveOrder(Orders order);
}