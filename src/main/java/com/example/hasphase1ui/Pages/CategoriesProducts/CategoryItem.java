package com.example.hasphase1ui.Pages.CategoriesProducts;

import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Customer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CategoryItem extends HBox {


    public CategoryItem(Stage primaryStage, Category category, Customer customer) {

        this.setSpacing(40);
        this.setPadding(new Insets(10));

        // Set item style
        this.setBackground(new Background(new BackgroundFill(
                Color.web("#b2bfba"), // Off-white color
                new CornerRadii(15), // Rounded corners with 15px radius
                null // Insets (null means no additional padding for the background)
        )));

        ImageView categoryImage = new ImageView();

        try {
            categoryImage.setImage(new Image(category.getCategoryImage()));
        } catch (Exception e) {
            System.err.println("Image not found: " + category.getCategoryImage()); // Log error
            categoryImage.setImage(new Image("/Images/default_image (2).jpeg")); // Default image if not found
        }

        categoryImage.setFitWidth(120);
        categoryImage.setFitHeight(120);

        VBox categoryDetails = new VBox();
        categoryDetails.setSpacing(7);

        Label categoryName = new Label(category.getCategoryName());
        categoryName.setStyle(" -fx-text-fill: black; -fx-font-size:20px; -fx-font-weight: bold;");


        Button viewProductsButton = new Button("View Products");

        // Add CSS styles to buttons
        viewProductsButton.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;-fx-background-color: #3CB371; -fx-background-radius:20px; -fx-text-fill: white; " +
                "-fx-padding: 10px 10px; -fx-border-color: transparent; -fx-border-width: 2px; -fx-border-radius: 20px;");

        // Event Handler for View Products button
        viewProductsButton.setOnAction(e -> {
            ProductsPage productsPage = new ProductsPage(primaryStage, customer,category); // Create an instance of ProductsPage
            primaryStage.getScene().setRoot(productsPage.getRoot());// Switch to ProductsPage scene
            primaryStage.setMaximized(true);
            primaryStage.setFullScreen(true);

        });

        categoryDetails.getChildren().addAll(categoryName);
        HBox buttonContainer = new HBox(viewProductsButton);
        buttonContainer.setSpacing(6); // Space between buttons

        // Add details and buttons to the main item layout
        VBox combinedDetails = new VBox(categoryDetails, buttonContainer);
        combinedDetails.setSpacing(6); // Space between details and buttons

        this.getChildren().addAll(categoryImage, combinedDetails);


    }
}
