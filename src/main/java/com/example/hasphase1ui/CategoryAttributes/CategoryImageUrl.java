package com.example.hasphase1ui.CategoryAttributes;

import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.CustomTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class CategoryImageUrl extends HBox {
    private  CustomTextField categoryImageFeild;
    public CategoryImageUrl(){
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
        CustomLabel categoryImage = new CustomLabel("Category Image :");
        categoryImageFeild = new CustomTextField("Enter Category Image URL");
        this.getChildren().addAll(categoryImage,categoryImageFeild);
    }
    public String getText(){
        return categoryImageFeild.getText();
    }
}
