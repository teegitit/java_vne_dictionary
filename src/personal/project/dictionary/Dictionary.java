/*
 * Personal project
 * Anh - Viet Dictionary
 * Author: Tee Le
 * Created: 5/26/2020
 */
package personal.project.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class
 */
public class Dictionary extends Application {

    //Launches the application
    public static void main(String[] args) {
        launch(args);
    }

    //Sets up the stage and the scene
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dictionary.fxml"));
        primaryStage.setTitle("EN - VN Dictionary");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();

    }
}
