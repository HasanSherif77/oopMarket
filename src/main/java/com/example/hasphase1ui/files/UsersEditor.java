package com.example.hasphase1ui.files;


import java.util.ArrayList;
import java.util.List;

public class UsersEditor {
    static ArrayList<User> users = Database.getUsers();

    public  void add(Object object) {
        User newUser = (User) object;
        users.add(newUser);
    }

    public void remove(Object object) {
        User userToDelete = (User) object;
        users.remove(userToDelete);
    }
    public void print() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        System.out.println("List of Users:");
        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            user.getDateOfBirth().printDate();
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                System.out.println("Role: Customer");
                System.out.println("Balance: " + customer.getBalance());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Gender: " + customer.getGender());
            } else if (user instanceof Admin) {
                Admin admin = (Admin) user;
                System.out.println("Role: Admin");
                System.out.println("Role Title: " + admin.getRole());
                System.out.println("Working Hours: " + admin.getWorkingHours().returnWorkingHours());
            }
            System.out.println("----------------------");
        }

    }
    public  ArrayList<User> getUsers() {
        return users;
    }
}





//public void update(Object newUser,String oldUsername) {
//        User updatedUser = (User) newUser;
//        User userToBeUpdated = read(oldUsername);
//        productToBeUpdated = updatedProduct;
//    }
//
//
//    public User read(String oldUsername) {
//
//    }