package com.example.hasphase1ui.CategoryAttributes;

import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.CustomTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class CategoryName extends HBox {
    private CustomTextField nameTextFeild;

    public CategoryName(){
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
        CustomLabel categoryName = new CustomLabel("Category Name :");
        nameTextFeild = new CustomTextField("Enter Category Name");
        this.getChildren().addAll(categoryName,nameTextFeild);
    }
    public String getText(){
        return nameTextFeild.getText();
    }
}
