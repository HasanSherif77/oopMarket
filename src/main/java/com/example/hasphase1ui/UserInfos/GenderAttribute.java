package com.example.hasphase1ui.UserInfos;

import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.Gender;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.Validations;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class GenderAttribute extends HBox {
    private Gender gender;
    public GenderAttribute(Customer customer){
        this.setSpacing(10);

        CustomLabel customLabel = new CustomLabel("   Gender : ");


        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);



        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);

        if (customer.getGender().equals(Gender.Male)){
            maleRadio.setSelected(true);  // Default to Male
        }
        else {
            femaleRadio.setSelected(true);
        }


        ConfirmButton confirmButton = new ConfirmButton("Change Gender");

        confirmButton.setOnAction(e -> {
            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            customer.setGender(selectedGender.getText().equals("Male") ? Gender.Male : Gender.Female);
            Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "You are now a " +customer.getGender());

        });

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel,maleRadio,femaleRadio,confirmButton);


    }
}
