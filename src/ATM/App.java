package ATM;


import javafx.stage.Stage;
import java.lang.*;
import javafx.application.Application;
import ATM.Util.ScreenManager;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * main
 */
public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    private static App reference;
    
    public static App GetApp(){
        return reference;
    }
    
    private Stage stage; // Declare static Stage

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        App.reference = this;
        ScreenLoader("Welcome");
    }

        // Show the view located in the view directory, don't add the file extension 
        public void ScreenLoader(String view){
            if (view == null) { System.err.println("view is not allowed to be null"); return;}
             
            Parent root = LoadDoc( "/ATM/View/" + view + ".fxml");
            if(root != null){
                stage.setTitle("banking");
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
            }
        }
    
        // Load the fxml document
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
}