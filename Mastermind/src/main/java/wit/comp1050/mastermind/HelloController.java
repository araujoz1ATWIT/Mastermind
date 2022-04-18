package wit.comp1050.mastermind;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    public VBox rowVBox;

    @FXML
    public Circle blueCircle;

    @FXML
    public Circle greenCircle;

    @FXML
    public Circle redCircle;

    @FXML
    public Circle yellowCircle;

    @FXML
    public Circle purpleCircle;

    @FXML
    public Rectangle currentColorDisplay;

    @FXML
    public VBox rightVbox;

    //Tracked Game Variables
    public static boolean GAME_RUNNING = true;
    public static int CURRENT_GAME_ROW = 9;
    public static PegColor CURRENT_COLOR;

    private static final int ROWS = 10;
    private static final int COLS = 4;
    private static final double DEFAULT_RADIUS = 30.0;

    public HelloController(){
        gameBoard = new Peg[ROWS][COLS];
    }

    public void initialize(){

            //Clear Previous inputs
            PegColor[] colorsInRow = new PegColor[MainApp.CODE_SIZE];


            //TODO: Clear preivous inputs
        for (int row = 0; row < ROWS; row++){

            HBox hbox = new HBox();
            String hboxID = String.format("%sbox", row);
            hbox.setId(hboxID);

            for (int col = 0; col < COLS; col++){
                Peg p = new Peg(PegColor.TRANSPARENT, DEFAULT_RADIUS);



                String circleID = String.format("%d,%d", row, col);
                p.setId(circleID);


                p.circle.setOnMouseClicked(me -> {
                    String id = p.getId();
                    //System.out.printf("You clicked %s%n", id);

                    int commaIndex = id.indexOf(",");
                    int rowNum = Integer.parseInt(String.valueOf(id.charAt(commaIndex-1)));
                    int colNum = Integer.parseInt(String.valueOf(id.charAt(commaIndex+1)));
                    System.out.println("This is the " + rowNum + " row");
                    System.out.println("This is the " + colNum + " col");

                    if (rowNum == CURRENT_GAME_ROW){
                        if (MainApp.DUPLICATES_ALLOWED_IN_CODE){
                            p.circle.setFill(Paint.valueOf(toString(CURRENT_COLOR)));
                            p.color = CURRENT_COLOR;
                            System.out.println(String.format("Peg color : %s", p.color));
                            setPeg(hbox, p);
                        }
                        else {
                            for (int i = 0; i < MainApp.CODE_SIZE; i++ ){
                                String ColorVarifyID = String.format("%d,%d", CURRENT_GAME_ROW, i);
                                // TODO: 04/18/2022 Check each circle add to array of current colors and make sure no dups.
                                PegColor pi = (gameBoard[CURRENT_GAME_ROW][i]).color;
                                PegColor pk = PegColor.TRANSPARENT;

                                 for (int k = i+1; k < MainApp.CODE_SIZE-1; k++){
                                     pk = (gameBoard[CURRENT_GAME_ROW][k]).color;
                                     if (pi == pk){
                                         break;
                                     }
                                 }
                                 if (pi == pk){
                                     break;
                                 }
                                setPeg(hbox, p);
                            }
                        }
                    }
                });
                hbox.setSpacing(20);
                hbox.getChildren().add(p.circle);
            }
            rowVBox.setSpacing(20);
            rowVBox.getChildren().add(hbox);
        }

        //Setting the ride side up.
        for (int i = 0; i < ROWS; i++){
            HBox hbox2 = new HBox();
            String hboxRightID = String.format("%sRightbox", i);
            hbox2.setId(hboxRightID);

            //Todo: Set Circle Id's
            Circle a = new Circle(5);
            Circle b = new Circle(5);
            Circle c = new Circle(5);


            FlowPane flowpane = new FlowPane();
            hbox2.getChildren().add(flowpane);
            flowpane.getChildren().addAll(a,b,c);

            // TODO: 04/18/2022 Try to fix this error 
            rightVbox.getChildren().add(hbox2);
        }


        //<editor-fold desc="Color Panel Selectors">
        blueCircle.setOnMouseClicked(
                mouseEvent -> {
                    CURRENT_COLOR = PegColor.BLUE;
                    currentColorDisplay.setFill(Paint.valueOf(toString(CURRENT_COLOR)));
                    System.out.println("Blue pressed.");
                }
        );

        greenCircle.setOnMouseClicked(
                mouseEvent -> {
                    CURRENT_COLOR = PegColor.GREEN;
                    currentColorDisplay.setFill(Paint.valueOf(toString(CURRENT_COLOR)));
                    System.out.println("green pressed.");
                }
        );

        redCircle.setOnMouseClicked(
                mouseEvent -> {
                    CURRENT_COLOR = PegColor.RED;
                    currentColorDisplay.setFill(Paint.valueOf(toString(CURRENT_COLOR)));
                    System.out.println("red pressed.");
                }
        );

        yellowCircle.setOnMouseClicked(
                mouseEvent -> {
                    CURRENT_COLOR = PegColor.YELLOW;
                    currentColorDisplay.setFill(Paint.valueOf(toString(CURRENT_COLOR)));
                    System.out.println("yellow pressed.");
                }
        );

        purpleCircle.setOnMouseClicked(
                mouseEvent -> {
                    CURRENT_COLOR = PegColor.PURPLE;
                    currentColorDisplay.setFill(Paint.valueOf(toString(CURRENT_COLOR)));
                    System.out.println("purple pressed.");
                }
        );
        //</editor-fold>

    }

    private void setPeg(HBox hbox, Peg p) {


    }

    private void InputGuess(){


    }

    private String toString(PegColor currentColor) {
        return String.format(String.valueOf(currentColor));
    }


    Peg[][] gameBoard;

}