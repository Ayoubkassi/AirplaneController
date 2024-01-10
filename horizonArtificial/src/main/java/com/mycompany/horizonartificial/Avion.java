/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horizonartificial;

/**
 *
 * @author kassi
 */
public class Avion {
    // attributes
    private double angleR;
    private double angleT;
    
    // constructor

    public Avion() {
        this.angleR = 0;
        this.angleT = 0;
    }

    public Avion(double angleR, double angleT) {
        this.angleR = angleR;
        this.angleT = angleT;
    }

    public double getAngleR() {
        return angleR;
    }

    public void setAngleR(double angleR) {
        this.angleR = angleR;
    }

    public double getAngleT() {
        return angleT;
    }

    public void setAngleT(double angleT) {
        this.angleT = angleT;
    }

    @Override
    public String toString() {
        return "Avion{" + "angleR=" + angleR + ", angleT=" + angleT + '}';
    }
    
    
    
    
}
