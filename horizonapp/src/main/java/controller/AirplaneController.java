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
import model.Airplane;

public class AirplaneController {
    
    private Airplane airplane1;
    private Airplane airplane2;

    public AirplaneController(String airplane1Path, String airplane2Path, int pos1 , int pos2 , double size1 , double size2 ) throws FileNotFoundException {
        airplane1 = new Airplane(airplane1Path,pos1, size1);
        airplane2 = new Airplane(airplane2Path,pos2 , size2);
    }

    public Airplane getAirplane(int airplaneIndex) {
        return (airplaneIndex == 1) ? airplane1 : airplane2;
    }

    public void handleKeyPress(KeyCode keyCode) {
        if (keyCode == KeyCode.RIGHT) {
            airplane1.rotate(5);
        } else if (keyCode == KeyCode.LEFT) {
            airplane1.rotate(-5);
        } else if (keyCode == KeyCode.UP) {
            airplane1.translateY(-10);
        } else if (keyCode == KeyCode.DOWN) {
            airplane1.translateY(10);
        }
    }
    
}
