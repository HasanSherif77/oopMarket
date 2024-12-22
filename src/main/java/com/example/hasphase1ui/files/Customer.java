package com.example.hasphase1ui.files;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private double balance;
    private String address;
    private Gender gender;
    private ArrayList<Category> interests;
    private Cart cart;
    private ArrayList <Order> customerOrders= new ArrayList<>();


    public double getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public List<Category> getInterests() {
        return interests;
    }

    public Cart getCart() {
        return cart;
    }

    public Customer(String username, String password, Date dateOfBirth, double balance, String address, Gender gender) {
        super(username, password, dateOfBirth);
        this.balance = balance;
        this.address = address;
        this.gender = gender;
        this.interests = new ArrayList<>();
        this.cart = new Cart();

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setInterests(ArrayList<Category> interests) {
        this.interests = interests;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCustomerOrders(ArrayList<Order> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }

    public void addInterest(Category interest) {
        interests.add(interest);
    }

    public void addToCart(Product product) {
        cart.addToCart(product);
        if (!interests.contains(product.getCategory())){
            interests.add(product.getCategory());
        }
    }
    public void removeFromCart(Product product){
        cart.getCartProducts().remove(product);
    }

    public void placeOrder(Order newOrder) {
        customerOrders.add(newOrder);
        System.out.println("Order placed successfully!");
        Database.getOrders().add(newOrder);
    }
    public Gender getGender(){
        return gender;
    }
    @Override
    public boolean login(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }
    public void displaycart(){
        cart.displayCart();
    }
}

