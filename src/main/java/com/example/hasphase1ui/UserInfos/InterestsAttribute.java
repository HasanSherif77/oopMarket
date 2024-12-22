package com.example.hasphase1ui.UserInfos;

import com.example.hasphase1ui.files.Category;
import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.widgets.CustomLabel;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class InterestsAttribute extends HBox {
    public InterestsAttribute(Customer customer){
        CustomLabel interestsLabel = new CustomLabel("Interests : ");

        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : customer.getInterests()){
            stringBuilder.append(category.getCategoryName()+", ");
        }
        this.setSpacing(30);
        this.setAlignment(Pos.CENTER);
        if (!stringBuilder.isEmpty()){
            CustomLabel customerInterests = new CustomLabel(stringBuilder.toString().substring(0,stringBuilder.length()-2));
            this.getChildren().addAll(interestsLabel,customerInterests);

        }else {
            this.getChildren().addAll(interestsLabel);
        }


    }
}
