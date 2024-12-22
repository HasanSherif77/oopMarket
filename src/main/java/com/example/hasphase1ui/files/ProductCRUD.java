package com.example.hasphase1ui.files;

import java.util.ArrayList;
import java.util.List;

public class ProductCRUD implements CRUD{
    private static final ArrayList<Product> products = Database.getProducts();

    @Override
    public void add(Object object) {
        Product newProduct = (Product) object;
        products.add(newProduct);
    }
    @Override
    public void remove(Object object) {
        Product productToBeRemoved = (Product) object;
        products.remove(productToBeRemoved);
    }
    @Override
    public void update(Object object, String oldObjectName) {
        Product updatedProduct = (Product) object;
        Product productToBeUpdated = read(oldObjectName);
        productToBeUpdated =updatedProduct;

    }
    @Override
    public Product read(String objectName) {
        for (Product product : products){
            if (product.getName().equals(objectName)){
                return product;
            }
        }
        return null;
    }
    public void printProducts(){
        for (Product product : products) {
            System.out.println("        PRODUCTS");
            System.out.println("Product ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Category: " + product.getCategory().getCategoryName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("----------------------------------");
        }
    }

}
