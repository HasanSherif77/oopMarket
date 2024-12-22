package com.example.hasphase1ui.CategoryAttributes;

import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Database;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.SizedBox;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class CategoryProductsSelector extends HBox {
    private ComboBox<String> productSelectorBox;

    public CategoryProductsSelector(Category category) {

        CustomLabel categoryLabel = new CustomLabel("Category:    ");

        productSelectorBox = new ComboBox<>();
        for (Product product : Database.getCategoryProducts(category))
        {
            productSelectorBox.getItems().add(product.getName());
        }
        productSelectorBox.setValue(Database.getCategoryProducts(category).isEmpty()? "Category is Empty" : Database.getCategoryProducts(category).get(0).getName());
        productSelectorBox.setPrefHeight(30); // Set the initial collapsed height
        productSelectorBox.setStyle(
                "-fx-pref-width: 200px; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 5px;" +
                        "-fx-background-color: rgba(64, 64, 64, 0.8);" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: white;" +
                        "-fx-border-color: #555;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-padding: 5px;");

        productSelectorBox.setOnAction(event -> {
            if (!productSelectorBox.isShowing()) {
                productSelectorBox.show(); // Expand the ComboBox
            } else {
                productSelectorBox.hide(); // Collapse the ComboBox
            }
        });

        SizedBox sizedBox = new SizedBox(20, 20);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(categoryLabel, productSelectorBox, sizedBox);
    }

    // Method to retrieve the selected category text
    public String getSelectedCategory() {
        return productSelectorBox.getValue();
    }
}
