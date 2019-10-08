import java.util.*;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class InventoryUI  extends Application {
	TextField deviceModel, devicePrice;
	ComboBox<Phone.Color> deviceColor;
	ComboBox<StorageCapacity> deviceStorage;
	Button createBtn, showDevicesBtn;
	ArrayList<Phone> inventory = new ArrayList<Phone>();
	VBox right;
	
	@Override
	public void start(Stage stage) {
		inventory.add(new Phone("iPhone 11 Pro Max", 1499.99, StorageCapacity.LARGE, Phone.Color.MIDNIGHT_GREEN));
		inventory.add(new Phone("iPhone XS", 749.99, StorageCapacity.MEDIUM, Phone.Color.ROSE_GOLD));
		BorderPane board = new BorderPane();
		
		Text header = new Text("Apple Inventory");
		header.setFont(new Font("Helvetica", 50));
		header.setFill(Color.RED);
		VBox top = new VBox(header);
		top.getStyleClass().add("header");
		top.setStyle("-fx-alignment: center; -fx-margin: 50px");
		board.setTop(top);
		
		VBox left = new VBox(20);
		left.setStyle("-fx-alignment: center");
		left.getStyleClass().add("form");
		left.setPrefWidth(300);
		board.setLeft(left);
		
		right = new VBox(20);
		right.setPrefWidth(700);
		right.getStyleClass().add("main");
		board.setRight(right);
		
		Text model = new Text("Model");
		deviceModel = new TextField();
		Text price = new Text("Price");
		devicePrice = new TextField();
		Text color = new Text("Color");
		ObservableList<Phone.Color> options = FXCollections.observableArrayList(Arrays.asList(Phone.Color.values()));
	    deviceColor = new ComboBox<Phone.Color>(options);
	    Text storage = new Text("Storage");
	    ObservableList<StorageCapacity> options2 = FXCollections.observableArrayList(Arrays.asList(StorageCapacity.values()));
	    deviceStorage = new ComboBox<StorageCapacity>(options2);
	    createBtn = new Button("Create Device!");
	    createBtn.getStyleClass().add("btn-blue");
	    createBtn.setOnAction(this::createPhone);
	    showDevicesBtn = new Button("Show All Devices");
	    showDevicesBtn.getStyleClass().add("btn-green");
	    showDevicesBtn.setOnAction(this::showDevices);
	    
		left.getChildren().addAll(model, deviceModel, price, devicePrice, color, deviceColor, storage, deviceStorage, createBtn, showDevicesBtn);
		
		Scene scene = new Scene(board, 1000, 750);
		scene.getStylesheets().add(getClass().getResource("inventory.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	private void createPhone(ActionEvent e) {
		String model = deviceModel.getText();
		double price = Double.parseDouble(devicePrice.getText());
		Phone.Color color = deviceColor.getValue();
		StorageCapacity storage = deviceStorage.getValue();
		
		if (model.length() != 0  && price > 0 && color != null && storage != null) {
			Phone newPhone = new Phone(model, price, storage, color);
			inventory.add(newPhone);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText(null);
			alert.setContentText("Successfully created new device");
			alert.showAndWait();
			deviceModel.clear();
			devicePrice.clear();
			deviceColor.getSelectionModel().clearSelection();
			deviceStorage.getSelectionModel().clearSelection();
			this.showDevices(new ActionEvent());
		}
	}
	
	private void showDevices(ActionEvent e) {
		right.getChildren().clear();
		Text title = new Text("All Devices");
		title.setFont(new Font("Helvetica", 30));
		right.getChildren().addAll(title);

		for (Phone phone : inventory) {
			HBox item = new HBox(20);
			item.getStyleClass().add("phone");
			Text device = new Text(phone.toString());
			item.getChildren().addAll(device);
			if (phone.getOwner() == null) {
				Button sellBtn = new Button("Sell");
				sellBtn.getStyleClass().add("btn-purple");
				sellBtn.setOnAction(event -> this.sellPhone(phone));
				item.getChildren().addAll(sellBtn);
			}
			right.getChildren().add(item);
		}
	}
	
	private void sellPhone(Phone p) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Sell This Phone");
		dialog.setHeaderText("Who would you like to sell this device to?");
		dialog.setContentText("Customer Name:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    p.sell(result.get());
		}
		this.showDevices(new ActionEvent());
	}
	
	public static void main(String[] args) {
		launch();
	}
}