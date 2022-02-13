package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class ColorScheme {
    @FXML
    private Button ResetB;
    @FXML
    private AnchorPane Original_image;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView Image_view_original;
    @FXML
    private AnchorPane Image_after_changes;
    @FXML
    private ImageView  Image_view_after;
    @FXML
    private RadioButton RGB;
    @FXML
    private RadioButton HSV;
    @FXML
    private Slider Slider_color;
    @FXML
    private TextField R;
    @FXML
    private TextField G;
    @FXML
    private TextField B;
    @FXML
    private TextField H;
    @FXML
    private TextField S;
    @FXML
    private TextField V;

    @FXML
    public void initialize()
    {
        RGB.setDisable(true);
        HSV.setDisable(true);
        Slider_color.setDisable(true);
        ResetB.setDisable(true);
        R.setEditable(false);
        G.setEditable(false);
        B.setEditable(false);
        H.setEditable(false);
        S.setEditable(false);
        V.setEditable(false);

    }

    ArrayList<Color> list_of_rgb;
    ArrayList<Color> list_of_rgb_from_hsv;
    ArrayList<ArrayList<Double>> list_of_hsv;
    ArrayList<Double> tempHSV;
    Color[][] colors;
    Color[][] colorsfromHSV;
    BufferedImage bufferedImage;
    BufferedImage img;

    //При зміні радіокнопок переходимо з однієї моделі в іншу
    public void RadioButtonChanged(ActionEvent actionEvent)  {
        if (RGB.isSelected()) {
            Slider_color.setDisable(false);
            ResetB.setDisable(false);
            SetRGB();
            print(colors);
        } else if (HSV.isSelected()) {
            Slider_color.setDisable(false);
            ResetB.setDisable(false);
            HSV();
        }
    }
    //Тут ми зчитуємо зображення та формуємо масив кольорів
    void SetRGB()
    {
        bufferedImage = new BufferedImage(img.getWidth(), img.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        list_of_rgb = new ArrayList<>();
        colors = new Color[img.getWidth()][img.getHeight()];
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                Color c = new Color(pixel, true);
                list_of_rgb.add(c);
                colors[x][y] = c;
            }

        }
    }

        //перехід в HSV
        void HSV()
        {
            SetRGB(); //зчитуємо зображення
            list_of_rgb_from_hsv = new ArrayList<>();
            list_of_hsv = new ArrayList<>();
            tempHSV = new ArrayList<>();
            double r, g, b;
            double h, s, v;
            //видобуваємо значення R, G, B
            for (Color ALI : list_of_rgb) {
                r = ALI.getRed();
                g = ALI.getGreen();
                b = ALI.getBlue();
                tempHSV = new ArrayList<>();

                   // Slider_color.getValue()
                rgb_to_hsv(r,g,b); //перетворюємо в HSV

                list_of_hsv.add(tempHSV); //додаємо нові значення в список HSV
            }
            int conter = -1;
            //Проходимося по списку HSV і міняємо на задану насиченість
            for (ArrayList<Double> ALI : list_of_hsv) {
                ++conter;
                h = ALI.get(0) * 360;
                if(h < 150 && h > 75)
                {
                   ALI.set(1,Slider_color.getValue()); //зміна насиченості
                   list_of_hsv.set(conter, ALI);
                }
            }

            //перехід з HSV до RGB
            for (ArrayList<Double> ALI : list_of_hsv) {
                h = ALI.get(0);
                s = ALI.get(1);
                v = ALI.get(2);

                double[] rgb = Arrays.copyOf(HSVtoRGB(h,s,v), 3); //функція переходу
                list_of_rgb_from_hsv.add(new Color((int)rgb[0], (int)rgb[1], (int)rgb[2]));
            }

            //формуємо масив пікселів задля виводу на екран
            int count = -1;
            colorsfromHSV = new Color[img.getWidth()][img.getHeight()];
            for (int x = 0; x < img.getWidth(); x++) {
                ++count;
                for (int y = 0; y < img.getHeight(); y++) {
                    colorsfromHSV[x][y] = list_of_rgb_from_hsv.get(count);
                    if(y+1 < img.getHeight())
                        ++count;
                }
            }

            print(colorsfromHSV); // вивід на екран

        }

        //функція виводу на екран. Закидаємо все в bufferedImage
         void print(Color [][] colors)
         {
             for (int x = 0; x < img.getWidth(); x++) {
                 for (int y = 0; y < img.getHeight(); y++) {
                     bufferedImage.setRGB(x, y, colors[x][y].getRGB());

                 }
             }
             Image image = SwingFXUtils.toFXImage(bufferedImage, null);
             Image_view_after.setPreserveRatio(false);
             Image_view_after.setImage(image); //встановлення зображення
         }

    //функція перетворення з rgb в hsv
    void rgb_to_hsv(double r, double g, double b){
        //переходимо від 0 до 1
        r = r / 255.0;
        g = g / 255.0;
        b = b / 255.0;

        //сформований алгоритм пошуку h, s, v
        double cmax = Math.max(r, Math.max(g, b));
        double cmin = Math.min(r, Math.min(g, b));
        //находимо v
        double h = 0, s, v = cmax;

        double d = cmax - cmin;
        //находимо s
        s = cmax == 0 ? 0 : d/cmax;

        //находимо h
        if(cmax == cmin)
        {
            h = 0;

        }
        else {
            if (cmax == r) {
                h = (g - b) / d + (g < b ? 6 : 0);
            } else if (cmax == g)
            {
                h = (b - r)/d + 2;
            }
            else if (cmax == b)
            {
                h = (r-g)/d +4;
            }
            h/=6;
        }

        tempHSV.add(h);
        tempHSV.add(s);
        tempHSV.add(v);
    }
    //функція перетворення з hsv  в rgb
    public static double[] HSVtoRGB(double h, double s, double v)
    {
        double r = 0, g = 0, b = 0;
        double i = Math.floor(h * 6);
        double f = h * 6 - i;
        double r_g_b = v * (1 - s);
        double q = v * (1 - f * s);
        double t = v * (1 - (1 - f) * s);
        double[] rgb = new double[3];
        //при відповідних умовах находимо r, g, b
        switch ((int)i % 6) {
            case 0:
                r = v;
                g = t;
                b = r_g_b;
               break;
            case 1:
                r = q;
                g = v;
                b = r_g_b;
               break;
            case 2:
                r = r_g_b;
                g = v;
                b = t;
                break;
            case 3:
                r = r_g_b;
                g = q;
                b = v;
                break;
            case 4:
                r = t;
                g = r_g_b;
                b = v;
                break;
            case 5:
                r = v;
                g = r_g_b;
                b = q;
            default: break;
        }
        //діапазон від 0 до 255
        rgb[0] = r * 255;
        rgb[1] = g * 255;
        rgb[2] = b * 255;
        return rgb;
    }
    //функція завантаження зображення у програму
    public void Upload(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        Stage stage = (Stage)Original_image.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image_view_original.setPreserveRatio(false);
            Image_view_original.setImage(new Image(file.toURI().toString()));
            img = ImageIO.read(file);
        }
        RGB.setDisable(false);
        HSV.setDisable(false);
    }
    //функція скачування зображення
    @FXML
    public void Download(ActionEvent actionEvent)
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("*.png", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(root.getScene().getWindow());
        Image i = Image_after_changes.snapshot(null, null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(i, null), "png", file);
        } catch (Exception e){
            System.out.println("Error");
        }
    }
    //кольоромір
    //шукаємо значення кольору координати, на яку наведена мишка
    public void On_Mouse_Moved(MouseEvent mouseEvent) {
       Image_view_original.setOnMouseMoved(e -> {
           int p = img.getRGB((int) e.getX(), (int) e.getY());
           Color color = new Color(p, true);
           R.setText(String.valueOf(color.getRed()));
           G.setText(String.valueOf(color.getGreen()));
           B.setText(String.valueOf(color.getBlue()));
           tempHSV = new ArrayList<>();
           rgb_to_hsv(color.getRed(), color.getGreen(), color.getBlue());
           H.setText(String.valueOf((int)(tempHSV.get(0)*360)));
           S.setText(String.valueOf(BigDecimal.valueOf(tempHSV.get(1)*100)
                   .setScale(1, RoundingMode.HALF_UP)
                   .doubleValue()));
           V.setText(String.valueOf(BigDecimal.valueOf(tempHSV.get(2)*100)
                   .setScale(1, RoundingMode.HALF_UP)
                   .doubleValue()));
       });

    }
    public void On_Mouse_Moved_after(MouseEvent mouseEvent) {
        Image_view_after.setOnMouseMoved(e -> {
            int p = img.getRGB((int) e.getX(), (int) e.getY());
            Color color = new Color(p, true);
            R.setText(String.valueOf(color.getRed()));
            G.setText(String.valueOf(color.getGreen()));
            B.setText(String.valueOf(color.getBlue()));
            tempHSV = new ArrayList<>();
            rgb_to_hsv(color.getRed(), color.getGreen(), color.getBlue());
            double h = tempHSV.get(0)*360;
            double s = tempHSV.get(1)*100;
            double v = tempHSV.get(2)*100;
            if(h < 150 && h > 75)
            {
                s = Slider_color.getValue();
            }
            H.setText(String.valueOf((int)h));
            S.setText(String.valueOf(BigDecimal.valueOf(s)
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue()));
            V.setText(String.valueOf(BigDecimal.valueOf(v)
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue()));

            double[] rgb = Arrays.copyOf(HSVtoRGB(tempHSV.get(0),tempHSV.get(1),tempHSV.get(2)), 3);
            R.setText(String.valueOf((int)rgb[0]));
            G.setText(String.valueOf((int)rgb[1]));
            B.setText(String.valueOf((int)rgb[2]));
        });
    }

    public void Reset_Satur(ActionEvent actionEvent) {
        Slider_color.setValue(1);
        HSV();
    }

    public void On_Mouse_Clicked(MouseEvent mouseEvent) {
        HSV();
    }

    public void On_Mouse_Pressed(MouseEvent mouseEvent) {
        HSV();
    }

    public void Go_to_info(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Video_helper.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_fractals(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Fractals.fxml"));
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
}
