package com.mycompany.alvat_application;

import com.mycompany.alvat_application.controllers.MainController;
import com.mycompany.alvat_application.model.IPMessageElement;
import com.mycompany.alvat_application.model.MessageElement;
import com.mycompany.alvat_application.model.NumberMessageElement;
import static com.mycompany.alvat_application.model.ProcessIncommingMessage.processIncommingMessage;
import com.mycompany.alvat_application.model.StringMessageElement;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.JSONArray;

public class MainApp extends Application {

    Stage window;
    MainController mc;

    /**
     * Startup the application.
     *
     * @param stage Stage
     * @throws Exception IOException if Scene.fxml or Style.css is not found
     */
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader;
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
            Pane p = (Pane) fxmlLoader.load();
            mc = fxmlLoader.<MainController>getController();
            Scene scene = new Scene(p);
            scene.getStylesheets().add("/styles/Styles.css");
            stage.setScene(scene);
            stage.setOnCloseRequest(e -> {
                e.consume();
                mc.exitProgram(stage);
            });
            try {
                File f = new File("icons/alvat.png");
                stage.getIcons().add(new Image(f.toURI().toString()));
            } catch (Exception e) {

            }
            stage.setTitle("Gateway Configurator | Alvat");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        IPMessageElement m1 = new IPMessageElement("IP_ADRESS", "IP", "192.168.0.101", "IP ADRESSA", "R", "R");
        NumberMessageElement m2 = new NumberMessageElement("ITEM_ID", "ID", "1", "ID zařízení", "L", "RW", 0.0, 0.0);
        StringMessageElement m3 = new StringMessageElement("CON_TYPE", "CT", "Ethernet", "Druh připojení", "L", "R", 0, 20);

        JSONArray incommingMessage = new JSONArray();
        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());

        System.out.println(incommingMessage);

        MessageElement incommingData[];
        incommingData = processIncommingMessage(incommingMessage);

        /*for (MessageElement m : incommingData) {
            m.showElement();
        }*/

    }

    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
