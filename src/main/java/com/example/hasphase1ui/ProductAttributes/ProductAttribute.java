package com.example.hasphase1ui.ProductAttributes;

import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.widgets.CustomLabel;
import com.example.hasphase1ui.widgets.CustomTextField;
import com.example.hasphase1ui.widgets.SizedBox;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ProductAttribute extends HBox {

    private CustomTextField attributeTextField; // Store the TextField as a member variable

    public ProductAttribute(String label){

        CustomLabel attributeLabel = new CustomLabel(label+":   ");

        this.attributeTextField = new CustomTextField(label);

        setFocusTraversable(false);
        this.setSpacing(40);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll( attributeLabel,attributeTextField);


    }
    public ProductAttribute(String label,String textfeildvalue ){

        CustomLabel attributeLabel = new CustomLabel(label+":   ");

        this.attributeTextField = new CustomTextField(textfeildvalue);
        setFocusTraversable(false);

        SizedBox sizedBox = new SizedBox(20,20);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll( attributeLabel,attributeTextField,sizedBox);


    }
    public String getText(){
        return attributeTextField.getText();
    }
}
