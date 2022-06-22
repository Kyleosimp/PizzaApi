package com.PizzaOrders.PizzaApi.services;

import com.PizzaOrders.PizzaApi.models.Customers;
import com.PizzaOrders.PizzaApi.models.Orders;
import com.PizzaOrders.PizzaApi.repositories.CustomersRepository;
import com.PizzaOrders.PizzaApi.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    private CustomersRepository customersRepository;
    private OrdersRepository ordersRepository;

    //create a customer: save function
    public void createCustomer(Customers customer){
        customer = customersRepository.save(customer);
    }

    //get all customers
    public List<Customers> getAllCustomers(){
        return new ArrayList<>(customersRepository.findAll());
    }

    //delete a customer
    public void deleteCustomer(Long id){
        customersRepository.deleteById(id);
    }

    //retrieve a customer
    public Optional<Customers> getCustomerById(Long id){
        return customersRepository.findById(id);
    }

    //update a customer's details
    public Customers updateCustomer(Long id, Customers customer){
        for (Customers c: getAllCustomers()){
            if (c.getId()==id){
                customersRepository.save(customer);
            }
        }
        return customer;
    }
    //========================================================================PART 2

    public Set<Orders> getOrdersFromCustomer(Long id){
        return ordersRepository.findByCustomerId(id);
    }
}
