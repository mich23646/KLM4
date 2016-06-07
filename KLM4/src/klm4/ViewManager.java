/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import klm4.ScreenControllers.FXMLScreen;

/**
 *
 * @author Jelle
 */
public class ViewManager {
    
    private final Stage root;

    public ViewManager(Stage root) {
        this.root = root;
    }
    
    /**
     * Helper to set a new scene/view
     *
     * @param stage
     * @param parent
     */
    public void setScene(Stage stage, Parent parent) {
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param stage
     * @throws IOException
     */
    public void getLoginForm(Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass()
                .getResource("Screens/FXMLLoginScreen.fxml"));
        setScene(stage, parent);
    }

    /**
     *
     * @param view
     * @param node
     */
    public void getScene(String view, Node node) {
        try {
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent parent = loader.load(getClass().getResource(view).openStream());
            FXMLScreen screen = loader.getController();
            screen.start(stage);
            setScene(stage, parent);
        } catch(IOException e) {
            System.err.println(e);
        }
    }
    
}
    

