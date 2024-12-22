package com.example.hasphase1ui.UserInfos;

import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.CustomTextField;
import com.example.hasphase1ui.widgets.Validations;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

public class AddressAttribute extends HBox {


    public AddressAttribute(Customer customer) {
        this.setSpacing(10);

        CustomLabel customLabel = new CustomLabel("   Address : ");

        // Create the CustomTextField
        CustomTextField customTextField = new CustomTextField(customer.getAddress());

        // Create the ConfirmButton
        ConfirmButton confirmButton = new ConfirmButton("Change Address");

        // Add the OnAction event handler for the confirm button
        confirmButton.setOnAction(e -> {
            if (customTextField.getText().isEmpty()) {
                Validations.showAlert(AlertType.ERROR, "Input Error", "Address cannot be empty.");
            } else {
                customer.setAddress(customTextField.getText());
                Validations.showAlert(AlertType.INFORMATION, "Success", "Address updated successfully.");
            }
        });

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel, customTextField, confirmButton);
    }


}
