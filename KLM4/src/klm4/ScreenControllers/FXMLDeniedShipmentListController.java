/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import klm4.Database;

/**
 * FXML Controller class
 *
 * @author Naomi
 */
public class FXMLDeniedShipmentListController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView deniedTable;
    
    @FXML
    public void handleBackButton(ActionEvent event) {
    Node node = (Node) event.getSource();
    ViewManager view = new ViewManager();
    view.getScene("Screens/FXMLHomeScreen.fxml", node);    
  
    }
    
    private void setupDeniedTable() {
        try {
            ResultSet resultSet = Database.selectQuery("SELECT barcode_gegevens.barcodeID, barcode_gegevens.booked, barcode_gegevens.ontime, barcode_gegevens.awb, barcode_gegevens.volume, barcode_gegevens.lable, barcode_gegevens.condition1, barcode_gegevens.weight FROM barcode INNER JOIN barcode_gegevens ON barcode.barcodeID=barcode_gegevens.barcodeID WHERE passed = 'NO'");
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

                deniedTable.getColumns().addAll(col);
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
            sortedData.comparatorProperty().bind(deniedTable.comparatorProperty());
            deniedTable.setItems(sortedData);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setupDeniedTable();
    }    
    
}
