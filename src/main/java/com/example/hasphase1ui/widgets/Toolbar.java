package com.example.hasphase1ui.widgets;

import com.example.hasphase1ui.Pages.AcountViewScreen;
import com.example.hasphase1ui.Pages.CartOrders.CartPage;
import com.example.hasphase1ui.Pages.CartOrders.OrdersPage;
import com.example.hasphase1ui.files.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Toolbar extends HBox {

    public Toolbar(Stage stage, Customer customer) {

        // Set preferred height and background color
        setPrefHeight(50);
        SizedBox sizedBox1 = new SizedBox(370, 30);

        // Adjust image size as needed
        Image logoImage = new Image("Images/profileicon.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(70);
        logoImageView.setPreserveRatio(true);

        // Wrap the ImageView inside a Button to make it clickable
        Button logoButton = new Button();
        logoButton.setGraphic(logoImageView); // Set the image as the graphic of the button
        logoButton.setStyle("-fx-background-color: transparent;"); // Remove button background
        logoButton.setPadding(new Insets(0)); // Remove padding around the button

        // Set the onAction event for the button
        logoButton.setOnAction(event -> {
            AcountViewScreen acountViewScreen = new AcountViewScreen(stage,customer);
            stage.getScene().setRoot(acountViewScreen.getRoot());
            stage.setFullScreen(true);
        });

        Label userName = new Label(customer.getUsername());
        userName.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: black;");
        userName.setWrapText(true); // Enable text wrapping

        // Adjust spacer size if needed
        SizedBox sizedBox2 = new SizedBox(70, 30);

        Label websiteLabel = new Label("The Market");
        websiteLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: black;");
        websiteLabel.setWrapText(true);  // Enable text wrapping

        SizedBox sizedBox3 = new SizedBox(40, 30);

        ConfirmButton viewOrdersButton = new ConfirmButton("My Orders");
        viewOrdersButton.setOnAction(e->{
            OrdersPage ordersPage = new OrdersPage(customer,stage);
            stage.getScene().setRoot(ordersPage.getRoot());
            stage.setFullScreen(true);
        });


        SizedBox sizedBox4 = new SizedBox(30, 30);
        ConfirmButton cartButton = new ConfirmButton("My Cart");
        cartButton.setOnAction(e->{
            CartPage cartPage = new CartPage(customer,stage);
            stage.getScene().setRoot(cartPage.getRoot());
            stage.setFullScreen(true);
        });


        this.setPadding(new Insets(20, 0, 0, 0));
        this.setAlignment(Pos.CENTER);

        getChildren().addAll(

                logoButton,  // Use the logoButton instead of the ImageView
                userName,
                sizedBox2,
                websiteLabel,
                sizedBox3,
                viewOrdersButton,
                sizedBox4,
                cartButton
        );
    }



    public Toolbar(Stage stage, Customer customer,String color) {

        // Set preferred height and background color
        setPrefHeight(50);
        SizedBox sizedBox1 = new SizedBox(370, 30);

        // Adjust image size as needed
        Image logoImage = new Image("Images/profileicon.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(70);
        logoImageView.setPreserveRatio(true);

        // Wrap the ImageView inside a Button to make it clickable
        Button logoButton = new Button();
        logoButton.setGraphic(logoImageView); // Set the image as the graphic of the button
        logoButton.setStyle("-fx-background-color: transparent;"); // Remove button background
        logoButton.setPadding(new Insets(0)); // Remove padding around the button

        // Set the onAction event for the button
        logoButton.setOnAction(event -> {
            AcountViewScreen acountViewScreen = new AcountViewScreen(stage,customer);
            stage.getScene().setRoot(acountViewScreen.getRoot());
            stage.setFullScreen(true);
        });

        Label userName = new Label(customer.getUsername());
        userName.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: black;");
        userName.setWrapText(true); // Enable text wrapping

        // Adjust spacer size if needed
        SizedBox sizedBox2 = new SizedBox(70, 30);

        Label websiteLabel = new Label("The Market");
        websiteLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: black;");
        websiteLabel.setWrapText(true);  // Enable text wrapping

        SizedBox sizedBox3 = new SizedBox(40, 30);

        ConfirmButton viewOrdersButton = new ConfirmButton("My Orders");
        viewOrdersButton.setOnAction(e->{
            OrdersPage ordersPage = new OrdersPage(customer,stage);
            stage.getScene().setRoot(ordersPage.getRoot());
            stage.setFullScreen(true);
        });


        SizedBox sizedBox4 = new SizedBox(30, 30);
        ConfirmButton cartButton = new ConfirmButton("My Cart");
        cartButton.setOnAction(e->{
            CartPage cartPage = new CartPage(customer,stage);
            stage.getScene().setRoot(cartPage.getRoot());
            stage.setFullScreen(true);
        });

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefHeight(100);
        //this.setStyle("-fx-background-color:"+color+ ";");
        this.setAlignment(Pos.CENTER);

        getChildren().addAll(

                logoButton,  // Use the logoButton instead of the ImageView
                userName,
                sizedBox2,
                websiteLabel,
                sizedBox3,
                viewOrdersButton,
                sizedBox4,
                cartButton
        );
    }
}
