package com.example.hasphase1ui.widgets;
import com.example.hasphase1ui.files.User;
import com.example.hasphase1ui.files.UsersEditor;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class Validations {
    private static UsersEditor usersEditor =new UsersEditor();
    public static void showAlertaa(AlertType alertType, String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void showAlert(AlertType alertType,String title, String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY); // Simple, non-disruptive style
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);

            // Prevent the alert from blocking the UI
            Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
            alertStage.setAlwaysOnTop(true); // Keep alert on top
            alertStage.setFullScreen(false); // Avoid fullscreen conflict

            alert.show(); // Show the alert asynchronously
        });
    }
    public static boolean isValidDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isValidInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean checkUsername(String username){

        for (User user : usersEditor.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}

