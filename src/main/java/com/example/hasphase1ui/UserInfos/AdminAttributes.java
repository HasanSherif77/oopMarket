package com.example.hasphase1ui.UserInfos;

import com.example.hasphase1ui.files.Admin;
import com.example.hasphase1ui.widgets.CustomLabel;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class AdminAttributes extends HBox {
    Admin admin;
    public AdminAttributes(Admin admin){
        this.admin=admin;
        CustomLabel customLabel = new CustomLabel(admin.getRole()+admin.getWorkingHours().returnWorkingHours());
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(customLabel);

    }
}
