package com.mycompany.airplanecontroller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * JavaFX App
 */
public class App extends Application {

    private ImageView airplane;
    
     public static void resizeImageView(ImageView imageView, double scaleFactor) {
        imageView.setScaleX(scaleFactor);
        imageView.setScaleY(scaleFactor);
    }
      public static void translateXImageView(ImageView imageView, double translateX) {
        imageView.setTranslateX(translateX);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Image objectImg = new Image(new FileInputStream("/home/kassi/Desktop/object.png"));
        Image backgroundImg = new Image(new FileInputStream("/home/kassi/Desktop/1.png"));
        Image airplaneImg = new Image(new FileInputStream("/home/kassi/Desktop/2.png"));

        // Create ImageViews for each image
        ImageView object = new ImageView(objectImg);
        ImageView background = new ImageView(backgroundImg);
        airplane = new ImageView(airplaneImg);
        resizeImageView(background, 0.5);
        resizeImageView(airplane, 0.5);
        
        translateXImageView(background,-520);
        translateXImageView(airplane,-520);
        

        // Set the size of the StackPane to match the objectImg
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background, object, airplane);

        // Center the content of the StackPane
        StackPane.setAlignment(object, javafx.geometry.Pos.CENTER);

        var scene = new Scene(stackPane, objectImg.getWidth(), objectImg.getHeight());

        // Add event listeners for key presses
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.RIGHT) {
                rotateAirplane(5); // Rotate 5 degrees to the right
            } else if (keyCode == KeyCode.LEFT) {
                rotateAirplane(-5); // Rotate 5 degrees to the left
            } else if (keyCode == KeyCode.UP) {
                translateAirplaneY(-10); // Move 10 units up
            } else if (keyCode == KeyCode.DOWN) {
                translateAirplaneY(10); // Move 10 units down
            }
        });

        stage.setScene(scene);
        stage.show();

        // Center the content of the StackPane after showing the stage
        StackPane.setAlignment(airplane, javafx.geometry.Pos.CENTER);
        StackPane.setAlignment(background, javafx.geometry.Pos.CENTER);
    }

    private void rotateAirplane(double degrees) {
        // Add rotation to the airplane
        airplane.setRotate(airplane.getRotate() + degrees);
    }

    private void translateAirplaneY(double deltaY) {
        // Add translation in the Y-axis
        airplane.setTranslateY(airplane.getTranslateY() + deltaY);
    }

    public static void main(String[] args) {
        launch();
    }
}
