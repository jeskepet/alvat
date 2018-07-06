/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alvat_application.view;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * Class to show dialogs - information, warning, error, question
 *
 * @author PBProgramming
 * @version 1.0
 * @since 2018-01-26
 */
public class Dialog {

    /**
     * Show information dialog
     *
     * @param title String title which is shown on the topbar
     * @param msg String main message to say
     * @param position double[] x, y, width and height position of primary stage
     * and width and height of screen
     */
    public void information(String title, String msg, double[] position) {
        Alert alert = createAlert(title, msg, AlertType.INFORMATION, position);
        alert.showAndWait();
    }

    /**
     * Show warning dialog
     *
     * @param title String title which is shown on the topbar
     * @param msg String main message to say
     * @param position double[] x, y, width and height position of primary stage
     * and width and height of screen
     */
    public void warning(String title, String msg, double[] position) {
        Alert alert = createAlert(title, msg, AlertType.WARNING, position);
        alert.showAndWait();
    }

    /**
     * Show error dialog
     *
     * @param title String title which is shown on the topbar
     * @param msg String main message to say
     * @param position double[] x, y, width and height position of primary stage
     * and width and height of screen
     */
    public void error(String title, String msg, double[] position) {
        Alert alert = createAlert(title, msg, AlertType.ERROR, position);
        alert.showAndWait();
    }

    /**
     * Show question dialog and return true if OK button is pressed otherwise
     * return false.
     *
     * @param title String title which is shown on the topbar
     * @param msg String main question to ask
     * @param position double[] x, y, width and height position of primary stage
     * and width and height of screen
     * @return boolean return true if OK button is pressed otherwise return
     * false
     */
    public boolean question(String title, String msg, double[] position) {
        Alert alert = createAlert(title, msg, AlertType.CONFIRMATION, position);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    /**
     * Create alert window.
     *
     * @param title String title which is shown on the topbar
     * @param msg String main question to ask
     * @param position double[] x, y, width, height position of primary stage
     * and width and height of screen
     * @return Alert
     */
    private Alert createAlert(String title, String msg, AlertType type, double[] position) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        double x = position[0] + position[2] / 2 - 150;
        double y = position[1] + position[3] / 2 - 100;
        if (x > 0 && x < position[4] && y > 0 && y < position[5]) {
            alert.setX(x);
            alert.setY(y);
        }

        /*Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        try{
            File f = new File("icons/alvat.png");
            stage.getIcons().add(new Image(f.toURI().toString()));
        }
        catch(Exception e){}*/
        return alert;
    }

}
