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
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.imageio.ImageIO;

/**
 *
 * @author Michiel
 */
public class FXMLQRScanner implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ImageView imgScanResult;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        BufferedImage image;
        Webcam webcam = Webcam.getDefault();
        
        if (webcam != null) {
            webcam.open();
            image = webcam.getImage();
            imgScanResult.setImage(SwingFXUtils.toFXImage(image, null));
            webcam.close();
        } else {
            image = null;
        }
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        try {
            System.out.println(readQRCode(image, "ISO-8859-1", hintMap));
        } catch (IOException | NotFoundException ex) {
            Logger.getLogger(FXMLQRScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
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
