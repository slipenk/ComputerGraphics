package sample;

import javafx.beans.binding.ObjectExpression;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AffineTransformation {
    @FXML
    private Spinner weight_sp;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane Place;
    @FXML
    private TextField AY;
    @FXML
    private TextField AX;
    @FXML
    private TextField BY;
    @FXML
    private TextField BX;
    @FXML
    private TextField CX;
    @FXML
    private TextField CY;
    @FXML
    private TextField KX;
    @FXML
    private TextField KY;
    @FXML
    private TextField Angle;
    @FXML
    private TextField Max_X;
    @FXML
    private TextField Max_Y;
    @FXML
    private TextField Step;
    @FXML
    private NumberAxis X_axis;
    @FXML
    private NumberAxis Y_axis;
    @FXML
    private LineChart<Number, Number> Charts;
    @FXML
    private RadioButton A_R;
    @FXML
    private RadioButton B_R;
    @FXML
    private RadioButton C_R;

    Boolean first = false;
    double x_center;
    double y_center;

    public void Download(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("*.png", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(root.getScene().getWindow());
        Image i = Place.snapshot(null, null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(i, null), "png", file);
        } catch (Exception e){
            System.out.println("Error");
        }
    }

    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }


    @FXML
    public void initialize() {
        Max_X.setText("10");
        Max_Y.setText("8");
        Step.setText("1");
        AX.setText("2");
        AY.setText("-2");
        BX.setText("4");
        BY.setText("3");
        CX.setText("4");
        CY.setText("-2");
        Angle.setText("90");
        KX.setText("1");
        KY.setText("1");

        addTextLimiter(Max_X,5);
        addTextLimiter(Max_Y,5);
        addTextLimiter(Step,5);
        addTextLimiter(AX,5);
        addTextLimiter(AY,5);
        addTextLimiter(BX,5);
        addTextLimiter(BY,5);
        addTextLimiter(CX,5);
        addTextLimiter(CY,5);
        addTextLimiter(KX,5);
        addTextLimiter(KY,5);

        Max_X.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    Max_X.setText(oldValue);
                }
            }
        });

        Max_Y.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    Max_Y.setText(oldValue);
                }
            }
        });

        Step.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    Step.setText(oldValue);
                }
            }
        });

        AX.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    AX.setText(oldValue);
                }
            }
        });

        AY.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    AY.setText(oldValue);
                }
            }
        });

        BX.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    BX.setText(oldValue);
                }
            }
        });

        BY.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    BY.setText(oldValue);
                }
            }
        });

        CX.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    CX.setText(oldValue);
                }
            }
        });

        CY.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    CY.setText(oldValue);
                }
            }
        });

        Angle.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    Angle.setText(oldValue);
                }
            }
        });

        KX.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    KX.setText(oldValue);
                }
            }
        });

        KY.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(-?)\\d*(\\.\\d*)?")) {
                    KY.setText(oldValue);
                }
            }
        });

    }

    private Boolean enter = false;
    //Функція створення координатної площини
    //Зчитуємо відповідні значення
    public void Create_Charts(ActionEvent actionEvent) {
        enter = true;
        enter_tr = false;
        X_axis.setAutoRanging(false);
        Y_axis.setAutoRanging(false);

        if(Step.getText().equals("") || Max_X.getText().equals("") || Max_Y.getText().equals("")
        || Step.getText().equals(".") || Max_X.getText().equals(".") || Max_Y.getText().equals("."))
        {
            Error_Empty();
            return;
        }







        X_axis.setTickUnit(Double.parseDouble(Step.getText()));
        Y_axis.setTickUnit(Double.parseDouble(Step.getText()));
        X_axis.setUpperBound(Double.parseDouble(Max_X.getText()));
        Y_axis.setUpperBound(Double.parseDouble(Max_Y.getText()));
        X_axis.setLowerBound(-(Double.parseDouble(Max_X.getText())));
        Y_axis.setLowerBound(-(Double.parseDouble(Max_Y.getText())));

        Charts.getData().clear();
    }

    double ax, ay, bx, by, cx, cy, angle, n, m, cosF, sinF, kx, ky;

    double[][] Mul_array;
    //сформований оптимальний матричний вираз
    void setVer()
    {

        Mul_array = new double[3][3];

        Mul_array[0][0] = kx*cosF;
        Mul_array[0][1] = ky*sinF;
        Mul_array[0][2] = 0.0;

        Mul_array[1][0]  = -kx*sinF;
        Mul_array[1][1] = ky*cosF;
        Mul_array[1][2] = 0.0;

        Mul_array[2][0] = x_center-kx*x_center+kx*(n*sinF-m*cosF + m);
        Mul_array[2][1] = ky*(-m*sinF - n*cosF + n)-ky*y_center+y_center;
        Mul_array[2][2] = 1.0;

    }


    double[] cAScale;
    double[] cBScale;
    double[] cCScale;
    //поворот та масштабування
    //відбувається звичайне перемноження матриць
    void Multiply(double[] arr1, double[] arr2, double[] arr3)
    {
        FindCenter(arr1, arr2, arr3);
        setVer();

        cAScale = new double[3];
        cBScale = new double[3];
        cCScale = new double[3];
        int count = -1;
            for (int j=0; j<3; ++j) {
                ++count;
                for (int k = 0; k < 3; ++k) {
                    cAScale[count] += arr1[k] * Mul_array[k][j];
                    cBScale[count] += arr2[k] * Mul_array[k][j];
                    cCScale[count] += arr3[k] * Mul_array[k][j];
                }
            }
    }
    //функція, яка викликає помилку при неправильному вводі значення кута
    void Error_Angle()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Angle must be between 0 and 360 degrees.\n Please, enter the correct angle!", ButtonType.OK);

        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            Charts.getData().clear();
        }
    }
    //функція знаходження центру трикутника
    void FindCenter(double[] A, double[] B, double[] C) {
        x_center = (A[0] + B[0] + C[0])/ 3;
        y_center = (A[1] + B[1] + C[1])/ 3;
    }
    //підпис вершин
    private  Node createDataNode(String text) {
        var label = new Label(text);
        var pane = new Pane(label);
        pane.setShape(new Circle(6.0));
        pane.setScaleShape(false);
        label.translateYProperty().bind(label.heightProperty().divide(-1.5));
        return pane;
    }
    private XYChart.Data<Number, Number> createData(double x, double y, String s) {
        XYChart.Data<Number, Number> data = new XYChart.Data<Number, Number>(x, y);
        data.setNode(createDataNode(s));
        return data;
    }
    //поворот та масштабуванння
    public void Rotate(ActionEvent actionEvent) {
        Charts.getData().clear();
        //зчитуємо відповідні дані

        if(!enter_tr && !enter || enter && !enter_tr)
        {
            Error_Rotate();
            return;
        }

        if(Angle.getText().equals("") || Angle.getText().equals(".") || KX.getText().equals("") || KY.getText().equals("")
                || KX.getText().equals(".") || KY.getText().equals(".")|| KX.getText().equals("-") || KY.getText().equals("-")
                || KX.getText().equals("-.") || KY.getText().equals("-."))
        {
            Error_Empty();
            return;
        }

        angle = Double.parseDouble(Angle.getText());
        if(0 < angle && angle > 360 )
        {
            Error_Angle();
            return;
        }
        kx = Double.parseDouble(KX.getText());
        ky = Double.parseDouble(KY.getText());





        if(A_R.isSelected())
        {
            if(!first) {
                m = AScaleMul[0];
                n = AScaleMul[1];
            }
            else
            {
                m = cAScale[0];
                n = cAScale[1];
            }
        } else if(B_R.isSelected()) {
            if(!first) {
                m = BScaleMul[0];
                n = BScaleMul[1];
            }
            else
            {
                m = cBScale[0];
                n = cBScale[1];
            }
        } else
        {
            if(!first) {
                m = CScaleMul[0];
                n = CScaleMul[1];
            }
            else
            {
                m = cCScale[0];
                n = cCScale[1];
            }
        }
        cosF = Math.cos(Math.toRadians(angle));
        sinF = Math.sin(Math.toRadians(angle));

        //Повертаємо та масштабуємо
        if(!first) {
            Multiply(AScaleMul, BScaleMul, CScaleMul);
            first = true;

        } else {
            Multiply(cAScale, cBScale, cCScale);
        }

        //вивід на екран
        ObservableList<XYChart.Data<Number, Number>> list = FXCollections.<XYChart.Data<Number, Number>>observableArrayList();
        list.add(createData(cAScale[0], cAScale[1], "A"));
        list.add(createData(cBScale[0], cBScale[1], "B"));
        list.add(createData(cCScale[0], cCScale[1], "C"));

        Charts.getData().add(new XYChart.Series<Number, Number>(list));

        XYChart.Series<Number, Number> series4 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series5 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series6 = new XYChart.Series<>();
        if(A_R.isSelected()) {
            series4.getData().add(new XYChart.Data<>(cBScale[0], cBScale[1]));
            series4.getData().add(new XYChart.Data<>(cAScale[0], cAScale[1]));
            series5.getData().add(new XYChart.Data<>(cBScale[0], cBScale[1]));
            series5.getData().add(new XYChart.Data<>(cCScale[0], cCScale[1]));
            series6.getData().add(new XYChart.Data<>(cAScale[0], cAScale[1]));
            series6.getData().add(new XYChart.Data<>(cCScale[0], cCScale[1]));
        } else if(B_R.isSelected())
        {
            series4.getData().add(new XYChart.Data<>(cAScale[0], cAScale[1]));
            series4.getData().add(new XYChart.Data<>(cBScale[0], cBScale[1]));
            series5.getData().add(new XYChart.Data<>(cBScale[0], cBScale[1]));
            series5.getData().add(new XYChart.Data<>(cCScale[0], cCScale[1]));
            series6.getData().add(new XYChart.Data<>(cAScale[0], cAScale[1]));
            series6.getData().add(new XYChart.Data<>(cCScale[0], cCScale[1]));
        }
        else {
            series4.getData().add(new XYChart.Data<>(cAScale[0], cAScale[1]));
            series4.getData().add(new XYChart.Data<>(cCScale[0], cCScale[1]));
            series5.getData().add(new XYChart.Data<>(cBScale[0], cBScale[1]));
            series5.getData().add(new XYChart.Data<>(cCScale[0], cCScale[1]));
            series6.getData().add(new XYChart.Data<>(cAScale[0], cAScale[1]));
            series6.getData().add(new XYChart.Data<>(cBScale[0], cBScale[1]));
        }

        Charts.getData().add(series4);
        Charts.getData().add(series5);
        Charts.getData().add(series6);
    }

    double[] AScaleMul;
    double[] BScaleMul;
    double[] CScaleMul;
    Boolean enter_tr = false;
    //функція створення трикутника
    public void Create_Triangle(ActionEvent actionEvent) {

        enter_tr = true;
        if(!enter)
        {
            Error_Not_Charts();
            return;
        }
        first = false;
        Charts.getData().clear();
        if(AX.getText().equals("") || AY.getText().equals("") || BX.getText().equals("") || BY.getText().equals("")
                || CX.getText().equals("") || CY.getText().equals("") || AX.getText().equals(".") || AY.getText().equals(".") || BX.getText().equals(".") || BY.getText().equals(".")
                || CX.getText().equals(".") || CY.getText().equals(".") || AX.getText().equals("-") || AY.getText().equals("-") || BX.getText().equals("-") || BY.getText().equals("-")
                || CX.getText().equals("-") || CY.getText().equals("-") || AX.getText().equals("-.") || AY.getText().equals("-.") || BX.getText().equals("-.") || BY.getText().equals("-.")
                || CX.getText().equals("-.") || CY.getText().equals("-.") )
        {
            Error_Empty();
            return;
        }





        ax = Double.parseDouble(AX.getText());
        ay = Double.parseDouble(AY.getText());
        bx = Double.parseDouble(BX.getText());
        by = Double.parseDouble(BY.getText());
        cx = Double.parseDouble(CX.getText());
        cy = Double.parseDouble(CY.getText());

        if(ax == bx && ay == by || ax == cx && ay == cy || bx == cx && by == cy)
        {
            Error_Triangle();
            return;
        }





        AScaleMul = new double[3];
        BScaleMul = new double[3];
        CScaleMul = new double[3];

        AScaleMul[0] = ax;
        AScaleMul[1] = ay;
        AScaleMul[2] = 1;
        BScaleMul[0] = bx;
        BScaleMul[1] = by;
        BScaleMul[2] = 1;
        CScaleMul[0] = cx;
        CScaleMul[1] = cy;
        CScaleMul[2] = 1;

        ObservableList<XYChart.Data<Number, Number>> list = FXCollections.<XYChart.Data<Number, Number>>observableArrayList();
        list.add(createData(AScaleMul[0], AScaleMul[1], "A"));
        list.add(createData(BScaleMul[0], BScaleMul[1], "B"));
        list.add(createData(CScaleMul[0], CScaleMul[1], "C"));

        Charts.getData().add(new XYChart.Series<Number, Number>(list));

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series3 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series4 = new XYChart.Series<>();
        series2.getData().add(new XYChart.Data<>(BScaleMul[0], BScaleMul[1]));
        series2.getData().add(new XYChart.Data<>(AScaleMul[0], AScaleMul[1]));
        series3.getData().add(new XYChart.Data<>(BScaleMul[0], BScaleMul[1]));
        series3.getData().add(new XYChart.Data<>(CScaleMul[0], CScaleMul[1]));
        series4.getData().add(new XYChart.Data<>(AScaleMul[0], AScaleMul[1]));
        series4.getData().add(new XYChart.Data<>(CScaleMul[0], CScaleMul[1]));
        Charts.getData().add(series2);
        Charts.getData().add(series3);
        Charts.getData().add(series4);

    }

    public void Go_to_info(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Video_helper.fxml"));
        root.getChildren().setAll(pane);

    }

    public void Go_to_color_scheme(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Color_scheme.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_fractals(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Fractals.fxml"));
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

    void Error_Triangle()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wrong coordinates of vertices. It must be a triangle!\n Please, enter the correct coordinates!", ButtonType.OK);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            Charts.getData().clear();
        }
    }

    void Error_Empty()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please, enter the number!", ButtonType.OK);
        alert.showAndWait();
    }
    void Error_Not_Charts()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please, create the coordinate plane!", ButtonType.OK);
        alert.showAndWait();
    }

    void Error_Rotate()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please, create the coordinate plane or triangle!", ButtonType.OK);
        alert.showAndWait();
    }

}
