package com.example.hasphase1ui.widgets;

import javafx.scene.layout.Pane;

public class SizedBox extends Pane{
    public SizedBox(){
        this.setPrefSize(300,60);

    }
    public SizedBox(double width , double height){
        this.setPrefSize(width,height);
    }
}
