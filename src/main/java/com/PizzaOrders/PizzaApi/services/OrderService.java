package com.PizzaOrders.PizzaApi.services;

import com.PizzaOrders.PizzaApi.models.Customers;
import com.PizzaOrders.PizzaApi.models.Orders;
import com.PizzaOrders.PizzaApi.repositories.CustomersRepository;
import com.PizzaOrders.PizzaApi.repositories.OrdersRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;
    private CustomersRepository customersRepository;

    //create a pizza order
    public void createOrder(Orders order){
        order = ordersRepository.save(order);
    }

    //get all orders
    public List<Orders> getAllOrders(){
        List<Orders> orders = new ArrayList<>();
        ordersRepository.findAll().forEach(orders::add);
        return orders;
    }

    //get order by id
    public Optional<Orders> getOrderById(Long id){
        return ordersRepository.findById(id);
    }

    //delete an order by id
    public void deleteOrder(Long id){
        ordersRepository.deleteById(id);
    }

    //update an order details
    public Orders updateOrder(Long id, Orders order){
        for (Orders o: getAllOrders()){
            if (o.getId()==id){
                ordersRepository.save(order);
            }
        }
        return order;
    }

    //========================================================================PART 2
    public Customers getCustomerByOrderId(Long id){
        return customersRepository.findById(id).get();
    }
}
