package com.example.hasphase1ui.Pages.CRUD.Category;

import com.example.hasphase1ui.CategoryAttributes.CategoryProductsSelector;
import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.ProductAttributes.CategorySelector;
import com.example.hasphase1ui.ProductAttributes.ProductAttribute;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditCategoryScreen {

    private Stage stage;
    private Category category;
    private Admin admin;

    public EditCategoryScreen(Stage stage,Category category,Admin admin){
        this.stage=stage;
        this.category=category;
        this.admin=admin;
    }

    public ScrollPane getRoot() {
        VBox editCategoryRoot = new VBox(25);
        editCategoryRoot.setBackground(PagesBackground.getBackground());

        HBox titleLabel = new HBox();
        CustomLabel title = new CustomLabel("Edit Category", 40, "-fx-font-weight: bold;");
        titleLabel.getChildren().add(title);
        titleLabel.setAlignment(Pos.CENTER);

        ConfirmButton nameConfirmButton = new ConfirmButton("Confirm");
        ProductAttribute categoryName = new ProductAttribute("Category Name", category.getCategoryName());
        categoryName.getChildren().add(nameConfirmButton);

        ConfirmButton imageUrlConfirmButton = new ConfirmButton("Confirm");
        ProductAttribute categoryImageUrl = new ProductAttribute("Category Image Url", category.getCategoryImage());
        categoryImageUrl.getChildren().add(imageUrlConfirmButton);

        CategoryProductsSelector categoryProductsSelector= new CategoryProductsSelector(category);
        ConfirmButton deleteProduct = new ConfirmButton("Remove Product");
        categoryProductsSelector.getChildren().add(deleteProduct);

        deleteProduct.setOnAction(e -> {
            Product selectedProduct = admin.readProduct(categoryProductsSelector.getSelectedCategory());
            selectedProduct.setCategory(null);
            EditCategoryScreen editCategoryScreen = new EditCategoryScreen(stage, category, admin);
            stage.getScene().setRoot(editCategoryScreen.getRoot());
        });

        CustomLabel addProduct = new CustomLabel("Add Product To Category");
        CustomTextField productName = new CustomTextField("Enter product to add");
        ConfirmButton addButton = new ConfirmButton("Add Product");
        HBox productAdder = new HBox(30);
        productAdder.getChildren().addAll(addProduct,productName,addButton);
        productAdder.setAlignment(Pos.CENTER);
        addButton.setOnAction(e->{
            Product product =admin.readProduct(productName.getText());
            if (product==null){
                Validations.showAlert(Alert.AlertType.ERROR, "Fail", "Enter Valid Product Name");
            }else {
                product.setCategory(category);
                Validations.showAlert(Alert.AlertType.ERROR, "Success", "Product Added successfully.");
                EditCategoryScreen editCategoryScreen = new EditCategoryScreen(stage,category,admin);
                stage.getScene().setRoot(editCategoryScreen.getRoot());
            }
        });

        SizedBox sizedBox = new SizedBox(20, 60);

        ConfirmButton backButton = new ConfirmButton("Go Back");
        HBox backHbox = new HBox(30);
        backHbox.setAlignment(Pos.CENTER);
        backButton.setOnAction(e ->{
            ReadCategoryScreen readCategoryScreen = new ReadCategoryScreen(stage,admin);
            stage.getScene().setRoot(readCategoryScreen.getRoot());
            stage.setFullScreen(true);
        } );

        ConfirmButton deleteButton = new ConfirmButton("Delete Category");
        deleteButton.setOnAction(e ->{
            admin.deleteCategory(category);
            Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Category deleted successfully.");
            AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
            stage.getScene().setRoot(adminHomeScreen.getRoot());
            stage.setFullScreen(true);
        } );

        backHbox.getChildren().addAll(backButton, deleteButton);


        ScrollPane scrollablePane = new ScrollPane(editCategoryRoot);
        scrollablePane.setFitToWidth(true);
        scrollablePane.setFitToHeight(true);

        editCategoryRoot.getChildren().addAll( sizedBox, titleLabel,categoryName,
                categoryImageUrl,categoryProductsSelector,
                 productAdder,backHbox);



        return scrollablePane;
    }
}
