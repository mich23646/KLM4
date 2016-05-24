/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import klm4.ViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Naomi
 */
public class FXMLDeniedShipmentListController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    public void Denied(ActionEvent event)
    {
        Node node = (Node) event.getSource();
            
        ViewManager view = new ViewManager();
        view.getScene("Screens/FXMLHomeScreen.fxml", node);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
