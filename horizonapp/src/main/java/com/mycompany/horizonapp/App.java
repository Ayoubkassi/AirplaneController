package com.mycompany.horizonapp;

import controller.AirplaneController;
import controller.BackgroundController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    private AirplaneController airplaneController;
    private BackgroundController backgroundController;
    
   @Override
    public void start(Stage stage) throws FileNotFoundException {
        airplaneController = new AirplaneController("/home/kassi/Desktop/2.png", "/home/kassi/Desktop/2.png",520,-520,0.5,0.5);
        backgroundController = new BackgroundController("/home/kassi/Desktop/1.png", "/home/kassi/Desktop/1.png",520,-520,0.5,0.9);
        Image objectImg = new Image(new FileInputStream("/home/kassi/Desktop/object.png"));

        ImageView object1 = new ImageView(objectImg);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(
                backgroundController.getBackground(1).getView(),
                backgroundController.getBackground(2).getView(),
                object1,
                airplaneController.getAirplane(1).getView(),
                airplaneController.getAirplane(2).getView()
        );

        var scene = new Scene(stackPane,objectImg.getWidth() ,objectImg.getHeight());

        scene.setOnKeyPressed(event -> {
            airplaneController.handleKeyPress(event.getCode());
            backgroundController.handleKeyPress(event.getCode());
        });

        stage.setScene(scene);
        stage.show();

        stackPane.setAlignment(airplaneController.getAirplane(1).getView(), javafx.geometry.Pos.CENTER);
        stackPane.setAlignment(backgroundController.getBackground(1).getView(), javafx.geometry.Pos.CENTER);
    }

    public static void main(String[] args) {
        launch();
    }

}