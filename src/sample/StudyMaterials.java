package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.io.File;
import java.io.IOException;

public class StudyMaterials {
    @FXML
    AnchorPane root;
    @FXML
    private ImageView image_first;
    @FXML
    private ImageView image_second;
    @FXML
    private Label label1;
    @FXML
    private Label label2;

    @FXML
    private TextArea textArea;
    @FXML
    public void initialize() {
        textArea.setEditable(false);
        textArea.setWrapText(true);


    }

    public void Info_Fractal(ActionEvent actionEvent) {
        textArea.setText("The concepts of fractal and fractal geometry, which appeared in the late 70's, have been firmly used by mathematicians and programmers since the mid-80's. The word fractal is derived from the Latin \"fractus\", which means \"one consisting of fragments\". It was proposed by Benoit Mandelbrot in 1975 to denote the irregular but self-similar structures he dealt with. The birth of fractal geometry is associated with the 1977 publication of Mandelbrot's book, The Fractal Geometry of Nature. His works use the scientific results of other scientists who worked in the same field in the period 1875-1925 (Poincaré, Fatou, Julia, Cantor, Hausdorf). But only in our time has it been possible to combine their work into a single system.\n" +
                "\n" +
                "The role of fractals in computer graphics is great today. They come to the rescue, for example, when you need to use several coefficients to set the lines and surfaces of a very complex shape. From the point of view of computer graphics, fractal geometry is indispensable in the generation of artificial clouds, mountains, sea surfaces. In fact, a way has been found to easily represent complex objects that look like natural ones.\n" +
                "\n" +
                "One of the main properties of fractals is self-similarity. In the simplest case, a small part of a fractal contains information about the whole fractal.\n" +
                "\n" +
                "Mandelbrot's definition of a fractal is: \"A fractal is a structure that consists of parts that are in some sense similar to the whole.\"" +
                "Geometric fractals\n" +
                "Fractals of this class are the most obvious. This type of fractals is formed by simple geometric constructions. For example, in the two-dimensional case, they are obtained using some broken (or surface in the three-dimensional case), called a generator. In one step of the algorithm, each of the segments (components of the polyline) is replaced by a polyline generator, in the appropriate scale. As a result of endless repetition of this procedure, a geometric fractal is obtained.\n" +
                "\n" +
                "H-fractal. To construct this fractal, build a figure in the form of the letter H, in which the vertical and horizontal segments are equal. Then each of the 4 vertices of the figure is assigned a copy, halved. Again, to each end (there are already 16) it is necessary to assign copies of the letter H, reduced by 4 times. And so on. If the number of steps is directed to infinity, you get a fractal, which visually almost fills a square. H-fractal is dense everywhere in it. That is, in any neighborhood of any point of the square there are points of a fractal.\n" +
                "\n" +
                "T-fractal. Probably, this fractal got this name because of its resemblance to a reishina with a perpendicular bar attached in the form of the letter T. In English, this instrument is called - T-square.\n" +
                "\n" +
                "The construction of a T-fractal begins with a unit square. In the first step, you need to paint a white square in the center with a side of 1/2. Then you need to mentally divide the square into 4 equal squares and in the center of each of them paint a square with side ¼. Then each of these 4 squares is again divided into 4 parts, a total of 16 squares, and with each of them you need to repeat the procedure. And so on indefinitely.");
        label1.setText("T-square fractal");
        label2.setText("  H tree fractal");
        image_first.setPreserveRatio(false);
        image_second.setPreserveRatio(false);

        image_first.setImage(new Image ("resources/T_square.png"));
        image_second.setImage(new Image ("resources/H_tree.png"));
    }

