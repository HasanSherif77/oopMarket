package com.example.hasphase1ui.Pages;

import com.example.hasphase1ui.Pages.CategoriesProducts.CategoriesPage;
import com.example.hasphase1ui.Pages.LoginPages.LoginPage;
import com.example.hasphase1ui.UserInfos.*;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

public class AcountViewScreen  {

    Stage stage;
    Customer customer;
    Admin admin;

    public AcountViewScreen(Stage stage, Customer customer){
        stage.setMaximized(true);
        this.stage=stage;
        this.customer=customer;
    }

    public AcountViewScreen(Stage stage, Admin admin){
        stage.setMaximized(true);
        this.stage=stage;
        this.admin=admin;
        customer=null;
    }

    public ScrollPane getRoot() {


        VBox acountInfo = new VBox(35);

        acountInfo.setBackground(PagesBackground.getBackground());

        SizedBox sizedBox1 = new SizedBox(0,70);

        CustomLabel titleLabel = new CustomLabel("Personal Info", 30, "-fx-font-weight: bold;");

        HBox topLabel = new HBox();
        topLabel.getChildren().add(titleLabel);
        topLabel.setAlignment(Pos.CENTER);

        // Enable VBox to grow vertically
        VBox.setVgrow(acountInfo, Priority.ALWAYS);
        // Add customer-specific attributes
        if (customer != null) {
            Toolbar toolbar = new Toolbar(stage,customer);
            ConfirmButton backButton = new ConfirmButton("Go Back");
            UsernameAttribute usernameAttribute = new UsernameAttribute(stage,customer);
            PasswordAttribute passwordAttribute = new PasswordAttribute(customer);
            DateOfBirthAttribute dateOfBirthAttribute = new DateOfBirthAttribute(customer);
            backButton.setOnAction(e ->{
                CategoriesPage categoriesPage =new CategoriesPage(stage,customer);
                stage.getScene().setRoot(categoriesPage.getRoot());
                stage.setFullScreen(true);
            } );
            BalanceAttribute balanceAttribute = new BalanceAttribute(customer);
            AddressAttribute addressAttribute = new AddressAttribute(customer);
            GenderAttribute genderAttribute = new GenderAttribute(customer);
            InterestsAttribute interestsAttribute = new InterestsAttribute(customer);


            ConfirmButton logoutButton = new ConfirmButton("Log Out");
            logoutButton.setOnAction(e->{
                LoginPage loginPage = new LoginPage(stage);
                stage.getScene().setRoot(loginPage.getRoot());
                stage.setFullScreen(true);

            });
            HBox logout = new HBox(backButton,logoutButton);
            logout.setAlignment(Pos.CENTER);
            logout.setSpacing(40);
            acountInfo.getChildren().addAll(toolbar, topLabel, usernameAttribute, passwordAttribute, dateOfBirthAttribute, balanceAttribute, addressAttribute, genderAttribute,interestsAttribute,logout);
        }
        else {
            UsernameAttribute usernameAttribute = new UsernameAttribute(stage,admin);
            PasswordAttribute passwordAttribute = new PasswordAttribute(admin);
            DateOfBirthAttribute dateOfBirthAttribute = new DateOfBirthAttribute(admin);
            AdminAttributes adminAttributes = new AdminAttributes(admin);

            ConfirmButton backButton = new ConfirmButton("Go Back");
            backButton.setOnAction(e ->{
                AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
                stage.getScene().setRoot(adminHomeScreen.getRoot());
                stage.setFullScreen(true);
            } );
            ConfirmButton logoutButton = new ConfirmButton("Log Out");
            logoutButton.setOnAction(e->{
                LoginPage loginPage = new LoginPage(stage);
                stage.getScene().setRoot(loginPage.getRoot());
                stage.setFullScreen(true);

            });
            HBox hBox = new HBox(backButton,logoutButton);
            hBox.setSpacing(40);
            hBox.setAlignment(Pos.CENTER);


            acountInfo.getChildren().addAll(sizedBox1, topLabel, usernameAttribute, passwordAttribute, dateOfBirthAttribute, adminAttributes,hBox);
        }



        ScrollPane scrollablePane = new ScrollPane(acountInfo);
        scrollablePane.setFitToWidth(true); // Adjust to the width of the screen
        scrollablePane.setFitToHeight(true); // Adjust to the height of the screen if needed
        return  scrollablePane;  // Set the scene with the scrollable pane
    }
}
