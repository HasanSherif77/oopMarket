package com.example.hasphase1ui.widgets;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class CenteredLabel extends HBox {

    public CenteredLabel(String label){
        CustomLabel customLabel= new CustomLabel(label);
        this.getChildren().add(customLabel);
        this.setAlignment(Pos.CENTER);
    }
    public CenteredLabel(String label,double fontSize,String fontWeight){
        CustomLabel customLabel = new CustomLabel(label,fontSize,fontWeight);
        this.getChildren().add(customLabel);
        this.setAlignment(Pos.CENTER);
    }

}
