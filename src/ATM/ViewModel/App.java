package ViewModel;

import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Application;
import java.net.URL;
import Model.SerialReader;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * main
 */
public class App extends Application {

    SerialReader reader = new SerialReader();

    public static void main(String[] args) {
        launch(args);
    }

    private static App reference;

    public static App GetApp() {
        return reference;
    }

    private Stage stage; // Declare Stage

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        App.reference = this;
        
        ScreenLoader("Welcome");
    }

    // Show the view located in the view directory, don't add the file extension
    public void ScreenLoader(String view) {
        if (view == null) {
            System.err.println("view is not allowed to be null");
            return;
        }

        Parent root = LoadDoc("/View/" + view + ".fxml");
        if (root != null) {
            stage.setTitle("banking");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
    }

    // Load the fxml document
    private Parent LoadDoc(String strUrl) {
        try {
            URL url = getClass().getResource(strUrl);
            System.out.println(url);
            return FXMLLoader.load(url);
        } catch (NullPointerException e) {
            System.err.println("Can't find the specific view");
        } catch (IOException e) {
            System.out.println("IOExeption while loading view");
            System.out.println(e.toString());
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}