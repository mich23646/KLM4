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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Rachel
 */
public class FXMLLoginScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    private Label lblStatus;
    
    public void Login(ActionEvent action)
    {
        if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass"))
        {
            lblStatus.setText("Login Succces");
        }
        else
        {
            lblStatus.setText("Login Fail");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
