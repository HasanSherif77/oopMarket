package com.example.hasphase1ui.Pages.CategoriesProducts;


import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.CategoryCRUD;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.Database;
import com.example.hasphase1ui.widgets.PagesBackground;
import com.example.hasphase1ui.widgets.Toolbar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CategoriesPage {
    private CategoryCRUD categoryCRUD = new CategoryCRUD();
    private Stage primaryStage;
    private Customer customer;


    public CategoriesPage(Stage primaryStage, Customer customer){
        this.primaryStage=primaryStage;
        this.customer=customer;


    }

    public VBox getRoot() {
        // Main Layout
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(30));
        mainLayout.setSpacing(10);
        mainLayout.setBackground(PagesBackground.getBackground());
        mainLayout.setAlignment(Pos.CENTER);

        // Toolbar
        Toolbar toolBar = new Toolbar(primaryStage,customer);
        toolBar.setAlignment(Pos.CENTER);
        mainLayout.getChildren().add(toolBar); // Add the toolbar

        // Header
        HBox headerLayout = new HBox();
        headerLayout.setAlignment(Pos.CENTER);
        headerLayout.setSpacing(10);

        Label headerLabel = new Label("Categories List");
        headerLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: black;");
        headerLayout.getChildren().add(headerLabel);

        // ScrollPane for categories
        ScrollPane scrollPane = new ScrollPane();
        VBox categoryList = createCategoryList(); // Create the category list
        scrollPane.setContent(categoryList);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(700);
        scrollPane.setMinWidth(300);
        scrollPane.setMaxWidth(500);
        scrollPane.setStyle("-fx-background: transparent; -fx-border-color: transparent;");



        mainLayout.getChildren().addAll(headerLayout, scrollPane);

        primaryStage.setMaximized(true);


        return mainLayout;
    }

    private VBox createCategoryList() {
        VBox categoryList = new VBox();
        categoryList.setSpacing(10);
        categoryList.setPadding(new Insets(10));

        for (Category category : Database.getCategories()) {
            CategoryItem categoryItem = new CategoryItem(primaryStage, category, customer);
            categoryList.getChildren().add(categoryItem);
        }

        return categoryList;
    }


}
