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

public class FXMLChecklistScreenController implements Initializable {

    //Booked buttons
    @FXML
    public ToggleButton NegativeBooked, NeutralBooked,PositiveBooked ;
    
    @FXML
    public ToggleGroup Booked = new ToggleGroup();
    
    @FXML
    public ToggleGroup OnTime = new ToggleGroup();
    
    //On time buttons
    @FXML
    private ToggleButton NegativeOnTime,NeutralOnTime ,PositiveOnTime ;
   
    @FXML
    private void HandleButtonNegative(ActionEvent event) 
    {
        
        //Booked
        if(NegativeBooked.isSelected())
        {
            NegativeBooked.setId("ButtonNegativePressed");            
        }
        else
        {
            NegativeBooked.setId("ButtonNegative");
        }
        
        NeutralBooked.setSelected(false); NeutralBooked.setId("ButtonNeutral");
        PositiveBooked.setSelected(false); PositiveBooked.setId("ButtonPositive");
        
    }
    
    @FXML
    private void HandleButtonNeutral(ActionEvent event) 
    {
        //Booked
        if(NeutralBooked.isSelected())
        {
            NeutralBooked.setId("ButtonNeutralPressed");
        }
        else
        {
            NeutralBooked.setId("ButtonNeutral");
        }
        NegativeBooked.setSelected(false); NegativeBooked.setId("ButtonNegative");
        PositiveBooked.setSelected(false); PositiveBooked.setId("ButtonPositive");
        
    }
    
    @FXML
    private void HandleButtonPositive(ActionEvent event) 
    {
        //booked
        if(PositiveBooked.isSelected())
        {
            PositiveBooked.setId("ButtonPositivePressed");
        }
        else
        {
            PositiveBooked.setId("ButtonPositive");
        }
        NeutralBooked.setSelected(false); NeutralBooked.setId("ButtonNeutral");
        NegativeBooked.setSelected(false); NegativeBooked.setId("ButtonNegative");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        //Booked
        NegativeBooked.setToggleGroup(Booked);
        NeutralBooked.setToggleGroup(Booked);
        PositiveBooked.setToggleGroup(Booked);
        
        //OnTime
        NegativeOnTime.setToggleGroup(OnTime);
        NeutralOnTime.setToggleGroup(OnTime);
        PositiveOnTime.setToggleGroup(OnTime);
    }    
}
