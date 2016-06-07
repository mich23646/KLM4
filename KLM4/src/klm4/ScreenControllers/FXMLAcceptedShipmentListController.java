/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import java.io.IOException;
import klm4.ViewManager;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.Node;
<<<<<<< HEAD
import javafx.stage.Stage;
=======
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import klm4.Database;
>>>>>>> origin/Develop

/**
 * FXML Controller class
 *
 * @author Naomi
 */
<<<<<<< HEAD
public class FXMLAcceptedShipmentListController extends FXMLScreen {
    
    public void Accept(ActionEvent event)
    {
        Node node = (Node) event.getSource();
            
        ViewManager view = new ViewManager(root);
        view.getScene("Screens/FXMLHomeScreen.fxml", node);
    }

=======
public class FXMLAcceptedShipmentListController implements Initializable {


    @FXML
    private TableView acceptedTable;
    
    @FXML
    public void handleBackButton(ActionEvent event) {
    Node node = (Node) event.getSource();
    ViewManager view = new ViewManager();
    view.getScene("Screens/FXMLHomeScreen.fxml", node);    
  
    }    
>>>>>>> origin/Develop
    

    private void setupAcceptedTable() {
        try {
            ResultSet resultSet = Database.selectQuery("SELECT barcode_gegevens.barcodeID, barcode_gegevens.booked, barcode_gegevens.ontime, barcode_gegevens.awb, barcode_gegevens.volume, barcode_gegevens.lable, barcode_gegevens.condition1, barcode_gegevens.weight FROM barcode INNER JOIN barcode_gegevens ON barcode.barcodeID=barcode_gegevens.barcodeID WHERE passed = 'YES'");
            ObservableList<ObservableList> data = FXCollections.observableArrayList();

            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY * ********************************
             */
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                final int j = i;

                TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i + 1).toUpperCase());
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                acceptedTable.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            // Loop through results
            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(resultSet.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
            }

            FilteredList filteredData = new FilteredList(data, p -> true);

            SortedList sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(acceptedTable.comparatorProperty());
            acceptedTable.setItems(sortedData);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setupAcceptedTable();
    }    
    
}
