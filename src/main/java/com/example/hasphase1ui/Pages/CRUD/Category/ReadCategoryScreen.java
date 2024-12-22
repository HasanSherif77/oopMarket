package com.example.hasphase1ui.Pages.CRUD.Category;

import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.Pages.CRUD.Product.EditProductScreen;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReadCategoryScreen {
    private Stage stage;
    private Admin admin;
    public ReadCategoryScreen(Stage stage, Admin admin){
        this.stage=stage;
        this.admin=admin;
    }
    public VBox getRoot(){
        VBox readCategoryView = new VBox(30);

        readCategoryView.setBackground(PagesBackground.getBackground());

        SizedBox sizedBox = new SizedBox(20,30);

        HBox titleLabel =new HBox();
        CustomLabel title = new  CustomLabel("Read Category",40,"-fx-font-weight: bold;");
        titleLabel.getChildren().add(title);
        titleLabel.setAlignment(Pos.CENTER);

        SizedBox sizedBox1 = new SizedBox(20,100);

        HBox textFeildHbox = new HBox(20);
        textFeildHbox.setAlignment(Pos.CENTER);
        CustomTextField customTextField = new CustomTextField("Enter Category Name");
        textFeildHbox.getChildren().addAll(customTextField);
        customTextField.setMaxSize(150,30);

        ConfirmButton readButton = new ConfirmButton("Search For Category");
        ConfirmButton backButton =new ConfirmButton("Go Back");
        HBox backHbox = new HBox(20);
        backHbox.getChildren().addAll(backButton,readButton);
        backHbox.setAlignment(Pos.CENTER);

        backButton.setOnAction(e ->{
            AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
            stage.getScene().setRoot(adminHomeScreen.getRoot());
            stage.setFullScreen(true);
        } );

        readButton.setOnAction(e ->{
            Category category = admin.readCategory(customTextField.getText());
            if(category==null){
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Please enter a valid category name");
            }
            else {
                EditCategoryScreen editCategoryScreen = new EditCategoryScreen(stage,category,admin);
                stage.getScene().setRoot(editCategoryScreen.getRoot());
                stage.setFullScreen(true);
            }
        } );
        readCategoryView.setAlignment(Pos.CENTER);
        readCategoryView.getChildren().addAll(sizedBox,titleLabel,sizedBox1,textFeildHbox,backHbox);
        return readCategoryView;
    }
}

