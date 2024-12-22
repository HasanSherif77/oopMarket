package com.example.hasphase1ui.files;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private static int productCount=1;
    private int id ;
    private String name;
    private Category category;
    private double price;
    private int stock;
    private String productImage;

    public Product(String name,Category category , double price,int stock,String productImage){
        this.id = productCount++;
        this.name =name;
        this.category=category;
        this.price=price;
        this.stock=stock;
        this.productImage=productImage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public static int getProductCount() {
        return productCount;
    }

    public static void setProductCount(int productCount) {
        Product.productCount = productCount;
    }

    public String getProductImageUrl() {
        return productImage;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImage = productImageUrl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}