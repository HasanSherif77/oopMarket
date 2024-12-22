package com.example.hasphase1ui.widgets;

import javafx.scene.control.Button;

public class ConfirmButton extends Button {

    public ConfirmButton(String text) {
        super(text);
        this.setStyle(
                "-fx-background-color: rgba(245, 245, 245, 0.5); /* Light gray with slight transparency */\n" +
                        "-fx-text-fill: black;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 20px;" +  // Apply rounded corners to the background
                        "-fx-border-radius: 20px;" +      // Apply rounded corners to the border
                        "-fx-border-color: transparent;" + // Ensure no visible border
                        "-fx-padding: 10px;" +
                        "-fx-pref-height: 50px; " +          // Increase height of the button
                        "-fx-font-size: 18px; "  +
                        "-fx-wrap-text: true;" +
                        "-fx-min-width: 150px; "
        );

        this.setOnMouseEntered(event -> {
            this.setStyle(
                    "-fx-background-color: #45a049; "+
                            "-fx-text-fill: black;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 20px;" +  // Apply rounded corners to the background
                            "-fx-border-radius: 20px;" +      // Apply rounded corners to the border
                            "-fx-border-color: transparent;" + // Ensure no visible border
                            "-fx-padding: 10px;" +
                            "-fx-pref-height: 50px; " +          // Increase height of the button
                            "-fx-font-size: 18px; "  +
                            "-fx-wrap-text: true;" +
                            "-fx-min-width: 150px; "
            );
        });

        this.setOnMouseExited(event -> {
            this.setStyle(
                    "-fx-background-color: rgba(245, 245, 245, 0.5); /* Light gray with slight transparency */\n" +
                            "-fx-text-fill: black;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 20px;" +  // Apply rounded corners to the background
                            "-fx-border-radius: 20px;" +      // Apply rounded corners to the border
                            "-fx-border-color: transparent;" + // Ensure no visible border
                            "-fx-padding: 10px;" +
                            "-fx-pref-height: 50px; " +          // Increase height of the button
                            "-fx-font-size: 18px; "  +
                            "-fx-wrap-text: true;" +
                            "-fx-min-width: 150px; "
            );
        }); // <-- Add missing closing parenthesis here
    }
}
