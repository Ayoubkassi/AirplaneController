/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kassi
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Airplane {
    
    private ImageView imageView;
    private int position;
    private double size;

    public Airplane(String imagePath , int position , double size) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(imagePath));
        imageView = new ImageView(image);
        this.position = position;
        this.size = size;
    }

    public ImageView getView() {
        translateXImageView(this.imageView , this.position);
        resizeImageView(this.imageView , this.size);
        return imageView;
    }

    public void rotate(double degrees) {
        imageView.setRotate(imageView.getRotate() + degrees);
    }

    public void translateY(double deltaY) {
        if ((imageView.getTranslateY() < -190 && deltaY < 0) || (imageView.getTranslateY() > 190 && deltaY > 0))
            return;
        imageView.setTranslateY(imageView.getTranslateY() + deltaY);
        System.out.println("Airplane translateY value: " + imageView.getTranslateY());
    }
    
    public static void resizeImageView(ImageView imageView, double scaleFactor) {
        imageView.setScaleX(scaleFactor);
        imageView.setScaleY(scaleFactor);
    }
      public static void translateXImageView(ImageView imageView, int translateX) {
        imageView.setTranslateX(translateX);
    }
    
}
