package com.example.hasphase1ui.Pages.CategoriesProducts;
import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.Database;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.PagesBackground;
import com.example.hasphase1ui.widgets.Toolbar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ProductsPage {

    private Customer customer;
    private Stage primaryStage;
    private Category category;

    public ProductsPage(Stage primaryStage, Customer customer,Category category){
        this.primaryStage=primaryStage;
        this.customer=customer;
        this.category=category;

    }


    public VBox getRoot() {

        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(30));
        mainLayout.setSpacing(10);


        Toolbar toolBar = new Toolbar(primaryStage,customer);
        mainLayout.getChildren().add(toolBar);


        HBox headerLayout = new HBox();
        headerLayout.setAlignment(Pos.CENTER);
        headerLayout.setSpacing(10);

        Label headerLabel = new Label("Products List");
        headerLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: black;");

        headerLayout.getChildren().add(headerLabel);


        ScrollPane scrollPane = new ScrollPane();
        VBox productList = createProductList(category); // Create the product list
        scrollPane.setContent(productList);
        scrollPane.setFitToWidth(true);
        scrollPane.setMinWidth(250);
        scrollPane.setMaxWidth(500);
        scrollPane.setPrefHeight(900);
        scrollPane.setStyle("-fx-background: transparent; -fx-border-color: transparent;");


        HBox actionLayout = new HBox();
        actionLayout.setSpacing(10);

        Button backButton = new Button("Back");

        backButton.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;-fx-background-color: #3CB371; -fx-background-radius:20px; " +
                "-fx-text-fill: white; -fx-padding: 10px 10px; -fx-border-color: transparent; -fx-border-width: 2px; -fx-border-radius: 20px;");

        backButton.setOnAction(e->{
            CategoriesPage categoriesPage = new CategoriesPage(primaryStage, customer);
            primaryStage.getScene().setRoot(categoriesPage.getRoot());
            primaryStage.setMaximized(true);
            primaryStage.setFullScreen(true);
        });
        mainLayout.setBackground(PagesBackground.getBackground());
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(headerLayout, scrollPane, actionLayout,backButton);
        primaryStage.setMaximized(true);

        return mainLayout;
    }

    private VBox createProductList(Category category) {
        VBox productList = new VBox();
        productList.setSpacing(10);
        productList.setPadding(new Insets(10));


        for (Product product : Database.getCategoryProducts(category)) {

            ProductItem productItem = new ProductItem(customer,product);
            productList.getChildren().add(productItem);
        }

        return productList;
    }

}
