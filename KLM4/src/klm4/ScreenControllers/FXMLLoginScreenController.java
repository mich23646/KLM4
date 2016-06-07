/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import klm4.Database;
import klm4.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rachel
 */
public class FXMLLoginScreenController extends FXMLScreen {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblStatus;

    /**
     *
     * @param event
     * @throws java.sql.SQLException
     */
    
    @FXML
    public void handleEnterPressed(KeyEvent event) throws SQLException 
    {
        //OnKeyPressed only triggers on ENTER
        if (event.getCode() == KeyCode.ENTER) 
        {
            //Password + username validation check
        if (Database.getAuthentication(txtUserName.getText(), txtPassword.getText())) 
        {
            Node node = (Node) event.getSource();

            ViewManager view = new ViewManager(root);
            view.getScene("Screens/FXMLChecklistScreen.fxml", node);
            System.out.println("USER LOGGED IN.");
        } else 
        {
            lblStatus.setText("Login Fail");
        }
    }
    }

    public void Login(ActionEvent event) throws SQLException 
    {
            //Password + username validation check
        if (Database.getAuthentication(txtUserName.getText(), txtPassword.getText())) 
        {
            Node node = (Node) event.getSource();

            ViewManager view = new ViewManager(root);
            view.getScene("Screens/FXMLHomeScreen.fxml", node);
            System.out.println("USER LOGGED IN.");
        } else 
        {
            lblStatus.setText("Login Fail");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
