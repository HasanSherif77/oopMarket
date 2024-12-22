package com.example.hasphase1ui.widgets;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class HorizontalSpace extends HBox {
    public HorizontalSpace(){
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
    }

}
