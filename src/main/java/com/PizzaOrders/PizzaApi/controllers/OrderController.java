package com.PizzaOrders.PizzaApi.controllers;

import com.PizzaOrders.PizzaApi.PizzaApiApplication;
import com.PizzaOrders.PizzaApi.models.Customers;
import com.PizzaOrders.PizzaApi.models.Orders;
import com.PizzaOrders.PizzaApi.services.CustomerService;
import com.PizzaOrders.PizzaApi.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(PizzaApiApplication.class);

    @Autowired
    private OrderService orderService;
    private CustomerService customerService;

    ///create a new order
//    @PostMapping("/orders")
//    public ResponseEntity<?> createOrder(@RequestBody Orders order){
//        orderService.createOrder(order);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    //get all orders
    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }

    //get an order by id
    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOder(@PathVariable Long id){
        logger.info("Found an order with id of " + id);
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    //update an oder
    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> editOrder(@PathVariable Long id, @RequestBody Orders order){
        logger.info("Edited an order with id of " + id);
        orderService.updateOrder(id, order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete an order
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        logger.info("Deleted an order with value of " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //========================================================================PART 2

    @GetMapping("/orders/{id}/customers")
    public ResponseEntity<?> getCustomerByOrderId(@PathVariable Long id){
        logger.info("Retrieving Customer info by Order Id");
        Optional<Orders> order = orderService.getOrderById(id);
        return new ResponseEntity<>(orderService.getCustomerByOrderId(order.get().getId()), HttpStatus.OK);
    }
//    /create a new order
    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Orders order){
        orderService.createOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/orders")
//    public ResponseEntity<?> createOrder(@RequestBody Orders order){
//        logger.info("Creating a new order with customer");
//        for (Customers c: customerService.getAllCustomers()){
//            if (order.getCustomers().getId().equals(c.getId())){
//                order.setCustomers(c);
//            }
//        }
//        orderService.createOrder(order);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
