package com.example.hasphase1ui.Pages.LoginPages;

import com.example.hasphase1ui.files.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.stream.IntStream;

public class RegistrationPage {

    private Stage primaryStage;
    private UsersEditor usersEditor = new UsersEditor() ;

    public RegistrationPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public StackPane getRoot() {
        StackPane layout = new StackPane();
        layout.setPadding(new Insets(20));

        VBox formLayout = new VBox(20);
        formLayout.setPadding(new Insets(20));
        formLayout.setAlignment(Pos.CENTER);

        // Set background image
        String imagePath = "Images/backimage.jpg";
        Image backgroundImage = new Image(imagePath);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(true);
        primaryStage.setMaximized(true);
        backgroundImageView.setFitWidth(primaryStage.getWidth());
        backgroundImageView.setFitHeight(primaryStage.getHeight());

        layout.getChildren().add(backgroundImageView);

        HBox registerLabelBox = new HBox(15);
        Label registerLabel = new Label("Register New Account");
        registerLabel.getStyleClass().add("register-label");
        registerLabelBox.setAlignment(Pos.CENTER);
        registerLabelBox.getChildren().add(registerLabel);


        ImageView profile = new ImageView(new Image("Images/blackprofile.png"));
        profile.setFitWidth(150);
        profile.setPreserveRatio(true);


        HBox usernameBox = new HBox(10);
        Label usernameLabel = new Label("Username:");
        usernameLabel.getStyleClass().add("form-label");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setTooltip(new Tooltip("Enter a unique username."));
        usernameBox.getChildren().addAll(usernameLabel, usernameField);
        usernameBox.setAlignment(Pos.CENTER);

        HBox passwordBox = new HBox(10);
        Label passwordLabel = new Label("Password:");
        passwordLabel.getStyleClass().add("form-label");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        passwordBox.setAlignment(Pos.CENTER);

        // key event to move focus from username to password
        usernameField.setOnAction(e -> passwordField.requestFocus());

        Label dobLabel = new Label("Date of Birth:");
        dobLabel.getStyleClass().add("form-label");
        HBox dobBox = new HBox(10);
        ComboBox<Integer> dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(IntStream.rangeClosed(1, 31).boxed().toList());
        dayComboBox.setPromptText("Day");
        dayComboBox.getStyleClass().add("dob-box");
        ComboBox<String> monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        monthComboBox.setPromptText("Month");
        monthComboBox.getStyleClass().add("dob-box");
        ComboBox<Integer> yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(IntStream.rangeClosed(1900, 2024).boxed().toList());
        yearComboBox.setPromptText("Year");
        yearComboBox.getStyleClass().add("dob-box");
        dobBox.getChildren().addAll(dobLabel,dayComboBox, monthComboBox, yearComboBox);
        dobBox.setAlignment(Pos.CENTER);


        HBox balanceBox = new HBox(10);
        Label balanceLabel = new Label("Balance:");
        balanceLabel.getStyleClass().add("form-label");
        TextField balanceField = new TextField();
        balanceField.setPromptText("Enter your balance");
        balanceBox.getChildren().addAll(balanceLabel,balanceField);
        balanceBox.setAlignment(Pos.CENTER);


        HBox addressBox = new HBox(10);
        Label addressLabel = new Label("Address:");
        addressLabel.getStyleClass().add("form-label");
        TextField addressField = new TextField();
        addressField.setPromptText("Enter your Address");
        addressBox.getChildren().addAll(addressLabel,addressField);
        addressBox.setAlignment(Pos.CENTER);

        // key event to move focus from Balance to Address
        balanceField.setOnAction(e -> addressField.requestFocus());

        Label genderLabel = new Label("Select Your Gender:");
        genderLabel.getStyleClass().add("form-label");
        HBox genderBox = new HBox(10);
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.getStyleClass().add("gender-box");
        maleRadio.setSelected(true);
        RadioButton femaleRadio = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        femaleRadio.getStyleClass().add("gender-box");
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        genderBox.getChildren().addAll(genderLabel,maleRadio, femaleRadio);
        genderBox.setAlignment(Pos.CENTER);

        Button registerButton = new Button("Register");

        Button backButton = new Button("Back to LogIn Page");
        VBox buttonsBox = new VBox(10, registerButton, backButton);
        buttonsBox.setAlignment(Pos.CENTER);


        // key event to move focus from address to press register button
        addressField.setOnAction(e -> registerButton.requestFocus());

        // validation for registration
        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty() ||
                    dayComboBox.getValue() == null || monthComboBox.getValue() == null ||
                    yearComboBox.getValue() == null ||
                    balanceField.getText().isEmpty() || addressField.getText().isEmpty() ||
                    genderGroup.getSelectedToggle() == null) {

                showErrorAlert("Validation Error", "All fields must be filled in!");
            }
            else {
                try {
                    Double.parseDouble(balanceField.getText());
                } catch (NumberFormatException ex) {
                    showErrorAlert("Validation Error", "Balance must be a valid number!");
                    return;
                }

                for (User user : usersEditor.getUsers()) {
                    if (user.getUsername().equals(username)) {
                        showErrorAlert("Registration Error", "Username already exists!");
                        return;
                    }
                }


                Date dob = new Date(dayComboBox.getValue(), monthComboBox.getValue(), yearComboBox.getValue());
                Gender gender = (genderGroup.getSelectedToggle() == maleRadio) ? Gender.Male : Gender.Female;
                double balance = Double.parseDouble(balanceField.getText());
                String address = addressField.getText();
                Customer newCustomer = new Customer(username, password, dob, balance, address, gender);
                usersEditor.add(newCustomer);


                showSuccessAlert("Registration Successful", "You have successfully registered!");

                // After successful registration, go back to the login page
                LoginPage loginPage = new LoginPage(primaryStage);
                primaryStage.getScene().setRoot(loginPage.getRoot());
                primaryStage.setTitle("Login Page");

            }
        });

        // back to login page
        backButton.setOnAction(e -> {
            LoginPage loginPage = new LoginPage(primaryStage);
            primaryStage.getScene().setRoot(loginPage.getRoot());
            primaryStage.setTitle("Login Page");
            primaryStage.setMaximized(true);
            primaryStage.setFullScreen(true);
        });



        formLayout.getChildren().addAll(
                registerLabelBox,
                profile,
                usernameBox,
                passwordBox,
                genderBox,
                dobBox,
                balanceBox,
                addressBox,
                buttonsBox
        );


        ScrollPane scrollPane = new ScrollPane(formLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");


        layout.getChildren().add(scrollPane);
        layout.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return  layout;
    }


    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
