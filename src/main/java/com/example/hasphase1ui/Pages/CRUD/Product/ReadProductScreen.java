package com.example.hasphase1ui.Pages.CRUD.Product;

import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ReadProductScreen {
    private Stage stage;
    private Admin admin;
    public ReadProductScreen(Stage stage, Admin admin){
        this.stage=stage;
        this.admin=admin;
    }
    public VBox getRoot(){
        VBox readProductView = new VBox(30);

        readProductView.setBackground(PagesBackground.getBackground());

        SizedBox sizedBox = new SizedBox(20,30);

        HBox titleLabel =new HBox();
        CustomLabel title = new  CustomLabel("Read Product",40,"-fx-font-weight: bold;");
        titleLabel.getChildren().add(title);
        titleLabel.setAlignment(Pos.CENTER);

        SizedBox sizedBox1 = new SizedBox(20,100);

        HBox textFeildHbox = new HBox(20);
        textFeildHbox.setAlignment(Pos.CENTER);
        CustomTextField customTextField = new CustomTextField("Enter Product Name");
        textFeildHbox.getChildren().addAll(customTextField);
        customTextField.setMaxSize(150,30);

        ConfirmButton readButton = new ConfirmButton("Search For Product");
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
            Product product = admin.readProduct(customTextField.getText());
        if(product==null){
            Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Please enter a valid product name");
        }
        else {
            EditProductScreen editProductScreen = new EditProductScreen(stage,product,admin);
            stage.getScene().setRoot(editProductScreen.getRoot());
            stage.setFullScreen(true);
        }
        } );
        readProductView.setAlignment(Pos.CENTER);
        readProductView.getChildren().addAll(sizedBox,titleLabel,sizedBox1,textFeildHbox,backHbox);
        return  readProductView;
    }
}
