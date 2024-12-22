package com.example.hasphase1ui.Pages;

import com.example.hasphase1ui.Pages.AdminPrint.ShowOrders;
import com.example.hasphase1ui.Pages.AdminPrint.ShowProducts;
import com.example.hasphase1ui.Pages.AdminPrint.ShowUsers;
import com.example.hasphase1ui.Pages.CRUD.Category.AddCategoryPage;
import com.example.hasphase1ui.Pages.CRUD.Category.ReadCategoryScreen;
import com.example.hasphase1ui.Pages.CRUD.Product.AddProductScreen;
import com.example.hasphase1ui.Pages.CRUD.Product.ReadProductScreen;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminHomeScreen {
    private Stage stage;
    private Admin admin;
    public AdminHomeScreen(Stage stage,Admin admin){
        this.stage = stage;
        this.admin = admin;
    }
    public VBox getRoot(){
        VBox adminHomeScreenView = new VBox(30);



        Image logoImage = new Image("Images/profileicon.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(300);
        logoImageView.setPreserveRatio(true);
        Button logoButton = new Button();
        HBox logoLabelRow = new HBox(logoButton);
        logoLabelRow.setAlignment(Pos.CENTER);
        logoButton.setGraphic(logoImageView); // Set the image as the graphic of the button
        logoButton.setStyle("-fx-background-color: transparent;"); // Remove button background
        logoButton.setPadding(new Insets(0)); // Remove padding around the button

        logoButton.setOnAction(event -> {
            // Action when the logo button is clicked
            System.out.println("Logo clicked!");
            // Add your custom action here (e.g., navigate to another page, open a dialog, etc.)
        });

        adminHomeScreenView.setBackground(PagesBackground.getBackground());


        SizedBox sizedBox1 = new SizedBox(1,130);

        CenteredLabel welcomeLabel = new CenteredLabel("Welcome Admin",50,"-fx-font-weight: bold;");

        ConfirmButton viewProfileButton = new ConfirmButton("View Profile");
        HBox viewProfile = new HBox(viewProfileButton);
        viewProfile.setAlignment(Pos.CENTER);


        HBox productCRUD = new HBox(40);
        ConfirmButton readProductButton =new ConfirmButton("Read Product");
        ConfirmButton addProductButton = new ConfirmButton("Add Product");
        productCRUD.getChildren().addAll(readProductButton,addProductButton);
        productCRUD.setAlignment(Pos.CENTER);

        HBox categoryCRUD = new HBox(40);
        ConfirmButton readCategoryButton =new ConfirmButton("Read Category");
        ConfirmButton addCategoryButton = new ConfirmButton("Add Category");
        categoryCRUD.getChildren().addAll(readCategoryButton,addCategoryButton);
        categoryCRUD.setAlignment(Pos.CENTER);

        HBox showAllHbox = new HBox(40);
        ConfirmButton printUsers =new ConfirmButton("All Users");
        ConfirmButton printProducts = new ConfirmButton("All Products");
        ConfirmButton printOrders = new ConfirmButton("All Orders");
        showAllHbox.setAlignment(Pos.CENTER);

        showAllHbox.getChildren().addAll(printUsers,printProducts,printOrders);

        addCategoryButton.setOnAction(e->{
            AddCategoryPage addCategoryPage = new AddCategoryPage(stage,admin);
            stage.getScene().setRoot(addCategoryPage.getRoot());
            stage.setFullScreen(true);
        });

        readCategoryButton.setOnAction(e->{
            ReadCategoryScreen readCategoryScreen =new ReadCategoryScreen(stage,admin);
            stage.getScene().setRoot(readCategoryScreen.getRoot());
            stage.setFullScreen(true);
        });

        printUsers.setOnAction(e->{
            ShowUsers showUsers = new ShowUsers(stage,admin);
            stage.getScene().setRoot(showUsers.getRoot());
        });
        printProducts.setOnAction(e->{
            ShowProducts showProducts = new ShowProducts(stage,admin);
            stage.getScene().setRoot(showProducts.getRoot());
        });
        printOrders.setOnAction(e->{
            ShowOrders showOrders = new ShowOrders(stage,admin);
            stage.getScene().setRoot(showOrders.getRoot());
        });

        adminHomeScreenView.getChildren().addAll(sizedBox1,welcomeLabel,logoLabelRow,viewProfile, productCRUD,categoryCRUD,showAllHbox);

        viewProfileButton.setOnAction(e -> {
            AcountViewScreen adminAcountViewScreen = new AcountViewScreen(stage, admin);
            stage.getScene().setRoot(adminAcountViewScreen.getRoot());
            stage.setFullScreen(true); // Apply full-screen mode after scene change
        });
        readProductButton.setOnAction(e ->{
            ReadProductScreen readProductScreen =new ReadProductScreen(stage,admin);
            stage.getScene().setRoot(readProductScreen.getRoot());
            stage.setFullScreen(true);
        });
        addProductButton.setOnAction(e->{
            AddProductScreen addProductScreen = new AddProductScreen(stage,admin);
            stage.getScene().setRoot(addProductScreen.getRoot());
            stage.setFullScreen(true);
        });




        return  adminHomeScreenView;
    }
}
