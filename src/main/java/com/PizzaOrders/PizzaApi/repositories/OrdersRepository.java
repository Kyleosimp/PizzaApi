package com.PizzaOrders.PizzaApi.repositories;

import com.PizzaOrders.PizzaApi.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select * " + "from orders o, customers c" + "where o.customer_customer_id =?1", nativeQuery = true)
    public Set<Orders> findByCustomerId(Long id);
}