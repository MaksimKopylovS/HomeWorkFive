package packageClient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class AuthController implements Initializable {



    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;

    @FXML
    private Label labelInfo;

    @FXML
    private Button buttonSend;

    @FXML
    private Button buttonReg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void actionSend(){
        Main.getNetwork().sendMessage("/auth "+ loginTextField.getText() + " " + passTextField.getText());
    }

    public void actionReg(){

    }

    public Label getLabelInfo(){
        return labelInfo;
    }
}
