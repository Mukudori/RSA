package sample;

import javafx.fxml.FXML;

import java.awt.*;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;


public class Controller {
    @FXML
    TextField tfQ;
    @FXML
    TextField tfP;
    @FXML
    TextArea taOut;
    @FXML
    TextArea taInp;

    @FXML
    public void EncryptClick()
            throws Exception
    {
        RSA rsa = new RSA(Integer.parseInt(tfP.getText()), Integer.parseInt(tfQ.getText() ));
        taOut.setText(rsa.getEncrypt(taInp.getText()));
    }

    @FXML
    private void DecryptClick()
    {
        RSA rsa = new RSA(Integer.parseInt(tfP.getText()), Integer.parseInt(tfQ.getText() ));
        taOut.setText(rsa.getDecript(taInp.getText()));
    }


}
