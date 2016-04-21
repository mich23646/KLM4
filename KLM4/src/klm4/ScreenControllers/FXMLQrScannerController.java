/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.imageio.ImageIO;

/**
 *
 * @author Michiel
 */
public class FXMLQrScannerController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction1(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Window stage = null;
        
        File showOpenDialog = fileChooser.showOpenDialog(stage);
        System.out.print(showOpenDialog.getPath());
        
        
	}
        
            

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
