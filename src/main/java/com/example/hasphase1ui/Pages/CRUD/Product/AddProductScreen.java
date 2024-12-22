package com.example.hasphase1ui.Pages.CRUD.Product;
import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.ProductAttributes.CategorySelector;
import com.example.hasphase1ui.ProductAttributes.ProductAttribute;
import com.example.hasphase1ui.files.*;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddProductScreen {
    private Stage stage;
    private Admin admin;

    public AddProductScreen(Stage stage,Admin admin) {
        this.stage = stage;
        this.admin=admin;

    }

    public ScrollPane getRoot() {

        VBox productInfo = new VBox(30);


        productInfo.setBackground(PagesBackground.getBackground());


        SizedBox sizedBox = new SizedBox();

        HBox titleLabel = new HBox();
        CustomLabel title = new CustomLabel("Add Product", 40, "-fx-font-weight: bold;");
        titleLabel.getChildren().add(title);
        titleLabel.setAlignment(Pos.CENTER);

        // Product input fields
        ProductAttribute productName = new ProductAttribute("Product Name");
        ProductAttribute productImageUrl = new ProductAttribute("Product Image Url");
        ProductAttribute productPrice = new ProductAttribute("Product Price");
        ProductAttribute productStock = new ProductAttribute("Product Stock");

        CategorySelector categorySelector = new CategorySelector(null);

        ConfirmButton addProductButton = new ConfirmButton("Add Product");
        ConfirmButton backButton = new ConfirmButton("Go Back");

        backButton.setOnAction(e ->{
            AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
            stage.getScene().setRoot(adminHomeScreen.getRoot());
            stage.setFullScreen(true);
        } );

        HBox buttonHbox = new HBox(20);
        buttonHbox.setAlignment(Pos.CENTER);
        buttonHbox.getChildren().addAll(backButton, addProductButton);

        ScrollPane scrollablePane = new ScrollPane(productInfo);
        scrollablePane.setFitToWidth(true);
        scrollablePane.setFitToHeight(true);

        productInfo.getChildren().addAll( sizedBox, titleLabel, productName, productImageUrl, productPrice, productStock, categorySelector, buttonHbox);

        // Event handler for the Add Product button
        addProductButton.setOnAction(e -> {
            // Retrieve values from text fields
            String nameValue = productName.getText();
            String imageUrlValue = productImageUrl.getText();
            String priceText = productPrice.getText();
            String stockText = productStock.getText();
            Category selectedCategory = admin.readCategory(categorySelector.getSelectedCategory());

            if (nameValue.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Name cannot be empty.");
            } else if (imageUrlValue.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Image URL cannot be empty.");
            } else if (priceText.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Price cannot be empty.");
            } else if (stockText.isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Stock cannot be empty.");
            } else if (!Validations.isValidDouble(priceText)) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Price must be a valid number.");
            } else if (!Validations.isValidInt(stockText)) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Product Stock must be a valid Int.");
            } else  {
                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(stockText);
                Product product = new Product(nameValue,selectedCategory,price,stock,imageUrlValue);
                admin.createProduct(product);
                product.setCategory(selectedCategory);
                Validations.showAlert(AlertType.CONFIRMATION, "Success", "Product added successfully!");
            }
        });
        return  scrollablePane;
    }




}
