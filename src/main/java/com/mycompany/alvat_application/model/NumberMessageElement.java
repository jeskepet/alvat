/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alvat_application.model;

import org.json.JSONObject;

/**
 *
 * @author light
 */
public class NumberMessageElement extends MessageElement {

    Double maxValue = -1.0;
    Double minValue = -1.0;

    public NumberMessageElement(String name, String type, String value, String label, String poss, String rw) {
        super(name, type, value, label, poss, rw);
    }

    public NumberMessageElement(String name, String type, String value, String label, String poss, String rw, Double max, Double min) {
        super(name, type, value, label, poss, rw);
        this.maxValue = max;
        this.minValue = min;
    }

    @Override
    public JSONObject parseToJSON() {
        JSONObject o = super.parseToJSON();
        o.put("MIN", maxValue);
        o.put("MAX", minValue);
        return o;
    }

    public void setMaxValue(double max) {
        this.maxValue = max;
    }

    public double getMaxValue() {
        return this.maxValue;
    }

    public void setMinValue(double min) {
        this.minValue = min;
    }

    public double getMinValue() {
        return this.minValue;
    }

    @Override
    public void showElement() {
        System.out.println("Name: " + this.name + " Type: " + this.type + " Value: " + this.value 
        + " Label: " + this.label + " Pos: " + this.poss + " RW: " + this.rw 
        + " MAX: " + this.maxValue + " MIN: " + this.minValue);
    }

}
