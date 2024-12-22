package com.example.hasphase1ui.Pages.CartOrders;

import com.example.hasphase1ui.Pages.CategoriesProducts.CategoriesPage;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.Order;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.PagesBackground;
import com.example.hasphase1ui.widgets.SizedBox;
import com.example.hasphase1ui.widgets.Toolbar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class OrdersPage {

    private static final double WINDOW_WIDTH = 800;
    private static final double WINDOW_HEIGHT = 600;
    private Customer currentCustomer;
    private Stage stage;

    public OrdersPage(Customer customer, Stage stage) {
        this.currentCustomer = customer;
        this.stage = stage;
    }

    public BorderPane getRoot() {
        BorderPane mainLayout = new BorderPane();
        mainLayout.setBackground(PagesBackground.getBackground());

        Toolbar toolbar = new Toolbar(stage,currentCustomer);
        mainLayout.setTop(toolbar);

        ConfirmButton backButton = new ConfirmButton("Go Back");
        toolbar.getChildren().addFirst(backButton);
        backButton.setOnAction(e->{
            CategoriesPage categoriesPage = new CategoriesPage(stage,currentCustomer);
            stage.getScene().setRoot(categoriesPage.getRoot());
        });


        VBox contentLayout = new VBox(10);
        contentLayout.setAlignment(Pos.TOP_CENTER);
        //contentLayout.setPadding(new Insets(10, 50, 20, 50));

        Label ordersSubheader = new Label("Your Orders");
        ordersSubheader.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        ordersSubheader.setStyle("-fx-text-fill: #000000;");
        ordersSubheader.setAlignment(Pos.CENTER);
        ordersSubheader.setPadding(new Insets(10,0,10,0));

        if (currentCustomer.getCustomerOrders().isEmpty()) {
            Label noOrdersLabel = new Label("No orders yet");
            noOrdersLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
            noOrdersLabel.setStyle("-fx-text-fill: red;");
            noOrdersLabel.setAlignment(Pos.CENTER);
            noOrdersLabel.setPadding(new Insets(150,0,0,0));

            contentLayout.getChildren().addAll(ordersSubheader, noOrdersLabel);
            contentLayout.setAlignment(Pos.TOP_CENTER);
        } else {
            VBox orderList = new VBox(15);
            orderList.setAlignment(Pos.TOP_CENTER);

            for (Order order : currentCustomer.getCustomerOrders()) {
                orderList.getChildren().add(createOrder(order));
            }

            ScrollPane scrollPane = new ScrollPane(orderList);
            scrollPane.setFitToWidth(true);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setStyle(
                    "-fx-background-color: transparent; " +
                            "-fx-border-color: #E0E0E0; " +
                            "-fx-border-radius: 15px; " +
                            "-fx-background-radius: 15px; " +
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 10, 0, 0, 2);"
            );
            scrollPane.setPrefSize(350, 600);
            scrollPane.setMaxSize(350, 600);

            contentLayout.getChildren().addAll(ordersSubheader, scrollPane);
        }

        mainLayout.setCenter(contentLayout);

        return mainLayout;
    }

    private HBox createOrder(Order order) {

        VBox details = new VBox(5);
        details.setAlignment(Pos.CENTER_LEFT);

        Label orderNumberLabel = new Label("Order ID: " + order.getOrderNumber());
        orderNumberLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        orderNumberLabel.setStyle("-fx-text-fill: #424242;");

        String status = order.getPaymentMethod().toString();
        Label statusLabel = new Label("Payment Status: " + status);
        statusLabel.setStyle("-fx-text-fill: #9E9E9E; -fx-font-size: 12px;");






        // Display the total price

        Label productPrice = new Label("Total Price: " + order.getOrderTotal() + " EGP");

        productPrice.setStyle("-fx-text-fill: #3CB371; -fx-font-size: 12px;");


        details.getChildren().addAll(orderNumberLabel, statusLabel, productPrice);


        HBox orderBox = new HBox(details);

        orderBox.setPadding(new Insets(10));

        orderBox.setStyle(

                "-fx-background-color: #FFFFFF; " +

                        "-fx-background-radius: 10px; " +

                        "-fx-border-color: #E0E0E0; " +

                        "-fx-border-radius: 10px; " +

                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 5, 0, 0, 1);"

        );

        orderBox.setAlignment(Pos.CENTER_LEFT);

        orderBox.setMinHeight(60);

        orderBox.setMaxWidth(360);

        return orderBox;
    }
}
