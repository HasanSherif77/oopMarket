package com.example.hasphase1ui.Pages.AdminPrint;

import com.example.hasphase1ui.Pages.AdminHomeScreen;
import com.example.hasphase1ui.Pages.CRUD.Category.ReadCategoryScreen;
import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Database;
import com.example.hasphase1ui.files.User;
import com.example.hasphase1ui.files.UsersEditor;
import com.example.hasphase1ui.widgets.*;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowUsers {
    Stage stage ;
    Admin admin;
    public ShowUsers(Stage stage , Admin admin){
        this.stage=stage;
        this.admin=admin;
    }
    public ScrollPane getRoot(){
        UsersEditor usersEditor = new UsersEditor();
        VBox container= new VBox(10);
        container.setBackground(PagesBackground.getBackground());
        SizedBox sizedBox = new SizedBox(20,60);


        CenteredLabel titleLabel = new CenteredLabel("Users",40,"-fx-font-weight: bold;");
        container.getChildren().addAll(sizedBox,titleLabel);
        for (User user : usersEditor.getUsers()){
            UserWidget userWidget = new UserWidget(user,admin);
            container.getChildren().add(userWidget);
        }

        ConfirmButton backButton = new ConfirmButton("Go Back");

        backButton.setOnAction(e ->{
            AdminHomeScreen adminHomeScreen = new AdminHomeScreen(stage,admin);
            stage.getScene().setRoot(adminHomeScreen.getRoot());
            stage.setFullScreen(true);
        } );
        HBox backHbox = new HBox(backButton);
        backHbox.setAlignment(Pos.CENTER);

        container.getChildren().add(backHbox);

        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        return scrollPane;
    }
}