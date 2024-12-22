package com.example.hasphase1ui.Pages.CRUD.Category;

import com.example.hasphase1ui.CategoryAttributes.CategoryImageUrl;
import com.example.hasphase1ui.CategoryAttributes.CategoryName;
import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.PagesBackground;
import com.example.hasphase1ui.widgets.Validations;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddCategoryPage {
    private Stage stage;
    private Admin admin;
    public AddCategoryPage(Stage stage, Admin admin){
        this.stage=stage;
        this.admin=admin;
    }
    public VBox getRoot(){
        VBox addCategory = new VBox(40);
        addCategory.setAlignment(Pos.CENTER);
        addCategory.setBackground(PagesBackground.getBackground());
        CategoryName categoryName = new CategoryName();
        CategoryImageUrl categoryImageUrl= new CategoryImageUrl();

        ConfirmButton confirmButton = new ConfirmButton("Add Category");
        confirmButton.setOnAction(e->{
            if (categoryName.getText().isEmpty()||categoryImageUrl.getText().isEmpty()) {
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill all feilds.");
            } else {
                admin.addCategory(new Category(categoryName.getText(),categoryImageUrl.getText()));
                Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Category added successfully.");
                AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
                stage.getScene().setRoot(adminHomeScreen.getRoot());
                stage.setFullScreen(true);
            }
        });
        ConfirmButton backButton = new ConfirmButton("Go back");
        backButton.setOnAction(e->{
            AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
            stage.getScene().setRoot(adminHomeScreen.getRoot());
        });
        HBox buttonHbox = new HBox(backButton,confirmButton);
        buttonHbox.setSpacing(40);
        buttonHbox.setAlignment(Pos.CENTER);

        addCategory.getChildren().addAll(categoryName,categoryImageUrl,buttonHbox);

        return addCategory;
    }
}
