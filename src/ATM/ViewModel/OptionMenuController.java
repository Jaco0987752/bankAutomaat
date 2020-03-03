package ViewModel;

/**
 * OptionMenuController
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;

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