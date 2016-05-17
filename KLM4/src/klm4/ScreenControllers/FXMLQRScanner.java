/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4.ScreenControllers;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
public class FXMLQRScanner implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
     FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
        Window stage = null;
        File showOpenDialog = fileChooser.showOpenDialog(stage); 
    }
    
    public static void main(String[] args) throws WriterException, IOException,
   NotFoundException {
  String filePath = "D:/qrcode.35189288.png";
  String charset = "UTF-8"; // or "ISO-8859-1"
  Map hintMap = new HashMap();
  hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

  System.out.println("Data read from QR Code: "
    + readQRCode(filePath, charset, hintMap));
 }

 public static String readQRCode(String filePath, String charset, Map hintMap)
   throws FileNotFoundException, IOException, NotFoundException {
  BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
    new BufferedImageLuminanceSource(
      ImageIO.read(new FileInputStream(filePath)))));
  Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
    hintMap);
  return qrCodeResult.getText();
 }
}
      
    

