package ATM.ViewModel;

import ATM.Model.*;
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
            Platform.runLater(new Runnable() {
                
                public void run() {
                    System.out.println("go");
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
        System.out.println("card accepted");
        Stage stage = (Stage) achorPane.getScene().getWindow();
        Parent par = LoadDoc("/ATM/View/Login.fxml");
        if (par != null){
        Scene scene = new Scene(par);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }
    }

    private Parent LoadDoc(String strUrl) {
        try {
            URL url = getClass().getResource(strUrl);
            return FXMLLoader.load(url);

        } catch (NullPointerException e) {
            System.err.println("Can't find the specific view");
        } catch (LoadException e) {
            System.err.println("Error in View");
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    private void delay(int millies) {
        try{
            Thread.sleep((long)millies);
        }catch (Exception e){
            System.out.println("Thread interrupted");
        }
    }

}