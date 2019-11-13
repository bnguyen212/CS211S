import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LineInfoGUI extends Application {

    private Pane pane;
    private BorderPane borderPane;
    private Circle startPoint, endPoint;
    private Line line;
    private Button distanceButton, slopeButton, midpointButton, vertHorzButton;
    private Text distanceText, slopeText, midpointText, vertHorxText, timeText; // USE THESE!
    private LineInfoDisplayer lineInfoDisplayer; // USE THIS!
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a");
    private static final int CIRCLE_RADIUS = 5;

    public void start(Stage primaryStage) {
        borderPane = new BorderPane();

        pane = new Pane();
        pane.setOnMouseClicked(this::handleMouseClicks);
        borderPane.setCenter(pane);

        distanceText = new Text("");
        distanceButton = new Button("Calculate Distance");
        distanceButton.setOnAction(
    		(ActionEvent e) -> {
    			lineInfoDisplayer = LineInfoDisplayer.createLineInfoDisplayer(LineInfoDisplayer.InfoType.DISTANCE);
    			distanceText.setText(lineInfoDisplayer.getInfo(line));
    	        distanceButton.setDisable(true);
    		}
		);
        distanceButton.setDisable(true);

        slopeText = new Text("");
        slopeButton = new Button("Calculate Slope");
        slopeButton.setOnAction(
    		(ActionEvent e) -> {
    			lineInfoDisplayer = LineInfoDisplayer.createLineInfoDisplayer(LineInfoDisplayer.InfoType.SLOPE);
    			slopeText.setText(lineInfoDisplayer.getInfo(line));
    			slopeButton.setDisable(true);
    		}
		);
        slopeButton.setDisable(true);

        midpointText = new Text("");
        midpointButton = new Button("Calculate Midpoint");
        midpointButton.setOnAction(
    		(ActionEvent e) -> {
    			lineInfoDisplayer = LineInfoDisplayer.createLineInfoDisplayer(LineInfoDisplayer.InfoType.MIDPOINT);
    			midpointText.setText(lineInfoDisplayer.getInfo(line));
    			midpointButton.setDisable(true);
    		}
		);
        midpointButton.setDisable(true);

        vertHorxText = new Text("");
        vertHorzButton = new Button("Determine Vertical/Horizontal");
        vertHorzButton.setOnAction(
    		(ActionEvent e) -> {
    			lineInfoDisplayer = LineInfoDisplayer.createLineInfoDisplayer(LineInfoDisplayer.InfoType.VERTHORZ);
    			vertHorxText.setText(lineInfoDisplayer.getInfo(line));
    	        vertHorzButton.setDisable(true);
    		}
		);
        vertHorzButton.setDisable(true);

        timeText = new Text("");

        TilePane distancePane = new TilePane(distanceButton, distanceText);
        distancePane.setAlignment(Pos.CENTER);
        distancePane.setHgap(50);
        TilePane slopePane = new TilePane(slopeButton, slopeText);
        slopePane.setAlignment(Pos.CENTER);
        slopePane.setHgap(50);
        TilePane midpointPane = new TilePane(midpointButton, midpointText);
        midpointPane.setAlignment(Pos.CENTER);
        midpointPane.setHgap(50);
        TilePane vertHorzPane = new TilePane(vertHorzButton, vertHorxText);
        vertHorzPane.setAlignment(Pos.CENTER);
        vertHorzPane.setHgap(50);
        TilePane timePane = new TilePane(timeText);
        timePane.setAlignment(Pos.CENTER);

        VBox controlBox = new VBox(distancePane,slopePane,midpointPane,vertHorzPane,timePane);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setSpacing(15);

        borderPane.setBottom(controlBox);

        Scene scene = new Scene(borderPane, 750, 500, Color.WHITE);
        primaryStage.setTitle("Line Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMouseClicks(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if(startPoint==null ) { // no start point yet, set the start point
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);
            createCoordinates(x,y);
            line = null;
        } else if(endPoint==null) { // start point, but not end point yet
        							// set the end point
            endPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(endPoint);
            createCoordinates(x,y);

            line = new Line(startPoint.getCenterX(), startPoint.getCenterY(), endPoint.getCenterX(), endPoint.getCenterY());
            pane.getChildren().add(line);
            distanceButton.setDisable(false);
            midpointButton.setDisable(false);
            vertHorzButton.setDisable(false);
            slopeButton.setDisable(false);
            timeText.setText(LocalDateTime.now().format(formatter));

        } else { // startPoint != null && endPoint !=null
        	// both start and end are there, so this is starting a new line;
        	// set a new start point
            pane.getChildren().clear();
            endPoint = null;
            line = null;
            distanceText.setText("");
            midpointText.setText("");
            vertHorxText.setText("");
            slopeText.setText("");
            timeText.setText("");
            distanceButton.setDisable(true);
            midpointButton.setDisable(true);
            vertHorzButton.setDisable(true);
            slopeButton.setDisable(true);

            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);
            createCoordinates(x,y);
        }
    }

    private void createCoordinates(double x, double y) {
        String coordinateString = "(" + x + ", " + y + ")";
        Text coordinates = new Text(x-CIRCLE_RADIUS, y-CIRCLE_RADIUS-2, coordinateString);
        pane.getChildren().add(coordinates);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
