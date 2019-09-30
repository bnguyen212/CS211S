import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class InspirationalQuote extends Application {

  private Button btn;
  private Text quote;
  private BorderPane bp;
  private int currentIndex = 0;
  private static ArrayList<String> quotes = new ArrayList<String>();


  @Override
  public void start(Stage stage) {
	  bp = new BorderPane();

	  Text header = new Text("Quote of the Day");
	  header.setFont(new Font("Helvetica", 50));
	  header.setFill(Color.RED);
	  VBox top = new VBox(header);
	  top.setStyle("-fx-alignment: center");
	  bp.setTop(top);

	  quote = new Text(quotes.get(currentIndex));
	  quote.setFill(Color.BLUE);
	  bp.setCenter(quote);

	  btn = new Button("Get a new quote!");
	  btn.setOnAction(this::generateNewQuote);
	  VBox bottom = new VBox(btn);
	  bottom.setStyle("-fx-alignment: center");
	  bp.setBottom(bottom);

	  Scene scene = new Scene(bp, 1000, 500);
	  stage.setScene(scene);
	  stage.show();
  }

  private void generateNewQuote(ActionEvent event) {
	  currentIndex = (currentIndex + 1) % quotes.size();
	  quote = new Text(quotes.get(currentIndex));
	  quote.setFill(Color.BLUE);
	  bp.setCenter(quote);
  }

  public static void main(String[] args) {
	  quotes.add("Defeat is not the worst of failures. Not to have tried is the true failure");
	  quotes.add("Be more concerned with your character than your reputation, because your character is what you really are, while your reputation is merely what others think you are");
	  quotes.add("Once you replace negative thoughts with positive ones, you’ll start having positive results");
	  quotes.add("Success is not final, failure is not fatal: it is the courage to continue that counts");
	  launch();
  }
}