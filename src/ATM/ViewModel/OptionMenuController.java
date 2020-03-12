package ViewModel;

import Model.DataLoader;

/**
 * OptionMenuController
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.*;


public class OptionMenuController   {

    @FXML
    private Label showmoney;

    @FXML
    public void initialize() {
        try {
            JSONObject json = DataLoader.loadData("http://www.google.nl");
            if (json.has("balance")){
                long balance = json.getLong("balance");
                showmoney.setText(String.valueOf(balance));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}