package com.example.hasphase1ui.Pages.LoginPages;

import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.Pages.CategoriesProducts.CategoriesPage;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.User;
import com.example.hasphase1ui.files.UsersEditor;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.PagesBackground;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class LoginPage {

    private Stage primaryStage;
    private UsersEditor usersEditor = new UsersEditor() ;

    public LoginPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setMaximized(true);
    }

    public ScrollPane getRoot() {


        VBox formLayout = new VBox(20);
        formLayout.setPadding(new Insets(20));
        formLayout.setAlignment(Pos.CENTER);





        String imagePath = "Images/backimage.jpg";
        Image backgroundImage = new Image(imagePath);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(true);
        primaryStage.setMaximized(true);
        backgroundImageView.setFitWidth(primaryStage.getWidth());
        backgroundImageView.setFitHeight(primaryStage.getHeight());






        ImageView profile = new ImageView(new Image("Images/blackprofile.png"));
        profile.setFitWidth(200);
        profile.setPreserveRatio(true);

        HBox welcomeLabelBox = new HBox(10);
        Label welcomeLabel = new Label("Welcome! Please log in.");
        welcomeLabel.getStyleClass().add("welcome-label");
        welcomeLabelBox.setAlignment(Pos.CENTER);
        welcomeLabelBox.getChildren().addAll(welcomeLabel);


        HBox usernameBox = new HBox(10);
        Label usernameLabel = new Label("Username:");
        usernameLabel.getStyleClass().add("form-label");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameBox.getChildren().addAll(usernameLabel, usernameField);
        usernameBox.setAlignment(Pos.CENTER);

        HBox passwordBox = new HBox(10);
        Label passwordLabel = new Label("Password:");
        passwordLabel.getStyleClass().add("form-label");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        passwordBox.setAlignment(Pos.CENTER);

        VBox buttonBox = new VBox(85);
        ConfirmButton loginButton = new ConfirmButton("Login");

        VBox notAUserV = new VBox(25);
        Label notAUserLabel = new Label("Not a User?");
        notAUserLabel.getStyleClass().add("notAUser-label");
        ConfirmButton registerButton = new ConfirmButton("Register");

        notAUserV.getChildren().addAll(notAUserLabel, registerButton);
        notAUserV.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(loginButton, notAUserV);
        buttonBox.setAlignment(Pos.CENTER);


        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                showErrorAlert("Validation Error", "Username and Password cannot be empty!");
            } else {
                boolean userFound = false;
                for (User user : usersEditor.getUsers()) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        showSuccessAlert("Login Successful", "Welcome back, " + username + "!");
                        userFound = true;
                        if (user instanceof Customer) {
                            Customer customer = (Customer) user;
                            CategoriesPage categoriesPage = new CategoriesPage(primaryStage,customer);
                            primaryStage.getScene().setRoot(categoriesPage.getRoot());
                            primaryStage.setFullScreen(true);
                        }
                        else{
                            Admin admin = (Admin) user;
                            AdminHomeScreen adminHomeScreen = new AdminHomeScreen(primaryStage,admin);
                            primaryStage.getScene().setRoot(adminHomeScreen.getRoot());
                            primaryStage.setFullScreen(true);
                        }
                    }
                }
                if (!userFound) {
                    showErrorAlert("Login Failed", "User not found! Please register.");
                }
            }
        });

        registerButton.setOnAction(e -> {
            RegistrationPage registrationPage = new RegistrationPage(primaryStage);
            primaryStage.getScene().setRoot(registrationPage.getRoot());
            primaryStage.setTitle("Registration Page");
            primaryStage.setMaximized(true);
            primaryStage.setFullScreen(true);
        });


        // key event to move focus from username to password
        usernameField.setOnAction(e -> passwordField.requestFocus());
        // key event to move focus from password to press login button
        passwordField.setOnAction(e -> loginButton.requestFocus());

        formLayout.getChildren().addAll( welcomeLabelBox, profile, usernameBox, passwordBox, buttonBox);
        formLayout.setBackground(PagesBackground.getBackground());

        ScrollPane scrollPane = new ScrollPane(formLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");



        formLayout.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return scrollPane;
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    // method to show a success alert
    private void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
