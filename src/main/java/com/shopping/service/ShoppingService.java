package com.shopping.service;

import com.shopping.entity.*;
import jakarta.persistence.*;
import java.util.*;

public class ShoppingService {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("shoppingPU");

    // Method to add sample data
    public void addSampleData() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Create Customer
        Customer c = new Customer();
        c.setName("John");
        em.persist(c);

        // Create Products
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(50000);

        Product p2 = new Product();
        p2.setName("Mobile");
        p2.setPrice(20000);

        em.persist(p1);
        em.persist(p2);

        tx.commit();
        em.close();

        System.out.println("Sample data inserted!");
        System.out.println("Inserted Customer ID: " + c.getId());
        System.out.println("Inserted Product IDs: " + p1.getId() + ", " + p2.getId());
    }

    // Method to place an order
    public void placeOrder(int customerId, List<Integer> productIds) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer customer = em.find(Customer.class, customerId);

        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);

        List<Product> products = new ArrayList<>();
        double total = 0;

        for (int pid : productIds) {
            Product p = em.find(Product.class, pid);
            products.add(p);
            total += p.getPrice();
        }

        order.setProducts(products);
        order.setTotalAmount(total);

        em.persist(order);

        tx.commit();
        em.close();

        System.out.println("Order placed! Total = " + total);
    }

    // Method to fetch all orders of a customer
    public void getCustomerOrders(int customerId) {

        EntityManager em = emf.createEntityManager();

        Customer customer = em.find(Customer.class, customerId);

        List<OrderEntity> orders = customer.getOrders();

        for (OrderEntity o : orders) {
            System.out.println("Order ID: " + o.getId());
            System.out.println("Total: " + o.getTotalAmount());

            for (Product p : o.getProducts()) {
                System.out.println(" - " + p.getName());
            }
        }

        em.close();
    }
}