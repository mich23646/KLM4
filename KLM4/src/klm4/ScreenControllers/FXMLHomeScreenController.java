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
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Michiel
 */

public class FXMLHomeScreenController implements Initializable {

    @FXML
    private void HandleScanPackage(ActionEvent event) {
        Node node = (Node) event.getSource();
        ViewManager view = new ViewManager();
        view.getScene("Screens/FXMLQrcodeScanner.fxml", node);
}
    
    @FXML
    private void HandleDeniedShipments(ActionEvent event) {
        Node node = (Node) event.getSource();
        ViewManager view = new ViewManager();
        view.getScene("Screens/FXMLDeniedShipmentList.fxml", node);
}
    
    @FXML
    private void HandleHandledShipments(ActionEvent event) {
        Node node = (Node) event.getSource();
        ViewManager view = new ViewManager();
        view.getScene("Screens/FXMLAcceptedShipmentList.fxml", node);
}


   
    @FXML
    private void HandleLogOut(ActionEvent event) {
        Node node = (Node) event.getSource();
        ViewManager view = new ViewManager();
        view.getScene("Screens/FXMLLoginScreen.fxml", node);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
    
  

