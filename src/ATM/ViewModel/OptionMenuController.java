package ViewModel;

/**
 * OptionMenuController
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;
import Model.LoginManager;

public class OptionMenuController   {

    @FXML
    private Label showmoney;

    @FXML
    public void initialize() {
        try {
            LoginManager login = LoginManager.tryLogin(1, 1);

            showmoney.setText("balance of " + login.getAccountname() + " is " + login.getBalance());


        } catch (Exception e) {
            System.err.println("Error while initialising optioncontroller :" + e.getMessage());
        }
    }
}