    public void Info_Color_scheme(ActionEvent actionEvent) {
        textArea.setText("Color can be obtained in the process of radiation and in the process of reflection, so there are two opposite methods of color description: the system of additive colors and the system of subtractive colors. The concept of color model is used for mathematical description of color. Colors in nature are rarely simple. Most color shades are formed by mixing primary colors. The method of decomposing color into its constituent components is called the color model. The whole set of colors that can be created in a color model is called the color range.\n" +
                "\n" +
                "Color models are required to mathematically describe the range of colors visible on the monitor screen or on scanning and printing devices. Colors are represented by the model as a result of mixing several basic (primary) colors of which they consist. Each base color has its own range of intensity. When compiling all the base colors with different intensities, the colors available for this model are formed. Color ranges of models may vary. Additive color model RGB\n" +
                "The additive color model is the easiest to understand. It is a rather artificial method, as it is dictated by the technology of manufacturing cathode ray tubes. This is a hardware-oriented model in which colors are described by adding three basic colors - red, green, blue - in different proportions. Therefore, the RGB model is called additive (from the English. \"Add\" add, add). Colors are also called RGB color channels.\n" +
                "\n" +
                "The model is named after the first letters of English words:\n" +
                "\n" +
                "R (RED) - red;\n" +
                "\n" +
                "G (GREEN) - green;\n" +
                "\n" +
                "B (BLUE) - blue.\n" +
                "\n" +
                "Each of the base colors can take an intensity (saturation) in the range from 0 to 255. The total number of colors represented by this model is 256*256*256 = 16 777 216. The RGB model describes the colors obtained by mixing light rays. This model is used by monitors, TVs, scanners, slide projectors, colored advertising lamps and other devices in which the color is obtained by mixing light beams. It is also used to describe colors on web pages in a special hexadecimal format (#RRGGBB).\n" +
                "\n" +
                "By changing the intensity of the colored dots, you can create a wide variety of shades. If the intensity of each of them is maximum (255), then white is obtained. The absence of all three colors gives black. If all colors are mixed with the same intensity (but not the maximum and not the minimum), we get a gray color.\n" +
                "\n" +
                "A single cube with color distribution along single vectors is most often used to represent the additive model (Fig. 3). The start of reference (0,0,0) corresponds to black. The maximum value of RGB (1,1,1) corresponds to white, (1; 0; 0) - red, (0; 1; 0) - green, (0; 0; 1) - blue.\n" +
                "\n" +
                "Today, the RGB system is the official standard. By the decision of the International Commission on Lighting (ICO) in 1931 the basic colors were standardized. The Commission recommended the use of the following monochromatic colors as R, G, B: wavelengths for R - 700 nm, for G - 546.1 nm, for B - 435.8 nm.\n" +
                "\n" +
                "The disadvantage of the RGB model is that not all the colors formed in it can be printed. However, more than 16 million colors presented in RGB are quite sufficient for practical needs. In other words, the colors on the screen of your monitor may look different when printed, and this distinction may be fundamental, rather than due to the low quality of the printer or monitor." +
                "NSV model\n" +
                "\n" +
                "The HSV was created by Alvie Smith in 1978. It is convenient to represent in the form of a light hexagonal pyramid. In this case, the value V is plotted on the vertical axis, and the distance from the axis to the side face in the horizontal section corresponds to the parameter S (for the range of change of these values \u200B\u200Bis the interval from zero to one) (Fig. 7). The hexagon at the base of the pyramid is a projection of the color cube in the direction of its main diagonal. The color tone H is set by the angle set around the vertical axis, starting from red. The points on the circle itself correspond to pure (maximally saturated) colors. The dot in the center corresponds to the neutral color of minimum saturation (white, gray, black - it depends on the brightness). That is, we can say that the angle of the vector determines the hue, the length of the vector - the color saturation. The value of S varies from zero on the axis of the cone, to one on its faces. The value of V = 0 corresponds to the top of the pyramid (black), the value of V = 1 - the base of the pyramid; the colors are the most intense. The point with coordinates V = 1, S = 0 is the center of the base of the pyramid (corresponds to white). Intermediate values \u200B\u200Bof the coordinate V at S = 0 (ie on the axis of the pyramid) correspond to gray, if S = 0, then the value of the shade H is considered indeterminate, S = 1, if the point lies on the side of the pyramid.\n" +
                "\n" +
                "The HSV color model (tone, saturation, color value) was developed to provide the artist with the means of intuitive color selection.");


        label1.setText("RGB color cube");
        label2.setText("HSV color cone");
        image_first.setImage(new Image ("resources/RGB_color.png"));
        image_second.setImage(new Image ("resources/HSV.png"));

       // image_first.setPreserveRatio(false);

    }

