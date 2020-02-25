package ATM;

import ATM.Model.Model;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.*;
// import java.io.*;
// import java.security.*;
// import java.lang.reflect.*;

/**
 * main
 * 
 *
 */
public class App extends Application {

    private Model model = new Model();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoadDoc(primaryStage, "/ATM/View/Welcome.fxml");
    }

    private void LoadDoc(Stage stage, String strUrl) {
        try {
            URL url = getClass().getResource(strUrl);
            Parent root = FXMLLoader.load(url);
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (NullPointerException e) {
            System.err.println("Can't find the specific view");
        } catch (LoadException e) {
            System.err.println("Error in View");
        } catch (Exception e){
            System.err.println(e);
        }
    }

}