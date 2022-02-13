package sample;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;




import javafx.event.ActionEvent;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Fractals {
    @FXML
    protected Label label;
    @FXML
    protected TextField Number;
    @FXML
    protected RadioButton T_fractal;
    @FXML
    protected RadioButton H_fractal;
    @FXML
    protected RadioButton Red;
    @FXML
    protected RadioButton Yellow;
    @FXML
    protected RadioButton Black;
    @FXML
    protected AnchorPane Fractal;
    @FXML
    protected AnchorPane root;
    private Canvas canvas ;
    private GraphicsContext gContext;
    double x, y, a;

    public void initialize() {
            Number.setText("1");
            Number.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("^([1-9]|10)$")) {
                        Platform.runLater(() -> {
                            Number.clear();
                        });
                    }
                }
            });
    }
    @SuppressWarnings("unused")
    @FXML
    public void Download(ActionEvent actionEvent)
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("*.png", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(root.getScene().getWindow());
        Image i = Fractal.snapshot(null, null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(i, null), "png", file);
        } catch (Exception e){}
    }


    @SuppressWarnings("unused")
    @FXML
    public void Create_Fractal(ActionEvent actionEvent)
    {
        Fractal.getChildren().remove(canvas);
        canvas = new Canvas(Fractal.getHeight(), Fractal.getWidth());
        gContext = canvas.getGraphicsContext2D();


        if(Number.getText().equals(""))
        {
            Error_Empty();
            return;
        }



        //gContext.setFill(Color.rgb(255, 230, 143));
       // gContext.setStroke(Color.rgb(255, 230, 143));
        if (Red.isSelected()) {
            gContext.setFill(Color.RED);
            gContext.setStroke(Color.RED);
        } else if (Yellow.isSelected())
        {
            gContext.setFill(Color.rgb(255, 230, 143));
            gContext.setStroke(Color.rgb(255, 230, 143));
        }
        else if (Black.isSelected())
        {
            gContext.setFill(Color.BLACK);
            gContext.setStroke(Color.BLACK);
        }




        x = canvas.getWidth() / 2;
        y = canvas.getHeight() / 2;
        a = Math.min(canvas.getHeight(), canvas.getWidth() * 0.5);
        if(Integer.parseInt(Number.getText()) > 7 && H_fractal.isSelected())
        {
            H_fractal();

        }


       if (T_fractal.isSelected()) {
            drawTSquare(Integer.parseInt(Number.getText())-1, x, y, a);
        } else {
            drawH(Integer.parseInt(Number.getText())-1, x, y, 85);
        }
        Fractal.getChildren().add(canvas);
    }

    void H_fractal()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "With increasing iteration, the changes will\n not be noticeable", ButtonType.OK);
        alert.showAndWait();
    }

    //Функція побудови T-фракталу. n - кількість ітерацій, x - половина ширини канвасу,
    //y - половина висоти канвасу, a - мінімальне з поміж висоти канвасу та
    // половини ширини канвасу

    public void drawTSquare(int n, double x, double y, double a) {
        double x1, y1, x2, y2, x3, y3, x4, y4;
        //функція, яка будує квадрат
        gContext.fillRect(x - a / 2, y - a / 2, a, a);

        //шукаємо нові позиції (x;y) початкової точки квадрату.
        x1 = x - a / 2;
        y1 = y - a / 2;

        x2 = x + a / 2;
        y2 = y1;

        x3 = x1;
        y3 = y + a / 2;

        x4 = x2;
        y4 = y3;

        //рекурсія
        if (n > 0) {
            drawTSquare(n - 1, x1, y1, a / 2);
            drawTSquare(n - 1, x2, y2, a / 2);
            drawTSquare(n - 1, x3, y3, a / 2);
            drawTSquare(n - 1, x4, y4, a / 2);
        }
    }

    //Функція побудови H-фракталу. cycles - кількість ітерацій, centerX - половина ширини канвасу,
    //centerY - половина висоти канвасу, length - довжина
    public void drawH(int cycles, double centerX, double centerY, double length) {

        //малюємо лінії
        gContext.setLineWidth(1.0);
        gContext.strokeLine(centerX - length, centerY - length, centerX - length, centerY + length);
        gContext.strokeLine(centerX + length, centerY - length, centerX + length, centerY + length);
        gContext.strokeLine(centerX - length, centerY, centerX + length, centerY);
        if (cycles == 0) {
            return;
        }
        //рекурсія
        drawH(cycles - 1, centerX - length, centerY + length, length / 2);
        drawH(cycles - 1, centerX - length, centerY - length, length / 2);
        drawH(cycles - 1, centerX + length, centerY + length, length / 2);
        drawH(cycles - 1, centerX + length, centerY - length, length / 2);
    }


    public void Go_to_info(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Video_helper.fxml"));
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

    public void Go_to_start_page(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Start_page.fxml"));
        root.getChildren().setAll(pane);
    }

    void Error_Empty()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please, enter the number!", ButtonType.OK);
        alert.showAndWait();
    }
}
