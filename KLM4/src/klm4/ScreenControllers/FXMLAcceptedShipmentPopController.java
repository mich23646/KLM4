/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import klm4.ViewManager;

/**
 * FXML Controller class
 *
 * @author Naomi
 */
public class FXMLAcceptedShipmentPopController extends FXMLScreen {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        public void Menu(ActionEvent event)
    {
        Node node = (Node) event.getSource();
        
        root.close();
    }
    
}
