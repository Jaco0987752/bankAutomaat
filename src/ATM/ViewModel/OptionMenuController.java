package ViewModel;

/**
 * OptionMenuController
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.*;
import java.io.*;
import java.util.stream.*;
import com.google.gson.Gson;

public class OptionMenuController {

    @FXML
    private Label showmoney;

    @FXML
    public void initialize() {
        try {
            // URL yahoo = new URL("http://localhost/test.json");
            // URLConnection yc = yahoo.openConnection();
            // BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            // Gson gson = new Gson();
            // gson.fromJson(in, Model.Money.class);
            // in.close();
            showmoney.setText("AHOJ");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}