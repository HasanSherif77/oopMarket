package com.example.hasphase1ui.UserInfos;

import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.CustomTextField;
import com.example.hasphase1ui.widgets.Validations;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;

public class PasswordAttribute extends HBox {
    public PasswordAttribute(Customer customer) {

        this.setSpacing(10);

        CustomLabel customLabel = new CustomLabel("   Password  :");


        CustomTextField customTextField = new CustomTextField(customer.getPassword());

        ConfirmButton confirmButton = new ConfirmButton("Change Password");

        confirmButton.setOnAction(e -> {
            if (customTextField.getText().isEmpty()) {
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Password cannot be empty.");
            }
            else {
                customer.setPassword(customTextField.getText());
                Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Password updated successfully.");
            }
        });


        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel, customTextField, confirmButton);
    }

    public PasswordAttribute(Admin admin) {

        this.setSpacing(10);

        CustomLabel customLabel = new CustomLabel("   Password  :");


        CustomTextField customTextField = new CustomTextField(admin.getPassword());

        ConfirmButton confirmButton = new ConfirmButton("Change Password");

        confirmButton.setOnAction(e -> {
            if (customTextField.getText().isEmpty()) {
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Password cannot be empty.");
            }
            else {
                admin.setPassword(customTextField.getText());
                Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Password updated successfully.");
            }
        });
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel, customTextField, confirmButton);
    }
}

