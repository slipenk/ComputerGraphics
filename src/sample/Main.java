package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Color_scheme
        //Affine_transformation
        Parent root = FXMLLoader.load(getClass().getResource("Start_page.fxml"));
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 720, 512));
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}
