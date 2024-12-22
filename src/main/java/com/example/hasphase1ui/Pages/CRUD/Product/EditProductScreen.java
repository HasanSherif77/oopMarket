package com.example.hasphase1ui.Pages.CRUD.Product;

import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.ProductAttributes.CategorySelector;
import com.example.hasphase1ui.ProductAttributes.ProductAttribute;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EditProductScreen {
    private Stage stage;
    private Product product;
    Admin admin;

    public EditProductScreen(Stage stage, Product product,Admin admin) {
        this.stage = stage;
        this.product = product;
        this.admin=admin;
    }

    public ScrollPane getRoot() {
        VBox editProductsScene = new VBox(25);

        editProductsScene.setBackground(PagesBackground.getBackground());




        SizedBox sizedBox = new SizedBox(20, 60);

        HBox titleLabel = new HBox();
        CustomLabel title = new CustomLabel("Edit Product", 40, "-fx-font-weight: bold;");
        titleLabel.getChildren().add(title);
        titleLabel.setAlignment(Pos.CENTER);

        // Confirm buttons for each product attribute
        ConfirmButton nameConfirmButton = new ConfirmButton("Confirm");
        ConfirmButton priceConfirmButton = new ConfirmButton("Confirm");
        ConfirmButton stockConfirmButton = new ConfirmButton("Confirm");
        ConfirmButton imageUrlConfirmButton = new ConfirmButton("Confirm");
        ConfirmButton categoryConfirmButton = new ConfirmButton("Confirm");

        // Product input fields
        ProductAttribute productName = new ProductAttribute("Product Name", product.getName());
        productName.getChildren().add(nameConfirmButton);

        ProductAttribute productPrice = new ProductAttribute("Product Price", String.valueOf(product.getPrice()));
        productPrice.getChildren().add(priceConfirmButton);

        ProductAttribute productStock = new ProductAttribute("Product Stock", String.valueOf(product.getStock()));
        productStock.getChildren().add(stockConfirmButton);

        ProductAttribute productImageUrl = new ProductAttribute("Product Image Url", product.getProductImageUrl());
        productImageUrl.getChildren().add(imageUrlConfirmButton);

        CategorySelector categorySelector = new CategorySelector(product.getCategory());
        categorySelector.getChildren().add(categoryConfirmButton);

        ConfirmButton backButton = new ConfirmButton("Go Back");
        ConfirmButton deleteButton = new ConfirmButton("Delete Product");
        backButton.setOnAction(e ->{
                ReadProductScreen readProductScreen = new ReadProductScreen(stage,admin);
                stage.getScene().setRoot(readProductScreen.getRoot());
                stage.setFullScreen(true);
        } );

        HBox backHbox = new HBox(30);
        backHbox.getChildren().addAll(backButton, deleteButton);
        backHbox.setAlignment(Pos.CENTER);

        // Scroll pane to make the layout scrollable
        ScrollPane scrollablePane = new ScrollPane(editProductsScene);
        scrollablePane.setFitToWidth(true); // Adjust to the width of the screen
        scrollablePane.setFitToHeight(true);

        // Add all elements to the scene
        editProductsScene.getChildren().addAll( sizedBox, titleLabel, productName, productPrice, productStock, productImageUrl, categorySelector, backHbox);

        // Event handlers for confirm buttons with validation
        nameConfirmButton.setOnAction(e -> {
            String nameValue = productName.getText();
            if (nameValue.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Name cannot be empty.");
            } else {
                product.setName(nameValue);
                Validations.showAlert(AlertType.INFORMATION, "Success", "Product Name updated successfully.");
            }
        });

        priceConfirmButton.setOnAction(e -> {
            String priceText = productPrice.getText();
            if (priceText.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Price cannot be empty.");
            } else if (!Validations.isValidDouble(priceText)) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Price must be a valid number.");
            } else {
                double price = Double.parseDouble(priceText);
                product.setPrice(price);
                Validations.showAlert(AlertType.INFORMATION, "Success", "Product Price updated successfully.");
            }
        });

        stockConfirmButton.setOnAction(e -> {
            String stockText = productStock.getText();
            if (stockText.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Stock cannot be empty.");
            } else if (!Validations.isValidInt(stockText)) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Stock must be a valid integer.");
            } else {
                int stock = Integer.parseInt(stockText);
                product.setStock(stock);
                Validations.showAlert(AlertType.INFORMATION, "Success", "Product Stock updated successfully.");
            }
        });


        imageUrlConfirmButton.setOnAction(e -> {
            String imageUrlValue = productImageUrl.getText();
            if (imageUrlValue.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Image URL cannot be empty.");
            } else {
                product.setProductImageUrl(imageUrlValue);
                Validations.showAlert(AlertType.INFORMATION, "Success", "Product Image URL updated successfully.");
            }
        });

        categoryConfirmButton.setOnAction(e -> {
            Category selectedCategory = admin.readCategory(categorySelector.getSelectedCategory());
            product.setCategory(selectedCategory);
            Validations.showAlert(AlertType.INFORMATION, "Success", "Product Category updated successfully.");
        });

        deleteButton.setOnAction(e ->{
            admin.deleteProduct(product);
            Validations.showAlert(AlertType.INFORMATION, "Success", "Product deleted successfully.");
            ReadProductScreen readProductScreen = new ReadProductScreen(stage,admin);
            stage.getScene().setRoot(readProductScreen.getRoot());
            stage.setFullScreen(true);
        } );

        return scrollablePane;
    }


    // Validation method to check if a string is a valid double


    // Helper method to show alert messages

}
