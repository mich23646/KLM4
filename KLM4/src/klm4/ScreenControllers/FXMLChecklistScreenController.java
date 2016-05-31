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
import javafx.scene.input.KeyEvent;
import klm4.Database;
import static klm4.ScreenControllers.FXMLQRScanner.barCode;

/**
 * FXML Controller class
 *
 * @author Michiel
 */

public class FXMLChecklistScreenController implements Initializable 
{

    String booked = "booked";
    String onTime = "onTime";
    String awb = "awb";
    String volume = "volume";
    String lable = "lable";
    String condition1 = "condition1";
    String weight = "weight";
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
    
    
        @FXML
    public void handleNegativeBooked(ActionEvent event) throws SQLException 
    {
        Database.insertQuery("INSERT INTO barcode " + "(booked) "
        + "VALUES " + (0));
        
    } 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try {
            booked = selectData(booked, barCode);
            onTime = selectData(onTime, barCode);
            volume = selectData(volume, barCode);
            lable = selectData(lable, barCode);
            condition1 = selectData(condition1, barCode);
            weight = selectData(weight, barCode);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLChecklistScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        NeutralBooked.setText("Booked\n   " + booked);
        NeutralOnTime.setText("OnTime\n  " + onTime);
        NeutralAWB.setText("AWB\n " + awb);
        NeutralVolume.setText("Volume\n " + volume);
        NeutralLabel.setText("Lable Check\n        " + lable);
        NeutralCondition.setText("Condition\n    " + condition1);
        NeutralWeight.setText("Weight\n  " + weight);
        
        
        try {
            Database.insertQuery("INSERT INTO barcode " + "(barcodeID) "
                    + "VALUES " + (barCode));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLChecklistScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public String selectData(String textField, String barCode) throws SQLException {
            
            ResultSet resultSet = Database.selectQuery("SELECT " + textField + " FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            textField = resultSet.getString(textField);
            return textField;
        }
}
