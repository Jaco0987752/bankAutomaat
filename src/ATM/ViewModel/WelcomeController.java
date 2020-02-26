package ATM.ViewModel;

import ATM.Model.*;
import ATM.App;
import java.net.URL;
import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.ActionEvent;
// import java.awt.event;
//import javafx.event.EventHandler; 
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.stage.Stage;
//import java.awt.event.ActionListener;
//import javax.swing.Timer;
// import java.util.TimerTask;

/**
 * WelcomeController
 */
public class WelcomeController {

    @FXML
    private AnchorPane achorPane;

    @FXML
    private Label welcomeLabel;

    private CardChecker cardChecker = new CardChecker();

    Thread thread = new Thread() {
        public void run() {
            //Do some stuff in another thread
            delay(2000);
            System.out.println("card accepted"); 
            Platform.runLater(new Runnable() {
                public void run() {
                    goToNextPage();
                }
            });
        }
    };

    // Constructor must be public else the initialistion will fail 
    public WelcomeController() {
        thread.start();
    }

    public void goToNextPage() {
        App app = App.GetApp();
        app.ScreenLoader("Login");
    }

    private void delay(int millies) {
        try{
            Thread.sleep((long)millies);
        }catch (Exception e){
            System.out.println("Thread interrupted");
        }
    }

}