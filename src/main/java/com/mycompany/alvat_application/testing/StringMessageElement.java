/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alvat_application.testing;

import org.json.JSONObject;

/**
 *
 * @author light
 */
public class StringMessageElement extends MessageElement {

    int maxLength = -1;
    int minLength = -1;

    public StringMessageElement(String name, String type, String value, String label, String poss, String rw) {
        super(name, type, value, label, poss, rw);
    }

    public StringMessageElement(String name, String type, String value, String label, String poss, String rw, int maxLength, int minLength) {
        super(name, type, value, label, poss, rw);
        this.maxLength = maxLength;
        this.minLength = minLength;
    }

    @Override
    public JSONObject parseToJSON() {
        JSONObject o = super.parseToJSON();
        o.put("MIN", maxLength);
        o.put("MAX", minLength);
        return o;
    }

    public void setMaxLength(int max) {
        this.maxLength = max;
    }

    public int getMaxLenght() {
        return this.maxLength;
    }

    public void setMinValue(int min) {
        this.minLength = min;
    }

    public int getMinValue() {
        return this.minLength;
    }

    @Override
    public void showElement() {
        System.out.println("Name: " + this.name + " Type: " + this.type + " Value: " + this.value
                + " Label: " + this.label + " Pos: " + this.poss + " RW: " + this.rw
                + " MAX: " + this.maxLength + " MIN: " + this.minLength);
    }

}
