package com.example.hasphase1ui.Pages.CategoriesProducts;


import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.Product;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ProductItem extends HBox {

    public ProductItem(Customer customer, Product product) {

        this.setSpacing(40);
        this.setPadding(new Insets(10));
        this.setBackground(new Background(new BackgroundFill(
                Color.web("#b2bfba"), // Off-white color
                new CornerRadii(15), // Rounded corners with 15px radius
                null // Insets (null means no additional padding for the background)
        )));


        ImageView productImage = new ImageView();

        try {
            productImage.setImage(new Image(product.getProductImageUrl()));
        } catch (Exception e) {
            System.out.println("Image not found: " + product.getProductImageUrl()); // Log error
            productImage.setImage(new Image("/Images/default_image (2).jpeg")); // Default image if not found
        }

        productImage.setFitWidth(120);
        productImage.setFitHeight(120);

        VBox productDetails = new VBox();
        productDetails.setSpacing(7);

        Label productName = new Label(product.getName());
        Label productPrice = new Label("Price: LE: " + product.getPrice());
        Label productID = new Label("Product ID: " + product.getId());

        productName.setStyle(" -fx-font-size:20px;-fx-text-fill: black;-fx-font-weight: bold;");
        productPrice.setStyle("-fx-font-size:15px; -fx-text-fill: #3CB371");
        productID.setStyle("-fx-text-fill: black; -fx-font-size:15px;");

        Button addToCartButton = new Button("Add To Cart");


        addToCartButton.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;-fx-background-color: #3CB371; -fx-background-radius:20px; -fx-text-fill: white; " +
                "-fx-padding: 10px 10px; -fx-border-color: transparent; -fx-border-width: 2px; -fx-border-radius: 20px;");

        addToCartButton.setOnAction(e -> {
            customer.addToCart(product);
            addToCartButton.setText("Added");
            addToCartButton.setDisable(true); // Optional: Disable button after adding


        });

        productDetails.getChildren().addAll(productName,productID, productPrice);

        HBox buttonContainer = new HBox(addToCartButton);
        buttonContainer.setSpacing(6);

        // Add details and buttons to the main item layout
        VBox combinedDetails = new VBox(productDetails, buttonContainer);
        combinedDetails.setSpacing(6);

        this.getChildren().addAll(productImage,combinedDetails);

    }
}
