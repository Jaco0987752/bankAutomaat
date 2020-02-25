package ATM.ViewModel;

import java.awt.Button;
import java.awt.Label;

/**
 * loginController
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class loginController {

    @FXML
    private Button SayHelloButton;
    
    @FXML
    private Label SayHelloField;

    @FXML
    protected void SayHello(ActionEvent event) {
        System.out.println("hello");
        //Window owner = submitButton.getScene().getWindow();
        //SayHelloField.setText("hello");
    }
    
}