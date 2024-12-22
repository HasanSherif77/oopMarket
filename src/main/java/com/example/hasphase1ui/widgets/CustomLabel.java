package com.example.hasphase1ui.widgets;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class CustomLabel extends Label {

   public CustomLabel(String label){
       super(label);
       labelStyle(25,"-fx-font-weight: normal;");
   }
   public CustomLabel(String label,double fontSize,String fontWeight){
       super(label);
       labelStyle(fontSize,fontWeight);
   }
    private void labelStyle(double fontSize,String fontWeight) {
        // Set default styles for the custom label
        this.setFont(
                new Font(
                        "Arial",
                        fontSize
                )
        );
        this.setStyle("-fx-font-size:" +fontSize+"px;" +fontWeight+" -fx-text-fill: black;");
        this.setWrapText(true);
    }

}
