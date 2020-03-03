package ViewModel;

import Model.*;
import ViewModel.App;
import java.net.URL;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * WelcomeController
 */
public class WelcomeController {

    @FXML
    private AnchorPane achorPane;

    @FXML
    private Label welcomeLabel;

    Thread thread;

    // Constructor must be public else the initialistion will fail 
    public WelcomeController() {
        thread = new Thread() {
            public void run() {
                //Do some stuff in another thread
                delay(2000);
                System.out.println("card accepted"); 
                Platform.runLater(new Runnable() {
                    public void run() {
                        App app = App.GetApp();
                        app.ScreenLoader("Login");
                    }
                });
            }
        };
        thread.start();
    }

    private void delay(int millies) {
        try{
            Thread.sleep((long)millies);
        }catch (Exception e){
            System.out.println("Thread interrupted");
        }
    }

}