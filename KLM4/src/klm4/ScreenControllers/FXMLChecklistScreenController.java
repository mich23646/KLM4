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
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Michiel
 */

public class FXMLChecklistScreenController implements Initializable 
{

    //Booked buttons
    @FXML
    public ToggleButton NegativeBooked, NeutralBooked ,PositiveBooked ;
    
    //On time buttons
    @FXML
    private ToggleButton NegativeOnTime, NeutralOnTime , PositiveOnTime ;
   
    //AWB Check Buttons
    @FXML 
    private ToggleButton NegativeAWB, NeutralAWB, PositveAWB; 
    
    //Volume Buttons
    @FXML
    private ToggleButton NegativeVolume, NeutralVolume, PositveVolume;
    
    //Weight buttons
    @FXML
    private ToggleButton NegativeWeight, NeutralWeight, PositiveWeight;
   
    //Label Check
    @FXML 
    private ToggleButton NegativeLabel, NeutralLabel, PositiveLabel;
    
    @FXML
    private ToggleButton NegativeCondition, NeutralCondition, PositiveCondition;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
}
