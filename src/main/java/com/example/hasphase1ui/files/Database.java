package com.example.hasphase1ui.files;

import java.util.ArrayList;

public abstract class Database {
    static private ArrayList<User> users = new ArrayList<>();
    static private ArrayList<Category> categories = new ArrayList<>();
    static private ArrayList<Product> products = new ArrayList<>();
    static private ArrayList<Order> orders = new ArrayList<>();

    public static void initializeDummyData() {
        // Initializing users
        users.add(new Admin("admin", "admin123", new Date(15, "January", 1985), Role.InventoryManager, new WorkingHours(9, 17)));
        users.add(new Admin("admin2", "admin456", new Date(25, "January", 1987), Role.ProductManager, new WorkingHours(10, 18)));
        users.add(new Customer("john_doe", "password", new Date(22, "January", 1995), 100.0, "123 Main St", Gender.Male));
        users.add(new Customer("jane_doe", "password123", new Date(5, "January", 1993), 200.0, "456 Oak St", Gender.Female));
        users.add(new Customer("susan_smith", "password456", new Date(15, "January", 1990), 500.0, "789 Pine St", Gender.Female));
        users.add(new Customer("mike_jones", "password789", new Date(30, "January", 1988), 300.0, "101 Maple St", Gender.Male));

        // Initializing categories
        Category electronics = new Category("Electronics", "/CategoryImages/electronics.jpeg");
        Category clothing = new Category("Clothing", "/CategoryImages/clothing.jpeg");
        Category homeAppliances = new Category("Home Appliances", "/CategoryImages/kitchen.jpeg");
        Category books = new Category("Books", "/CategoryImages/books.jpeg");

        categories.add(electronics);
        categories.add(clothing);
        categories.add(homeAppliances);
        categories.add(books);

        // Initializing products
        products.add(new Product("Smartphone", electronics, 599.99, 50, "/ProductImages/smartphone.jpeg"));
        products.add(new Product("Laptop", electronics, 899.99, 50, "/ProductImages/laptop.jpeg"));
        products.add(new Product("Smartwatch", electronics, 199.99, 50, "/ProductImages/smartwatch.jpeg"));
        products.add(new Product("T-Shirt", clothing, 19.99, 50, "/ProductImages/tshirt.jpeg"));
        products.add(new Product("Jeans", clothing, 49.99, 50, "/ProductImages/jeans.jpeg"));
        products.add(new Product("Sweater", clothing, 29.99, 50, "/ProductImages/sweater.jpeg"));
        products.add(new Product("Washing Machine", homeAppliances, 299.99, 50, "/ProductImages/washingmachine.jpeg"));
        products.add(new Product("Microwave", homeAppliances, 99.99, 50, "/ProductImages/microwave.jpg"));
        products.add(new Product("Refrigerator", homeAppliances, 499.99, 50, "/ProductImages/fridge.jpeg"));
        products.add(new Product("The Great Gatsby", books, 10.99, 50, "/ProductImages/thegreatgatsby.jpeg"));
        products.add(new Product("1984", books, 9.99, 50, "/ProductImages/1984.jpeg"));
        products.add(new Product("To Kill a Mockingbird", books, 12.99, 50, "/ProductImages/tokillamockingbird.jpeg"));

        // Initializing orders for customers
        Customer john = (Customer) users.get(2);
        john.addToCart(new Product("Smartphone", electronics, 599.99, 50, "/ProductImages/smartphone.jpeg"));
        john.addToCart(new Product("T-Shirt", clothing, 19.99, 50, "/ProductImages/tshirt.jpeg"));
        Order johnOrder = new Order(john, PaymentMethod.CashOnDelivery,5);
        john.placeOrder(johnOrder);

        Customer jane = (Customer) users.get(3);
        jane.addToCart(new Product("Jeans", clothing, 49.99, 50, "/ProductImages/jeans.jpeg"));
        jane.addToCart(new Product("Refrigerator", homeAppliances, 499.99, 50, "/ProductImages/fridge.jpeg"));
        Order janeOrder = new Order(jane, PaymentMethod.Balance,1000);
        jane.placeOrder(janeOrder);

        Customer susan = (Customer) users.get(4);
        susan.addToCart(new Product("Microwave", homeAppliances, 99.99, 50, "/ProductImages/microwave.jpg"));
        susan.addToCart(new Product("1984", books, 9.99, 50, "/ProductImages/1984.jpeg"));
        Order susanOrder = new Order(susan, PaymentMethod.Balance,2000);
        susan.placeOrder(susanOrder);

        Customer mike = (Customer) users.get(5);
        mike.addToCart(new Product("Laptop", electronics, 899.99, 50, "/ProductImages/laptop.jpeg"));
        mike.addToCart(new Product("Sweater", clothing, 29.99, 50, "/ProductImages/sweater.jpeg"));
        Order mikeOrder = new Order(mike, PaymentMethod.CashOnDelivery,5555);
        mike.placeOrder(mikeOrder);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static ArrayList<Product> getCategoryProducts(Category category) {
        ArrayList<Product> categoryProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() != null && product.getCategory().equals(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }




}
