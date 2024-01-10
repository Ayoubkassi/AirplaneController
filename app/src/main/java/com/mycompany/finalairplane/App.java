package com.mycompany.finalairplane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.layout.StackPane;

public class App extends Application {

    private AirplaneController airplaneController;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Image objectImg = new Image(new FileInputStream("/home/kassi/Desktop/object.png"));
        Image backgroundImg = new Image(new FileInputStream("/home/kassi/Desktop/1.png"));
        Image airplaneImg = new Image(new FileInputStream("/home/kassi/Desktop/2.png"));

        airplaneController = new AirplaneController(objectImg, backgroundImg, airplaneImg);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(
                airplaneController.createImageViewWithLabel(airplaneController.getBackground1ImageView(), airplaneController.getLabel1()),
                airplaneController.createImageViewWithLabel(airplaneController.getBackground2ImageView(), airplaneController.getLabel2()),
                airplaneController.getObjectImageView(),
                airplaneController.getAirplane1ImageView(),
                airplaneController.getAirplane2ImageView()
        );

        Scene scene = new Scene(stackPane, objectImg.getWidth(), objectImg.getHeight());

        addEventListeners(scene);

        stage.setScene(scene);
        stage.show();
    }

    private void addEventListeners(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    airplaneController.rotateAirplane1(5);
                    airplaneController.rotateBackground2(5);
                    break;
                case LEFT:
                    airplaneController.rotateAirplane1(-5);
                    airplaneController.rotateBackground2(-5);
                    break;
                case UP:
                    airplaneController.translateAirplane1Y(-10);
                    airplaneController.translateBackground2Y(-10);
                    break;
                case DOWN:
                    airplaneController.translateAirplane1Y(10);
                    airplaneController.translateBackground2Y(10);
                    break;
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
