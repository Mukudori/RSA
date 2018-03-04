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
    public void EncryptClick()
    {
        taOut.setText(tfQ.getText()+tfP.getText());

    }


}
