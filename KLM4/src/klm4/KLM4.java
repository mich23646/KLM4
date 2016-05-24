/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Michiel
 */
public class KLM4 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
    stage.getIcons().add(
    new Image("/klm4/Resources/favicon.png"));
    stage.setTitle("KLM");
    ViewManager view = new ViewManager();
    view.getLoginForm(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
