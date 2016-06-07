/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
=======
import javafx.scene.Node;
>>>>>>> origin/Develop
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import klm4.Database;
import static klm4.ScreenControllers.FXMLQRScanner.barCode;
import klm4.ViewManager;

/**
 * FXML Controller class
 *
 * @author Michiel
 */

public class FXMLChecklistScreenController extends FXMLScreen
{

    String booked = "booked";
    String onTime = "onTime";
    String awb = "awb";
    String volume = "volume";
    String lable = "lable";
    String condition1 = "condition1";
    String weight = "weight";
    boolean bookedCounter;
    boolean onTimeCounter;
    boolean awbCounter;
    boolean volumeCounter;
    boolean weightCounter;
    boolean lableCounter;
    boolean conditionCounter;
    
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
    private ToggleButton rfcText;
    
    
        @FXML
    //BOOKED BUTTONS
    public void handleNegativeBooked(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "0", "booked");
        bookedCounter = false; 
    }
    
    public void handleNeutralBooked(ActionEvent event) throws SQLException 
    {
        updateData(barCode, null, "booked");
        bookedCounter = false;
    }
    
    public void handlePositiveBooked(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "1", "booked");
        bookedCounter = true;
    }
     
    //ONTIME BUTTONS
    public void handleNegativeOnTime(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "0", "onTime");
        onTimeCounter = false;
    }
    
    public void handleNeutralOnTime(ActionEvent event) throws SQLException 
    {
        updateData(barCode, null, "onTime");
        onTimeCounter = false;
    }
    
    public void handlePositiveOnTime(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "1", "onTime");
        onTimeCounter = true;
    }
    
    //AWB BUTTONS
    public void handleNegativeAWB(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "0", "awb");
        awbCounter = false;
    }
    
    public void handleNeutralAWB(ActionEvent event) throws SQLException 
    {
        updateData(barCode, null, "awb");
        awbCounter = false;
    }
    
    public void handlePositiveAWB(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "1", "awb");
        awbCounter = true;
    }  
    
    //VOLUME BUTTONS
    public void handleNegativeVolume(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "0", "volume");
        volumeCounter = false;
    }
    
    public void handleNeutralVolume(ActionEvent event) throws SQLException 
    {
        updateData(barCode, null, "volume");
        volumeCounter = false;
    }
    
    public void handlePositiveVolume(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "1", "volume");
        volumeCounter = true;
    } 
    
    //WEIGHT BUTTONS
    public void handleNegativeWeight(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "0", "weight");
        weightCounter = false;
    }
    
    public void handleNeutralWeight(ActionEvent event) throws SQLException 
    {
        updateData(barCode, null, "weight");
        weightCounter = false;
    }
    
    public void handlePositiveWeight(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "1", "weight");
        weightCounter = true;
    }
    
    //Lable BUTTONS
    public void handleNegativeLabel(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "0", "lable");
        lableCounter = false;
    }
    
    public void handleNeutralLabel(ActionEvent event) throws SQLException 
    {
        updateData(barCode, null, "lable");
        lableCounter = false;
    }
    
    public void handlePositiveLabel(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "1", "lable");
        lableCounter = true;
    } 
    
    //CONDITION BUTTONS
    public void handleNegativeCondition(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "0", "condition1");
        conditionCounter = false;
    }
    
    public void handleNeutralCondition(ActionEvent event) throws SQLException 
    {
        updateData(barCode, null, "condition1");
        conditionCounter = false;
    }
    
    public void handlePositiveCondition(ActionEvent event) throws SQLException 
    {
        updateData(barCode, "1", "condition1");
        conditionCounter = true;
    } 
    
    
    //RFC BUTTON
    public void handleRFC(ActionEvent event) throws SQLException 
    {

        if(bookedCounter && onTimeCounter && awbCounter && volumeCounter && weightCounter && lableCounter && conditionCounter) {
            String passed = "passed";
            String yes = "YES";
            
            //REDIRECT TO RFC SCREEN
            Node node = (Node) event.getSource();
            ViewManager view = new ViewManager();
            view.getScene("Screens/FXMLHomeScreen.fxml", node);
            
            //UPDATE RFC
            Database.insertQuery("UPDATE barcode" + " SET " + passed + "=" + "('" + yes + "')"
            + " WHERE barcodeID=" + "('" + barCode + "')");
            System.out.println("DATABASE UPDATE; RFC passed for barcode " + barCode + ".");
        
    } else {
            System.out.println("NOPE");
            //REDIRECT TO SCANNER SCREEN
            Node node = (Node) event.getSource();
            ViewManager view = new ViewManager();
            view.getScene("Screens/FXMLHomeScreen.fxml", node);
        }
    } 
    
    @FXML
    public void RFCsent(ActionEvent event) throws IOException
    {
       FXMLLoader loader = new FXMLLoader();
       Parent parent = loader.load(getClass().getResource("/klm4/Screens/FXMLAcceptedShipmentPop.fxml").openStream());
        FXMLScreen screen = loader.getController();
        Stage stage = new Stage();
        screen.start(stage);
        stage.setTitle("RFC has been sent");
        stage.setScene(new Scene(parent, 260, 230, Color.LIGHTCYAN));
        // Deze
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(root);
        stage.showAndWait();
        
        Node node = (Node) event.getSource();
            
        ViewManager view = new ViewManager(root);
        view.getScene("/klm4/Screens/FXMLHomeScreen.fxml", node);
        
       
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
        
        
    }
    
        public String selectData(String textField, String barCode) throws SQLException {
            ResultSet resultSet = Database.selectQuery("SELECT " + textField + " FROM barcode_gegevens WHERE barcodeID = " + barCode);
            resultSet.next();
            textField = resultSet.getString(textField);
            return textField;
        }
        
        public void updateData(String barCode, String value, String type) throws SQLException {
            Database.insertQuery("UPDATE barcode" + " SET " + type + "=" + "('" + value + "')"
            + " WHERE barcodeID=" + "('" + barCode + "')");
            System.out.println("DATABASE UPDATE; Column " + type + " heeft waarde " + value + " bij barcode " + barCode + ".");
        }
}

