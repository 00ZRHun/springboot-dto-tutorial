package net.javaguides.springboot.service;

import net.javaguides.springboot.models.Order;

import java.util.List;

public interface IOrderService
{
    Order createOrder(Order order);

    List<Order> getAllOrdersForCustomer(long customerId);
}
