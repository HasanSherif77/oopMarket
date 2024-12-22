package com.example.hasphase1ui.files;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ArrayList<Product> customerCart = new ArrayList<>();

    public ArrayList<Product> getCartProducts(){
        return customerCart;
    }

    public void addToCart(Product newProduct){
        customerCart.add(newProduct);
    }

    public void displayCart() {
        if (customerCart.isEmpty()) {
            System.out.println("Your cart is empty.\n");
        } else {
            System.out.println("Your Cart:");
            for (Product product : customerCart) {
                System.out.println("Product: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("------");
            }
        }
        System.out.println("Total Price: " + getTotalPrice());
    }


    public double getTotalPrice(){
        double totalPrice=0;
        for(Product product: customerCart){
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }


}

