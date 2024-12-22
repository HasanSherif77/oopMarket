package com.example.hasphase1ui.widgets;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public abstract class PagesBackground {

    static Image backgroundImage = new Image("Images/backimage.jpg");// Replace with your image path

    static BackgroundImage imageBackground = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1.0, 1.0, true, true, true, true) // Resize to fit
    );
    static Background background = new Background(imageBackground);

    public static Background getBackground(){
        return  background;
    }

    static Image backgroundImageColor = new Image("Images/image.jpg");// Replace with your image path

    static BackgroundImage imageBackground1 = new BackgroundImage(
            backgroundImageColor,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1.0, 1.0, true, true, true, true) // Resize to fit
    );
    static Background background1 = new Background(imageBackground1);

    public static Background getBackgroundColor(){
        return  background1;
    }
}
