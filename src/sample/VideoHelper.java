package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Collection;



public class VideoHelper {
    @FXML
    private MediaView mediaView;



    @FXML
    AnchorPane root;
    private MediaPlayer mediaPlayer;

    @FXML
    public void initialize() {
        File file = new File("resources/CG.mp4");
        mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
        mediaView.setFitHeight(289);
        mediaView.setFitWidth(562);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    public void Play_video(ActionEvent actionEvent) {
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING)
        {
            mediaPlayer.stop();
            mediaPlayer.play();
        } else {
            mediaPlayer.play();
        }
    }

    public void Stop_video(ActionEvent actionEvent) {
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
            mediaPlayer.play();
        } else {
            mediaPlayer.pause();
        }

    }


    public void Go_to_start_page(MouseEvent mouseEvent)  throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Start_page.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_color_scheme(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Color_scheme.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_triangle(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Affine_transformation.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_study_materials(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Study_materials.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_fractals(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Fractals.fxml"));
        root.getChildren().setAll(pane);
    }
}
