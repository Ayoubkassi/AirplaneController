package com.mycompany.finalairplane;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AirplaneController {

    private ImageView airplane1;
    private ImageView background1;
    private ImageView airplane2;
    private ImageView background2;
    private ImageView object1;
    private Label label1 = createLabel("Airplane 1");
    private Label label2 = createLabel("Airplane 2");

    public AirplaneController(Image objectImg, Image backgroundImg, Image airplaneImg) throws FileNotFoundException {
        object1 = new ImageView(objectImg);
        background1 = createBackgroundImageView(backgroundImg, 0.5, -520);
        airplane1 = createAirplaneImageView(airplaneImg, 0.5, -520);

        label1.setTranslateY(-520);
        label1.setTranslateX(-210);
        label1.setTextFill(javafx.scene.paint.Color.WHITE);

        background2 = createBackgroundImageView(backgroundImg, 0.9, 520);
        airplane2 = createAirplaneImageView(airplaneImg, 0.5, 520);

        label2.setTranslateY(520);
        label2.setTranslateX(-210);
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
    }

    public ImageView getObjectImageView() {
        return object1;
    }

    public ImageView getAirplane1ImageView() {
        return airplane1;
    }

    public ImageView getAirplane2ImageView() {
        return airplane2;
    }

    public Label getLabel1() {
        return label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public ImageView getBackground1ImageView() {
        return background1;
    }

    public ImageView getBackground2ImageView() {
        return background2;
    }

    public ImageView[] getImageViews() {
        return new ImageView[]{background1, background2, object1, airplane1, airplane2};
    }

    public void rotateAirplane1(double degrees) {
        airplane1.setRotate(airplane1.getRotate() + degrees);
    }

    public void rotateBackground2(double degrees) {
        background2.setRotate(background2.getRotate() - degrees);
    }

    public void translateAirplane1Y(double deltaY) {
        if ((airplane1.getTranslateY() < -190 && deltaY < 0) || (airplane1.getTranslateY() > 190 && deltaY > 0)) {
            return;
        }
        airplane1.setTranslateY(airplane1.getTranslateY() + deltaY);
    }

    public void translateBackground2Y(double deltaY) {
        if ((background2.getTranslateY() >= 190 && deltaY < 0) || (background2.getTranslateY() < -200 && deltaY > 0)) {
            return;
        }
        background2.setTranslateY(background2.getTranslateY() - deltaY);
    }

    private ImageView createBackgroundImageView(Image backgroundImg, double scaleFactor, double translateX) {
        ImageView background = new ImageView(backgroundImg);
        resizeImageView(background, scaleFactor);
        translateXImageView(background, translateX);
        return background;
    }

    private ImageView createAirplaneImageView(Image airplaneImg, double scaleFactor, double translateX) {
        ImageView airplane = new ImageView(airplaneImg);
        resizeImageView(airplane, scaleFactor);
        translateXImageView(airplane, translateX);
        return airplane;
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        return label;
    }

    private void resizeImageView(ImageView imageView, double scaleFactor) {
        imageView.setScaleX(scaleFactor);
        imageView.setScaleY(scaleFactor);
    }

    private void translateXImageView(ImageView imageView, double translateX) {
        imageView.setTranslateX(translateX);
    }
    
    public StackPane createImageViewWithLabel(ImageView imageView, Label label) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, label);
        StackPane.setAlignment(label, javafx.geometry.Pos.BOTTOM_CENTER);
        return stackPane;
    }
}
