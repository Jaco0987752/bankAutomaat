package ATM;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.*;

/**
 * main
 */
public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = LoadDoc( "/ATM/View/Welcome.fxml");
        if(root != null){
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }
    }

    private Parent LoadDoc( String strUrl) {
        try {
            URL url = getClass().getResource(strUrl);
            return FXMLLoader.load(url);

        } catch (NullPointerException e) {
            System.err.println("Can't find the specific view");
        } catch (LoadException e) {
            System.err.println("Error in View");
        } catch (Exception e){
            System.err.println(e);
        }
        return null;
    }

}