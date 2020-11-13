package packageClient;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegController implements Initializable {


    //private Network network;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private TextField textFieldPass;

    @FXML
    private Button buttonSend;

    @FXML
    private Label labelRegOk;

    public Label getLabelRegOk(){
        return labelRegOk;
    }


    public void actionButtonSend() {
        Main.getNetwork().sendMessage("/reg " + textFieldLogin.getText() + " " + textFieldPass.getText());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
