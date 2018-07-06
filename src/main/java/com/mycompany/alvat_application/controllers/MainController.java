package com.mycompany.alvat_application.controllers;

import com.mycompany.alvat_application.view.Dialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private Button myButton;

    @FXML
    private ScrollPane scrollPaneLeft;

    @FXML
    private ScrollPane scrollPaneRight;

    private GridPane gridPaneLeft;
    private GridPane gridPaneRight;

    GridPane grid2 = new GridPane();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void callMyButton(ActionEvent event) {
        System.out.println("Bla");
        myButton.setText("Button");

        /*Button b1 = new Button("ButtonI1");

        for (int i = 0; i < 30; i++) {
            grid2.add(new Button("butonxy"), 0, i);
        }
        scrollPaneLeft.setContent(grid2);*/
        generateBubleGum();

    }

    public void generateBubleGum() {

        Label l1 = new Label("Nazev zarizeni");
        Label l2 = new Label("Hula hop generator");

        Label l3 = new Label("Prikon");
        Label l4 = new Label("300 MW");

        Label l5 = new Label("IP");
        Label l6 = new Label("Brana");

        TextField tf = new TextField();
        TextField tf2 = new TextField();

        gridPaneLeft = new GridPane();
        gridPaneRight = new GridPane();

        gridPaneLeft.add(l1, 0, 0);
        gridPaneLeft.add(l2, 0, 1);
        gridPaneLeft.add(l3, 1, 0);
        gridPaneLeft.add(l4, 1, 1);

        scrollPaneLeft.setContent(gridPaneLeft);

        gridPaneRight.add(l5, 0, 0);
        gridPaneRight.add(l6, 0, 1);
        gridPaneRight.add(tf, 1, 0);
        gridPaneRight.add(tf2, 1, 1);

        scrollPaneRight.setContent(gridPaneRight);

    }

    
    
    
    /**
     * Exit program event from close button. When user click to the exit button,
     * question dialog is shown, if user is sure to close the application.
     *
     * @param stage Stage
     */
    public void exitProgram(Stage stage) {
        boolean b = new Dialog().question("Ukončení programu", "Opravdu si přejete ukončit program?", getStagePosition());
        if (b) {
            //communicator.disconnect();
            stage.close();
        }
    }

    /**
     * Get x, y, width and height of primary stage and width and height of
     * screen
     *
     * @return double[] array: x, y, width and height of primary stage, width
     * and height of screen
     */
    private double[] getStagePosition() {
        try {
            Stage stage = (Stage) myButton.getScene().getWindow();
            double x = stage.getX();
            double y = stage.getY();
            double w = stage.getWidth();
            double h = stage.getHeight();

            Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
            double mw = visualBounds.getWidth();
            double mh = visualBounds.getHeight();

            return new double[]{x, y, w, h, mw, mh};
        } catch (NullPointerException e) {
            return new double[]{0, 0, 0, 0, 0, 0};
        }

    }

}
