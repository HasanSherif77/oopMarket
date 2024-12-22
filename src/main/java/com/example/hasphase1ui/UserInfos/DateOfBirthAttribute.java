package com.example.hasphase1ui.UserInfos;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.Date;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.Validations;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class DateOfBirthAttribute extends HBox {

    private static final double COLLAPSED_HEIGHT = 30;  // Initial collapsed height for the ComboBox
    private static final double EXPANDED_HEIGHT = 150;  // Height when the ComboBox expands

    private Date dateOfBirth;
    public DateOfBirthAttribute( Customer customer) {
        // Set spacing between elements in the HBox
        this.setSpacing(10);

        // Label for "Date of Birth"
        CustomLabel label  = new CustomLabel("Date of Birth:");

        // Create ComboBoxes for Day, Month, and Year
        ComboBox<String> dayComboBox = createComboBox("Day", ""+customer.getDateOfBirth().getDay(), generateDayList());
        ComboBox<String> monthComboBox = createComboBox("Month", ""+customer.getDateOfBirth().getMonth(), "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        ComboBox<String> yearComboBox = createComboBox("Year", ""+customer.getDateOfBirth().getYear(), generateYearList());

        ConfirmButton confirmButton = new ConfirmButton("Change Birthdate");
        // Add ComboBoxes to the row (HBox)
        this.getChildren().addAll(label, dayComboBox, monthComboBox, yearComboBox,confirmButton);

        // Set row alignment and padding
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-padding: 10px;");

        confirmButton.setOnAction(e -> {
            customer.getDateOfBirth().setDay(Integer.parseInt(dayComboBox.getValue()));
            customer.getDateOfBirth().setMonth(monthComboBox.getValue());
            customer.getDateOfBirth().setYear(Integer.parseInt(yearComboBox.getValue()));
            Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Date of birth updated successfully.");
        });
    }
    public DateOfBirthAttribute( Admin admin) {
        // Set spacing between elements in the HBox
        this.setSpacing(10);

        // Label for "Date of Birth"
        CustomLabel label  = new CustomLabel("Date of Birth:");

        // Create ComboBoxes for Day, Month, and Year
        ComboBox<String> dayComboBox = createComboBox("Day", ""+admin.getDateOfBirth().getDay(), generateDayList());
        ComboBox<String> monthComboBox = createComboBox("Month", ""+admin.getDateOfBirth().getMonth(), "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        ComboBox<String> yearComboBox = createComboBox("Year", ""+admin.getDateOfBirth().getYear(), generateYearList());

        ConfirmButton confirmButton = new ConfirmButton("Change Birthdate");
        // Add ComboBoxes to the row (HBox)
        this.getChildren().addAll(label, dayComboBox, monthComboBox, yearComboBox,confirmButton);

        // Set row alignment and padding
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-padding: 10px;");

        confirmButton.setOnAction(e -> {
            admin.getDateOfBirth().setDay(Integer.parseInt(dayComboBox.getValue()));
            admin.getDateOfBirth().setMonth(monthComboBox.getValue());
            admin.getDateOfBirth().setYear(Integer.parseInt(yearComboBox.getValue()));
            Validations.showAlert(Alert.AlertType.INFORMATION, "Success", "Date of birth updated successfully.");
        });
    }

    // Method to create a ComboBox with given items
    private ComboBox<String> createComboBox(String type, String initialText, String... items) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(items);
        comboBox.setValue(initialText); // Set the initial text
        comboBox.setPrefHeight(COLLAPSED_HEIGHT); // Set the initial collapsed height
        comboBox.setStyle("-fx-font-size: 16px;");

        // Add event handler to expand or collapse the ComboBox when clicked
        comboBox.setOnAction(event -> {
            if (!comboBox.isShowing()) {
                comboBox.show(); // Expand the ComboBox
            } else {
                comboBox.hide(); // Collapse the ComboBox
            }
        });

        return comboBox;
    }

    // Generate list of days (01 to 31)
    private String[] generateDayList() {
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.format("%02d", i + 1); // Format days as "01", "02", ..., "31"
        }
        return days;
    }

    // Generate list of years (for example, from 1900 to current year)
    private String[] generateYearList() {
        int startYear = 1930;
        int endYear = java.time.Year.now().getValue(); // Get current year
        String[] years = new String[endYear - startYear + 1];

        for (int i = 0; i <= endYear - startYear; i++) {
            years[i] = String.valueOf(startYear + i);
        }
        return years;
    }
}