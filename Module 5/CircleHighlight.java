import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleHighlight extends Application {
	Circle circle;
	Pane board;
	
	@Override
	public void start(Stage stage) {
		circle = new Circle(250, 250, 50, Color.TRANSPARENT);
		circle.setStroke(Color.BLUE);
		circle.setStrokeWidth(5);
		circle.setOnMouseClicked(this::handleMouseClicked);
		board = new Pane();
		board.getChildren().add(circle);
		board.setOnMouseMoved(this::handleMouseMoved);
		Scene scene = new Scene(board, 500, 500);
		stage.setScene(scene);
		stage.show();
	  }
	
	private void handleMouseMoved(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		if (circle.contains(x, y)) {
			circle.setFill(Color.YELLOW);
		} else {
			circle.setFill(Color.TRANSPARENT);
		}
	}
	
	private void handleMouseClicked(MouseEvent e) {
		board.getChildren().clear();
		
	}	
	
	public static void main(String[] args) {
		launch();
	}
	
}