    public void Info_Affine(ActionEvent actionEvent) {
            textArea.setText("Performing a variety of actions with geometric objects is a central task in computer graphics. Therefore, the choice of mathematical methods and algorithms for its implementation significantly affects the efficiency of the entire graphics system. In modern computer graphics, the coordinate method is widely used, because the graphic image consists of pixels, which are specified by coordinates. In addition, coordinates are used to describe the location of objects and to create images by transforming from one coordinate system to another.\n" +
                    "\n" +
                    "Affine is a transformation that has the following properties:\n" +
                    "\n" +
                    "any affine transformation can be represented as a sequence of operations from among the simplest: shift, stretching / compression, rotation;\n" +
                    "\n" +
                    " straight lines, parallel lines, the ratio of the lengths of the segments lying on one line, and the ratio of the areas of the figures are preserved.\n" +
                    "\n" +
                    "Affine transformations of three types are the basis for moving images:\n" +
                    "\n" +
                    "displacement;\n" +
                    "\n" +
                    "scaling (increase / decrease);\n" +
                    "\n" +
                    " angle rotation.\n" +
                    "\n" +
                    "Homogeneous coordinates of an arbitrary point M (x, y) of a plane are coordinates that correspond to the point M ′ (x, y, 1) or M ′ (hx, hy, h), h ≠ 0 in space. The fictitious z-coordinate has the value of a scalar constant, most often h = 1.\n" +
                    "\n" +
                    "The practical significance of entering homogeneous coordinates:\n" +
                    "\n" +
                    " Operations can be performed on homogeneous coordinates according to special formulas, and only at the last stage before displaying the image on the screen it is necessary to pass to Cartesian coordinates.\n" +
                    "\n" +
                    "The use of homogeneous coordinates gives many conveniences in solving graphical problems, for devices that work with integer coordinates For example, for the point M (0.5; 0.1) you can choose h = 10 and work with homogeneous integer coordinates M ′ (5 ; 1; 10).\n" +
                    "\n" +
                    "homogeneous coordinates allow you to record infinitely distant points in space, avoiding overflow of the computer's bit grid, due to the normalization of numbers. With the help of homogeneous coordinates, you can operate on a point at infinity.\n" +
                    "\n" +
                    "convenience in specifying geometric transformations in matrix form. Using homogeneous coordinates and third-order matrices, we can describe an arbitrary affine transformation.\n" +
                    "\n" +
                    "Matrices of basic elementary transformations (for objects)\n" +
                    "\n" +
                    "The translation matrix of the point on the vector (m, n) has the form:\n" +
                    "\n" +
                    "1 0 0\n" +
                    "0 1 0\n" +
                    "m n 1\n" +
                    "\n" +
                    "\n" +
                    "The dilation matrix (dilation) relative to the origin has the form:\n" +
                    "\n" +
                    "a 0 0\n" +
                    "0 b 0\n" +
                    "0  0  1\n" +
                    "\n" +
                    "The rotation matrix of a point relative to the origin in the positive direction\n" +
                    "\n" +
                    "cos(f)  sin(f)  0\n" +
                    "-sin(f) cos(f)  0\n" +
                    "0        0         1\n" );

        label1.setText("Rotate matrix (+)");
        label2.setText("Scale matrix");


        image_first.setImage(new Image ("resources/Rotate.jpg"));
        image_second.setImage(new Image ("resources/Scale.jpg"));

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

    public void Go_to_fractals(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Fractals.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_start_page(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Start_page.fxml"));
        root.getChildren().setAll(pane);
    }

    public void Go_to_study_materials(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Study_materials.fxml"));
        root.getChildren().setAll(pane);
    }


}
