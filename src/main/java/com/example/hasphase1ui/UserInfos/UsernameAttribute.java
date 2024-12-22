package com.example.hasphase1ui.UserInfos;

import com.example.hasphase1ui.Pages.AcountViewScreen;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.User;
import com.example.hasphase1ui.files.UsersEditor;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.CustomTextField;
import com.example.hasphase1ui.widgets.Validations;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UsernameAttribute extends HBox {
    private UsersEditor usersEditor=new UsersEditor();



    public UsernameAttribute(Stage stage, Customer customer) {

        this.setSpacing(10);

        CustomLabel customLabel = new CustomLabel("   Username : ");

        CustomTextField customTextField = new CustomTextField(customer.getUsername());

        ConfirmButton confirmButton = new ConfirmButton("Change Username");

        confirmButton.setOnAction(e -> {
            if (customTextField.getText().isEmpty()) {
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Username cannot be empty.");
            } else if (Validations.checkUsername(customTextField.getText())){
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Username already exists!");
            } else {
                customer.setUsername(customTextField.getText());
                Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Username updated successfully.");
                AcountViewScreen acountViewScreen= new AcountViewScreen(stage,customer);
                stage.getScene().setRoot(acountViewScreen.getRoot());
            }
        });

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel, customTextField, confirmButton);
    }


    public UsernameAttribute(Stage stage,Admin admin) {

        this.setSpacing(10);

        CustomLabel customLabel = new CustomLabel("   Username : ");

        CustomTextField customTextField = new CustomTextField(admin.getUsername());

        ConfirmButton confirmButton = new ConfirmButton("Change Username");

        confirmButton.setOnAction(e -> {
            if (customTextField.getText().isEmpty()) {
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Username cannot be empty.");
            } else if (Validations.checkUsername(customTextField.getText())){
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Username already exists!");

            }
            else {
                admin.setUsername(customTextField.getText());
                Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Username updated successfully.");
                AcountViewScreen acountViewScreen= new AcountViewScreen(stage,admin);
                stage.getScene().setRoot(acountViewScreen.getRoot());
            }
        });

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel, customTextField, confirmButton);
    }



}
