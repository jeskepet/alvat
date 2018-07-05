/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alvat_application.testing;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author light
 */
public class ProcessIncommingMessage {

    public static MessageElement[] processIncommingMessage(JSONArray incommingMessage) {

        MessageElement[] data = new MessageElement[incommingMessage.length()];
        for (int i = 0; i < incommingMessage.length(); i++) {
            data[i] = processElement(incommingMessage.getJSONObject(i));          
        }
        return data;
    }
    
    private static MessageElement processElement(JSONObject o){
        
        MessageElement element = null;
        
        switch(o.getString("T")){
            case "IP":{
                element = new IPMessageElement(o.getString("N"),o.getString("T"),
                        o.getString("V"), o.getString("L"), o.getString("P"), o.getString("RW"));
                break;
            }
            case "ID":{
                element = new NumberMessageElement(o.getString("N"),o.getString("T"),
                        o.getString("V"), o.getString("L"), o.getString("P"), 
                        o.getString("RW"), o.getDouble("MAX"), o.getDouble("MAX"));
                break;
            }
            case "CT":{
                element = new StringMessageElement(o.getString("N"),o.getString("T"),
                        o.getString("V"), o.getString("L"), o.getString("P"), 
                        o.getString("RW"), o.getInt("MAX"), o.getInt("MAX"));
                break;
            }
            default:{
                System.out.println("Unexpected message element occured!");
                break;
            }
        }
        
        return element;
    }

}
