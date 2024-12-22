package com.example.hasphase1ui;


import com.example.hasphase1ui.Pages.*;

import com.example.hasphase1ui.Pages.CRUD.Category.ReadCategoryScreen;
import com.example.hasphase1ui.Pages.CRUD.Product.AddProductScreen;
import com.example.hasphase1ui.Pages.CRUD.Product.EditProductScreen;
import com.example.hasphase1ui.Pages.CRUD.Product.ReadProductScreen;
import com.example.hasphase1ui.Pages.CartOrders.CartPage;
import com.example.hasphase1ui.Pages.LoginPages.LoginPage;
import com.example.hasphase1ui.Pages.LoginPages.RegistrationPage;
import com.example.hasphase1ui.files.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Database.initializeDummyData();
        Customer customer = new Customer("hasan","hasanpass",new Date(1,"January",2000),5000,"123 baker Street", Gender.Female);
        Admin admin = new Admin("hasanadmn","hasanadmnpass",new Date(1,"February",2000),Role.ProductManager,new WorkingHours(10,6));
        AcountViewScreen acountViewScreen = new AcountViewScreen(stage,customer);
        stage.setMaximized(true);
        Category electronics = Database.getCategories().get(1);
        Product product = Database.getProducts().get(2);
        AddProductScreen addProductScreen = new AddProductScreen(stage,admin);
        EditProductScreen editProductScreen = new EditProductScreen(stage,Database.getProducts().get(4),admin);
        ReadProductScreen readProductScreen = new ReadProductScreen(stage,admin);
        AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
        RegistrationPage registrationPage = new RegistrationPage(stage);
        CartPage cartPage = new CartPage(customer,stage);


        stage.setFullScreen(true);
        LoginPage loginPage = new LoginPage(stage);
        Scene scene = new Scene(new Pane());
        stage.setScene(scene);
        stage.getScene().setRoot(acountViewScreen.getRoot());

        stage.setTitle("Acount View");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}