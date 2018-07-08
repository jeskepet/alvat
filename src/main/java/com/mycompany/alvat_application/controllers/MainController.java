package com.mycompany.alvat_application.controllers;

import com.mycompany.alvat_application.model.IPMessageElement;
import com.mycompany.alvat_application.model.MessageElement;
import com.mycompany.alvat_application.model.NumberMessageElement;
import static com.mycompany.alvat_application.model.ProcessIncommingMessage.processIncommingMessage;
import com.mycompany.alvat_application.model.StringMessageElement;
import com.mycompany.alvat_application.view.Dialog;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.json.JSONArray;

public class MainController implements Initializable {

    @FXML
    private Button myButton;

    @FXML
    private ScrollPane scrollPaneLeft;

    @FXML
    private ScrollPane scrollPaneRight;

    private GridPane gridPaneLeft; //contains 
    private GridPane gridPaneRight;
    private ArrayList<TextField> gridPaneRightTextFields;

    private ArrayList<MessageElement> readOnlyElements;
    private ArrayList<MessageElement> rwElements;

    @FXML
    private ListView myListView;

    private static final ObservableList<String> logs = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void callMyButton(ActionEvent event) {
        generateBubleGum();
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button o = (Button) event.getSource();
        String name = o.getId();
        //System.out.println(name + " clicked!");
        logs.add(name + " clicked!");
        myListView.setItems(logs);
    }

    @FXML
    private void handleToggleButton(ActionEvent event) {
       generateBubleGum();
    }

    public void generateBubleGum() {

        IPMessageElement m1 = new IPMessageElement("IP_ADRESS", "IP", "192.168.0.101", "IP ADRESSA", "R", "RW");
        NumberMessageElement m2 = new NumberMessageElement("ITEM_ID", "ID", "1", "ID zařízení", "L", "RW", 0.0, 0.0);
        StringMessageElement m3 = new StringMessageElement("CON_TYPE", "CT", "Ethernet", "Druh připojení", "L", "R", 0, 20);

        JSONArray incommingMessage = new JSONArray();
        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());
        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        System.out.println(incommingMessage);

        MessageElement incommingData[];
        incommingData = processIncommingMessage(incommingMessage);
        updateView(incommingData);

    }

    /**
     * Updates view based on incoming data, aka updates both panes. Read only
     * elements will be placed to the left pane. RW and W elements will be
     * placed to the right pane.
     *
     * @param data
     */
    public void updateView(MessageElement[] data) {

        if (data.length > 0) {

            readOnlyElements = new ArrayList<>();
            rwElements = new ArrayList<>();
            gridPaneLeft = new GridPane();
            gridPaneRight = new GridPane();
            gridPaneRightTextFields = new ArrayList();

            Label l1, l2;
            TextField tf;

            for (MessageElement m : data) {

                if ("R".equals(m.getRW())) {
                    readOnlyElements.add(m);

                    l1 = new Label(m.getLabel());
                    l2 = new Label(m.getValue());

                    gridPaneLeft.add(l1, 0, readOnlyElements.indexOf(m));
                    gridPaneLeft.add(l2, 1, readOnlyElements.indexOf(m));

                } else {
                    rwElements.add(m);

                    l1 = new Label(m.getLabel());
                    tf = new TextField();
                    tf.setText(m.getValue());
                    gridPaneRightTextFields.add(tf);

                    gridPaneRight.add(l1, 0, rwElements.indexOf(m));
                    gridPaneRight.add(tf, 1, rwElements.indexOf(m));
                }
            }

            gridPaneLeft.setVgap(8);
            gridPaneLeft.setHgap(12);
            gridPaneRight.setVgap(8);
            gridPaneRight.setHgap(12);

            scrollPaneLeft.setContent(gridPaneLeft);
            scrollPaneRight.setContent(gridPaneRight);
        }
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
