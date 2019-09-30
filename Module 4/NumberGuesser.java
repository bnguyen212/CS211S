import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NumberGuesser extends Application {
	private boolean started = false;
	private int secretNum;
	private Button btn;
	private VBox vbox = new VBox();;
	private Random random = new Random();
	private Text message;
	private TextField guessField = new TextField();
	private VBox previousGuesses = new VBox(10);

	@Override
	public void start(Stage stage) {
	    vbox.setSpacing(20);
	    previousGuesses.setStyle("-fx-alignment: center");
	    guessField.setMaxWidth(200);
	    vbox.setStyle("-fx-alignment: center");
		btn = new Button("Start a new game!");
		btn.setOnAction(this::btnAction);
		vbox.getChildren().add(btn);
		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);
		stage.show();
	}

	private void checkNumber(int num) {
		if (Integer.compare(secretNum, num) == 0) {
			message.setText("Your guess was correct! The correct number is " + secretNum);
			message.setFill(Color.GREEN);
			guessField.setDisable(true);
			started = !started;
			btn.setText("Start a new game!");
		} else {
			message.setFill(Color.RED);
			Text text;
			if (Integer.compare(secretNum, num) < 0) {
				message.setText("Your guess was too high! Try again: ");
				text = new Text(num + " (high)");
				text.setFill(Color.BLUE);
			} else {
				message.setText("Your guess was too low! Try again: ");
				text = new Text(num + " (low)");
				text.setFill(Color.RED);
			}
			previousGuesses.getChildren().add(text);
		}
	}

	private void btnAction(ActionEvent e) {
		if (started) {
			try {
				int num = Integer.parseInt(guessField.getText());
				checkNumber(num);
			} catch (NumberFormatException ex) {
				message.setText(guessField.getText() + " is not a valid number! Please try again:");
				message.setFill(Color.RED);
			} finally {
				guessField.clear();
			}

		} else {
			started = !started;
			secretNum = random.nextInt(100) + 1;
			message = new Text("A random number between 1 and 100 has been generated.\nPlease make your guess:");
			message.setFill(Color.BLUE);
			guessField.setOnAction(this::btnAction);
			btn.setText("Guess");
			guessField.setDisable(false);
			previousGuesses.getChildren().clear();
			previousGuesses.getChildren().add(new Text("Previous Guesses: "));
			vbox.getChildren().clear();
			vbox.getChildren().addAll(message, guessField, btn, previousGuesses);
		}
	}

	public static void main(String[] args) {
		launch();
	}
}