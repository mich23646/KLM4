/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author Michiel
 */
public class FXMLChecklistScreenController implements Initializable {
    @FXML
    private ToggleButton toggleButtonNegative;
    @FXML
    private ToggleButton toggleButtonNeutral;
    @FXML
    private ToggleButton toggleButtonPositive;
    
   
    @FXML
    private void HandleButtonNegative(ActionEvent event) {
        if(toggleButtonNegative.isSelected()){
            toggleButtonNegative.setId("ButtonNegativePressed");            
      }
        else{
            toggleButtonNegative.setId("ButtonNegative");
        }
        toggleButtonNeutral.setSelected(false); toggleButtonNeutral.setId("ButtonNeutral");
        toggleButtonPositive.setSelected(false); toggleButtonPositive.setId("ButtonPositive");
    }
    @FXML
    private void HandleButtonNeutral(ActionEvent event) {
        if(toggleButtonNeutral.isSelected()){
            toggleButtonNeutral.setId("ButtonNeutralPressed");
      }
        else{
            toggleButtonNeutral.setId("ButtonNeutral");
        }
        toggleButtonNegative.setSelected(false); toggleButtonNegative.setId("ButtonNegative");
        toggleButtonPositive.setSelected(false); toggleButtonPositive.setId("ButtonPositive");
    }
    @FXML
    private void HandleButtonPositive(ActionEvent event) {
        if(toggleButtonPositive.isSelected()){
            toggleButtonPositive.setId("ButtonPositivePressed");
      }
        else{
            toggleButtonPositive.setId("ButtonPositive");
        }
        toggleButtonNeutral.setSelected(false); toggleButtonNeutral.setId("ButtonNeutral");
        toggleButtonNegative.setSelected(false); toggleButtonNegative.setId("ButtonNegative");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
