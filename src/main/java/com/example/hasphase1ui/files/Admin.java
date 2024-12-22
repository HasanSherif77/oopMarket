package com.example.hasphase1ui.files;



import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private Role role;
    private WorkingHours workingHours;
    private UsersEditor usersEditor =new UsersEditor();
    private ProductCRUD productCRUD = new ProductCRUD();
    private CategoryCRUD categoryCRUD = new CategoryCRUD();
    private ArrayList<Order> orders = Database.getOrders();

    public Role getRole() {
        return role;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public Admin(String username, String password, Date dateOfBirth, Role role, WorkingHours workingHours) {
        super(username, password, dateOfBirth);
        this.role = role;
        this.workingHours = workingHours;
    }

    public void printUsers(){
        usersEditor.print();
    }

    public void createProduct(Product newProduct) {
        productCRUD.add(newProduct);
    }

    public Product readProduct(String productName) {
        return productCRUD.read(productName);
    }

    public void updateProduct(Product updatedProduct, String productToBeUpdatedName) {
        productCRUD.update(updatedProduct,productToBeUpdatedName);
    }
    public void deleteProduct(Product productToBeDeleted) {
        productCRUD.remove(productToBeDeleted);
    }

    @Override
    public boolean login(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }
    public void registerUser(User user){
        usersEditor.add(user);
    }
    public void deleteUser(User user){
        usersEditor.remove(user);
    }
    public void addCategory(Category category){
        categoryCRUD.add(category);
    }
    public void deleteCategory(Category category){
        categoryCRUD.remove(category);
    }
    public void updateCategory(Category category,String categoryToBeUpdatedName){
        categoryCRUD.update(category,categoryToBeUpdatedName);
    }
    public Category readCategory(String categoryName){
        return categoryCRUD.read(categoryName);
    }
    public void printProducts(){
        productCRUD.printProducts();
    }
    public void printOrders(){
        for (Order order : orders) {
            System.out.println("Order Number: " + order.getOrderNumber());
            System.out.println("Customer: " + order.getCustomer().getUsername());
            System.out.println("Payment Method: " + order.getPaymentMethod());

        }
    }

}

