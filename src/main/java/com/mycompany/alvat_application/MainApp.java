package com.mycompany.alvat_application;

import com.mycompany.alvat_application.testing.IPMessageElement;
import com.mycompany.alvat_application.testing.MessageElement;
import com.mycompany.alvat_application.testing.NumberMessageElement;
import static com.mycompany.alvat_application.testing.ProcessIncommingMessage.processIncommingMessage;
import com.mycompany.alvat_application.testing.StringMessageElement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;


public class MainApp extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
        
        IPMessageElement m1 = new IPMessageElement("IP_ADRESS", "IP", "192.168.0.101", "IP ADRESSA", "R", "R");
        NumberMessageElement m2 = new NumberMessageElement("ITEM_ID", "ID", "1", "ID zařízení", "L", "RW", 0.0 , 0.0);
        StringMessageElement m3 = new StringMessageElement("CON_TYPE", "CT", "Ethernet", "Druh připojení", "L", "R", 0, 20);
        
        JSONArray incommingMessage = new JSONArray();
        incommingMessage.put(m1.parseToJSON());
        incommingMessage.put(m2.parseToJSON());
        incommingMessage.put(m3.parseToJSON());
        
        System.out.println(incommingMessage);
        
        MessageElement incommingData[];
        incommingData = processIncommingMessage(incommingMessage);
        
        for(MessageElement m : incommingData){
            m.showElement();
        }
        
    }

    
}
