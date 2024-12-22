package com.example.hasphase1ui.widgets;

import javafx.scene.control.TextField;

public class CustomTextField extends TextField {


    public CustomTextField(String label) {

        this.setPromptText(label);
        this.setStyle(
                "-fx-pref-width: 200px; " +
                "-fx-font-size: 14px; " +
                "-fx-padding: 5px;" +
                "-fx-background-color: rgba(64, 64, 64, 0.8);"+
                "-fx-text-fill: white;" +
                "-fx-border-color: #555;" +
                "-fx-border-radius: 5px;" +
                "-fx-padding: 5px;" +
                "-fx-pref-width:200px;" +
                "-fx-prompt-text-fill: rgba(255, 255, 255, 0.5);"
        );
        this.setFocusTraversable(false);
    }


}
