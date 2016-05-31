/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import klm4.Database;
import static klm4.ScreenControllers.FXMLQRScanner.barCode;

/**
 * FXML Controller class
 *
 * @author Michiel
 */

public class FXMLChecklistScreenController implements Initializable 
{

    String booked;
    String onTime;
    String awb;
    String volume;
    String lableCheck;
    String condition1;
    String weight;
    
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
        try {
            String barCode2 = "0101234567890128";
            ResultSet resultSet = Database.selectQuery("SELECT booked FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            booked = resultSet.getString("booked");
            
            resultSet = Database.selectQuery("SELECT ontime FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            onTime = resultSet.getString("ontime");
            
            resultSet = Database.selectQuery("SELECT awb FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            awb = resultSet.getString("awb");
            
            resultSet = Database.selectQuery("SELECT volume FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            volume = resultSet.getString("volume");
            
            resultSet = Database.selectQuery("SELECT weight FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            weight = resultSet.getString("weight");
            
            resultSet = Database.selectQuery("SELECT lable FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            lableCheck = resultSet.getString("lable");
            
            resultSet = Database.selectQuery("SELECT condition1 FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            condition1 = resultSet.getString("condition1");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLChecklistScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        NeutralBooked.setText("Booked\n   " + booked);
        NeutralOnTime.setText("OnTime\n  " + onTime);
        NeutralAWB.setText("AWB\n " + awb);
        NeutralVolume.setText("Volume\n " + volume);
        NeutralLabel.setText("Lable Check\n        " + lableCheck);
        NeutralCondition.setText("Condition\n    " + condition1);
        NeutralWeight.setText("Weight\n  " + weight);
    } 
        
}
