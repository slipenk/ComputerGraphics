package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StartPage {
    @FXML
    AnchorPane root;
    public void Go_to_info(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Video_helper.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_study(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Study_materials.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_fractals(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Fractals.fxml"));
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
}
