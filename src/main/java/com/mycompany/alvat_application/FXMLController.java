package com.mycompany.alvat_application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FXMLController implements Initializable {

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
}
