/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horizonartificial;

/**
 *
 * @author kassi
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageStackingExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load background image
        Image backgroundImage = new Image("/home/kassi/Desktop/3.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        // Load foreground image (to be displayed on top)
        Image foregroundImage = new Image("/home/kassi/Desktop/2.png");
        ImageView foregroundImageView = new ImageView(foregroundImage);

        // Create a stack pane and add images
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundImageView, foregroundImageView);

        // Create the scene
        Scene scene = new Scene(stackPane, 800, 600);

        // Set the stage properties
        primaryStage.setTitle("Image Stacking Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

