package com.PizzaOrders.PizzaApi.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "crust", nullable = false)
    private String crust;

    @Column(name = "toppings")
    private String toppings;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private STATUS status;

    @Column(name = "pizzaName")
    private String pizzaName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customers_id")
    private Customers customers;

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Orders() {
    }

    public Orders(Long id, String crust, String toppings, STATUS status, String pizzaName, Customers customers) {
        this.id = id;
        this.crust = crust;
        this.toppings = toppings;
        this.status = status;
        this.pizzaName = pizzaName;
        this.customers = customers;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

//    public STATUS getSTATUS() {
//        return status;
//    }
//
//    public void setSTATUS(STATUS status) {
//        this.status = status;
//    }


    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", crust='" + crust + '\'' +
                ", toppings='" + toppings + '\'' +
                ", status=" + status +
                ", pizzaName='" + pizzaName + '\'' +
                ", customers=" + customers +
                '}';
    }
}