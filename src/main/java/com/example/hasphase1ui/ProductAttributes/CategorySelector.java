package com.example.hasphase1ui.ProductAttributes;

import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Database;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.SizedBox;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class CategorySelector extends HBox {
    private ComboBox<String> categorySelectorBox; // Class-level field to store ComboBox
    private static ArrayList<Category> categories = Database.getCategories();

    public CategorySelector(Category category) {

        categorySelectorBox = new ComboBox<>();
        for (Category category1 : categories)
        {
            categorySelectorBox.getItems().add(category1.getCategoryName());
        }
        categorySelectorBox.setValue(category == null ? categories.getFirst().getCategoryName() : category.getCategoryName()); // Set the initial text
        categorySelectorBox.setPrefHeight(30); // Set the initial collapsed height
        categorySelectorBox.setStyle(
                "-fx-pref-width: 200px; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 5px;" +
                        "-fx-background-color: rgba(64, 64, 64, 0.8);" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: white;" +
                        "-fx-border-color: #555;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-padding: 5px;");

        // Add event handler to expand or collapse the ComboBox when clicked
        categorySelectorBox.setOnAction(event -> {
            if (!categorySelectorBox.isShowing()) {
                categorySelectorBox.show(); // Expand the ComboBox
            } else {
                categorySelectorBox.hide(); // Collapse the ComboBox
            }
        });

        SizedBox sizedBox = new SizedBox(20, 20);

        CustomLabel categoryLabel = new CustomLabel("Category:    ");

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(categoryLabel, categorySelectorBox, sizedBox);
    }

    // Method to retrieve the selected category text
    public String getSelectedCategory() {
        return categorySelectorBox.getValue();
    }
}
