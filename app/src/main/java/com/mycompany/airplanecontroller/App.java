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

    private ImageView airplane1;
    private ImageView airplane2;
    
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
        // 1 -> european 
        // 2 -> russian
        
        ImageView object1 = new ImageView(objectImg);
        ImageView background1 = new ImageView(backgroundImg);
        airplane1 = new ImageView(airplaneImg);
        
        ImageView background2 = new ImageView(backgroundImg);
        airplane2 = new ImageView(airplaneImg);
        resizeImageView(background1, 0.5);
        resizeImageView(airplane1, 0.5);
        
        resizeImageView(background2, 0.9);
        resizeImageView(airplane2, 0.5);
        
        translateXImageView(background1,-520);
        translateXImageView(airplane1,-520);
        
        translateXImageView(background2,520);
        translateXImageView(airplane2,520);
        

        // Set the size of the StackPane to match the objectImg
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background1,background2, object1, airplane1,airplane2);

        // Center the content of the StackPane
        StackPane.setAlignment(object1, javafx.geometry.Pos.CENTER);

        var scene = new Scene(stackPane, objectImg.getWidth(), objectImg.getHeight());

        // Add event listeners for key presses
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.RIGHT) {
                rotateAirplane1(5); // Rotate 5 degrees to the right
                rotateBackground2(5,background2);
            } else if (keyCode == KeyCode.LEFT) {
                rotateAirplane1(-5); // Rotate 5 degrees to the left
                rotateBackground2(-5,background2);
            } else if (keyCode == KeyCode.UP) {
                translateAirplaneY(-10); // Move 10 units up
                translateBackground2Y(-10,background2);
            } else if (keyCode == KeyCode.DOWN) {
                translateAirplaneY(10); // Move 10 units down
                translateBackground2Y(10,background2);
            }
        });

        stage.setScene(scene);
        stage.show();

        // Center the content of the StackPane after showing the stage
        StackPane.setAlignment(airplane1, javafx.geometry.Pos.CENTER);
        StackPane.setAlignment(background1, javafx.geometry.Pos.CENTER);
    }

    private void rotateAirplane1(double degrees) {
        // Add rotation to the airplane
        airplane1.setRotate(airplane1.getRotate() + degrees);
    }
    
     private void rotateBackground2(double degrees , ImageView background) {
        // Add rotation to the airplane
        background.setRotate(background.getRotate() - degrees);
    }

    private void translateAirplaneY(double deltaY) {
        // Add translation in the Y-axis
        if( (airplane1.getTranslateY() < -190 && deltaY < 0) ||  (airplane1.getTranslateY() > 190 && deltaY > 0 ) )
               return;
        airplane1.setTranslateY(airplane1.getTranslateY() + deltaY);
        System.out.println("value :"+ airplane1.getTranslateY());
    }
    
    private void translateBackground2Y(double deltaY , ImageView background) {
        // Add translation in the Y-axis
        if( (background.getTranslateY() >= 190 && deltaY < 0) || ( background.getTranslateY() < -200 && deltaY > 0 ))
                return;
        background.setTranslateY(background.getTranslateY() - deltaY);
    }

    public static void main(String[] args) {
        launch();
    }
}
