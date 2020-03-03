package ViewModel;

/**
 * loginController
 */

import ViewModel.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;


public class LoginController {
    
    Thread thread;

    // Constructor must be public else the initialistion will fail 
    public LoginController() {
        thread = new Thread() {
            public void run() {
                //Do some stuff in another thread
                delay(2000);
                System.out.println("pin accepted"); 
                Platform.runLater(new Runnable() {
                    public void run() {
                        App app = App.GetApp();
                        app.ScreenLoader("OptionMenu");
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