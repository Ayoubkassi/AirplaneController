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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PlaneHorizonApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load plane image
        Image planeImage = new Image("/home/kassi/Desktop/download.png");
        ImageView planeImageView = new ImageView(planeImage);

        // Create artificial horizon
        Rectangle horizon = new Rectangle(800, 2); // Adjust width as needed
        horizon.setStyle("-fx-fill: black;"); // Set the color of the horizon

        // Stack plane and horizon
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(planeImageView, horizon);

        // Create scene
        Scene scene = new Scene(stackPane, 800, 600); // Adjust width and height as needed

        // Set stage properties
        primaryStage.setTitle("Plane with Artificial Horizon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

