package com.mycompany.alvat_application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FXMLController implements Initializable {

    @FXML
    private Button myButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private ScrollPane scrollPane;

    GridPane grid2 = new GridPane();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    private void callMyButton(ActionEvent event) {
        System.out.println("Bla");
        myButton.setText("Button");

        Button b1 = new Button("ButtonI1");
        
        for (int i = 0; i < 30; i++) {
            grid2.add(new Button("butonxy"),0,i);
        }
       
        scrollPane.setContent(grid2);

    
        
        /*gridPane.add(new Button("Button"), 0, i);
        i++;*/
    }
}
