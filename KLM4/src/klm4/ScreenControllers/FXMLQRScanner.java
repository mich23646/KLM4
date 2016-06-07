/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import klm4.Database;
import klm4.ViewManager;

/**
 *
 * @author Michiel
 */
public class FXMLQRScanner extends FXMLScreen {
  
    public static String barCode;
    @FXML
    private Label label;
    @FXML
    private Label QRMessage;
    @FXML
    private ImageView imgScanResult;

    @FXML
    public void handleButtonAction(ActionEvent event) {
        BufferedImage image;
        Webcam webcam = Webcam.getDefault();
        barCode = null;
        
        webcam.open();
        while ( barCode == null){
            if (webcam != null) {
                
                image = webcam.getImage();
                imgScanResult.setImage(SwingFXUtils.toFXImage(image, null));
                
            } else {
                image = null;
            }
            Map hintMap = new HashMap();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            try {
                barCode = readQRCode(image, "ISO-8859-1", hintMap);
                System.out.println(barCode);
            } catch (IOException | NotFoundException ex) {
                System.out.println("SCANNING BARCODE...");
            }
        }
        webcam.close();
        System.out.println(barCode); 
        
<<<<<<< HEAD
        Node node = (Node) event.getSource();
        ViewManager view = new ViewManager(root);
        view.getScene("Screens/FXMLChecklistScreen.fxml", node);
=======
        try {
            Database.insertQuery("INSERT INTO barcode " + "(barcodeID) "
                    + "VALUES " + "('" + barCode + "')");
            Node node = (Node) event.getSource();
            ViewManager view = new ViewManager();
            view.getScene("Screens/FXMLChecklistScreen.fxml", node);
            
        } catch (SQLException ex) {
            System.out.println("DATABASE INFO; barcode " + barCode + " is al in gebruik.");
            QRMessage.setText("Barcode " + barCode + " is al in gebruik!");
        }
        
>>>>>>> origin/Develop
    }

 
    
    public static void main(String[] args) {

    }

    public static String readQRCode(BufferedImage image, String charset, Map hintMap)
            throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(image)));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
                hintMap);
        return qrCodeResult.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
