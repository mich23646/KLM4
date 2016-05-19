/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Michiel
 */
public class KLM4 extends Application 
{
    @Override
    public void start(Stage stage) throws Exception 
    {
    stage.getIcons().add(
    new Image("/klm4/Resources/favicon.png"));
    stage.setTitle("KLM");
    ViewManager view = new ViewManager();
    view.getLoginForm(stage);
    
        //Database connection
        try 
        {
            Database.openConnection();
        } catch (SQLException e) 
        {
            System.err.println("DATABASE CREDENTIALS PROBABLY INCORRECT: " + e);
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);

        try 
        {
            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
}
