package com.example.hasphase1ui.files;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private static int numberOfOrders=1;
    private int orderNumber;
    private Enum paymentMethod;
    private double orderTotal;
    private ArrayList<Product> customerOrder = new ArrayList<>();

    public Order(Customer customer,PaymentMethod paymentMethod){
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.customerOrder = customer.getCart().getCartProducts();
        this.orderNumber = numberOfOrders++;

    }
    public Order(Customer customer,PaymentMethod paymentMethod,double orderTotal){
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.customerOrder = customer.getCart().getCartProducts();
        this.orderNumber = numberOfOrders++;
        this.orderTotal=orderTotal;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getNumberOfOrders() {
        return numberOfOrders;
    }

    public static void setNumberOfOrders(int numberOfOrders) {
        Order.numberOfOrders = numberOfOrders;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Enum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Enum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<Product> getCustomerOrder() {
        return customerOrder;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setCustomerOrder(ArrayList<Product> customerOrder) {
        this.customerOrder = customerOrder;
    }
}
