package com.PizzaOrders.PizzaApi.repositories;

import com.PizzaOrders.PizzaApi.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
}