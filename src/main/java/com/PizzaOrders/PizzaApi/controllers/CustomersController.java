package com.PizzaOrders.PizzaApi.controllers;

import com.PizzaOrders.PizzaApi.PizzaApiApplication;
import com.PizzaOrders.PizzaApi.models.Customers;
import com.PizzaOrders.PizzaApi.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomersController {
    private static final Logger logger = LoggerFactory.getLogger(PizzaApiApplication.class);

    @Autowired
    private CustomerService customerService;

    //register a customer
    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer (@RequestBody Customers customer){
        logger.info("Creating customer");
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //get all customers
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        logger.info("Retrieving all customers");
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    //get a specified customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        logger.info("Getting customer with customer id of " + id);
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    //change values of customer by id
    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustoemr(@PathVariable Long id, @RequestBody Customers customer){
        logger.info("Updating values of customer " + id);
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete a customer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        logger.info("Deleting customer #" +id);
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //========================================================================PART 2
    //get all orders from a customer
    public ResponseEntity<?> getAllOrdersFromCustomer(@PathVariable Long id){
        logger.info("Retrieving all orders from Customer#"+id);
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
}
