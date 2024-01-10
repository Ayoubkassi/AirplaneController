/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author kassi
 */

import javafx.scene.input.KeyCode;

import java.io.FileNotFoundException;
import model.Background;

public class BackgroundController {
    
    private Background background1;
    private Background background2;

    public BackgroundController(String background1Path, String background2Path , int pos1 , int pos2 , double size1 , double size2) throws FileNotFoundException {
        background1 = new Background(background1Path, pos1 , size1);
        background2 = new Background(background2Path , pos2 , size2);
    }

    public Background getBackground(int backgroundIndex) {
        return (backgroundIndex == 1) ? background1 : background2;
    }

    public void handleKeyPress(KeyCode keyCode) {
        if (keyCode == KeyCode.RIGHT || keyCode == KeyCode.LEFT) {
            background2.rotate(5);
        } else if (keyCode == KeyCode.UP || keyCode == KeyCode.DOWN) {
            background2.translateY(10);
        }
    }
    
}
