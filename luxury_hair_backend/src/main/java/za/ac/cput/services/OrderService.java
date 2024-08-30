package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    private  OrderRepository orderRepository;
    @Autowired
    OrderService(OrderRepository repo) {
        this.orderRepository = repo;
    }
    private OrderService(){

    }
    @Override
    public Order create (Order order) {

        return orderRepository.save(order);
    }
    @Override
    public Order read(String OrderID){
        return orderRepository.findById(OrderID).orElse(null);
    }
    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getall() {
        return orderRepository.findAll();
    }
}