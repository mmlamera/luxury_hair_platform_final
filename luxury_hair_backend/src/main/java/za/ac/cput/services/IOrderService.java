package za.ac.cput.services;

import za.ac.cput.domain.Order;

import java.util.List;

public interface IOrderService extends IService<Order,String> {
    List<Order> getall();
}