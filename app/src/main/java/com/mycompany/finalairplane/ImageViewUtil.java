/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalairplane;

/**
 *
 * @author kassi
 */
import javafx.scene.image.ImageView;


public class ImageViewUtil {
    
     public static void resizeImageView(ImageView imageView, double scaleFactor) {
        imageView.setScaleX(scaleFactor);
        imageView.setScaleY(scaleFactor);
    }

    public static void translateXImageView(ImageView imageView, double translateX) {
        imageView.setTranslateX(translateX);
    }
    
}
