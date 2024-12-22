package com.example.hasphase1ui.widgets;

import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.User;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class UserWidget extends HBox {
    public UserWidget(User user, Admin admin){
        String userType;
        String you;
        if (user instanceof Customer){
            userType="Customer";
        }else {
            userType="Admin";
        }
        if (user.getUsername().equals(admin.getUsername())){
            you = "     (YOU)";
        }else {
            you="";
        }
        CenteredLabel userInfo = new CenteredLabel(user.getUsername()+"  :  "+userType + you);
        this.getChildren().add(userInfo);
        this.setAlignment(Pos.CENTER);
    }
}
