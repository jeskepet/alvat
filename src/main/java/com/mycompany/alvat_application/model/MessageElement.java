/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alvat_application.model;

import org.json.JSONObject;

/**
 * Message prototype
 *
 * @author light
 */
public class MessageElement {

    String name;
    String type;
    String value;
    String label;
    String poss;
    String rw;

    public MessageElement(String name, String type, String value, String label, String poss, String rw) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.label = label;
        this.poss = poss;
        this.rw = rw;
    }

    public JSONObject parseToJSON() {
        JSONObject o = new JSONObject();
        o.put("N", name);
        o.put("T", type);
        o.put("V", value);
        o.put("L", label);
        o.put("P", poss);
        o.put("RW", rw);
        return o;
    }

    public boolean setName(String name) {
        this.name = name;
        return true; //return true if sucess
    }

    public String getName() {
        return this.name;
    }

    public boolean setType(String type) {
        this.type = type;
        return true; //return true if sucess
    }

    public String getType() {
        return this.type;
    }

    public boolean setValue(String value) {
        this.value = value;
        return true; //return true if sucess
    }

    public String getValue() {
        return this.value;
    }

    public boolean setLabel(String label) {
        this.label = label;
        return true; //return true if sucess
    }

    public String getLabel() {
        return this.label;
    }

    public boolean setPoss(String poss) {
        this.poss = poss;
        return true; //return true if sucess
    }

    public String getPoss() {
        return this.poss;
    }

    public boolean setRW(String rw) {
        this.rw = rw;
        return true; //return true if sucess
    }

    public String getRW() {
        return this.rw;
    }

    public void showElement(){      
        System.out.println("Name: " + this.name + " Type: " + this.type + " Value: " + this.value 
        + " Label: " + this.label + " Pos: " + this.poss + " RW: " + this.rw);
        
    }
   
    
}
