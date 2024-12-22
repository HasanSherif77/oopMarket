package com.example.hasphase1ui.UserInfos;

import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.CustomTextField;
import com.example.hasphase1ui.widgets.Validations;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;

public class BalanceAttribute extends HBox {

    private double balance;

    public BalanceAttribute(Customer customer){

        this.setSpacing(10);

        CustomLabel customLabel = new CustomLabel("   Balance : ");


        CustomTextField customTextField = new CustomTextField(""+customer.getBalance());

        ConfirmButton confirmButton = new ConfirmButton("Change Balance");

        confirmButton.setOnAction(e -> {
            if (customTextField.getText().isEmpty()) {
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Balance cannot be empty.");
            } else if (!Validations.isValidDouble(customTextField.getText())) {
                Validations.showAlert(Alert.AlertType.ERROR, "Input Error", "Balance must be a valid number.");
            } else {
                double newBalance = Double.parseDouble(customTextField.getText());
                customer.setBalance(newBalance);
                Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Balance updated successfully.");
            }
        });

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel,customTextField,confirmButton);


    }
}
