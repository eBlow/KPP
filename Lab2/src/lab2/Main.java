package lab2;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Main extends Application {
	public static ArrayList<Flower> flowers = new ArrayList<Flower>();
	private Button waterButton, smellButton, plantButton;
	private ComboBox<String> plantComboBox;
	private ComboBox<Integer> waterComboBox, smellComboBox;
	private ObservableList<Integer> comboBoxesList = FXCollections.observableArrayList();
	private Label theLabel;
	private GridPane gridpane;
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setResizable(false);
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 300, 150);
		
		editPane();
		
		theLabel = new Label();
		theLabel.setMaxWidth(100);
		theLabel.setWrapText(true);
		gridpane.add(theLabel, 0, 2);
		
		addButtons();
		addComboBoxes();
		
		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void addButtons() {
		plantButton = new Button("Посадить");
		plantButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				switch(plantComboBox.getValue()) {
				case "Rose": Human.plant(new Rose());
					break;
				case "Viola": Human.plant(new Viola());				
				}
				
				comboBoxesList.add(new Integer(flowers.size()));
				waterButton.setDisable(false);
				waterComboBox.setDisable(false);
				smellButton.setDisable(false);
				smellComboBox.setDisable(false);
				theLabel.setText("Цветок посажен.");
			}
		});
		gridpane.add(plantButton, 0, 1);

		waterButton = new Button("Полить");
		waterButton.setDisable(true);
		waterButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Human.water(flowers.get(waterComboBox.getValue() - 1));
				theLabel.setText("Рост.");
			}
		});
		gridpane.add(waterButton, 1, 1);
		
		smellButton = new Button("Понюхать");
		smellButton.setDisable(true);
		smellButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				theLabel.setText("Запах: " + Human.smell(flowers.get(smellComboBox.getValue() - 1)));
			}
		});
		gridpane.add(smellButton, 2, 1);
	}
	private void addComboBoxes() {
		plantComboBox = new ComboBox<String>( FXCollections.observableArrayList("Rose","Viola"));
		plantComboBox.setValue("Rose");
		gridpane.add(plantComboBox, 0, 0);
		
		waterComboBox = new ComboBox<Integer>(comboBoxesList);
		waterComboBox.setValue(1);
		waterComboBox.setDisable(true);
		gridpane.add(waterComboBox, 1, 0);
		
		smellComboBox = new ComboBox<Integer>(comboBoxesList);
		smellComboBox.setValue(1);
		smellComboBox.setDisable(true);
		gridpane.add(smellComboBox, 2, 0);
	}
	private void editPane() {
		gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5);
		
		for (int i = 0; i < 2; i++) {
			gridpane.getColumnConstraints().add(new ColumnConstraints());
		}
		for(int i = 0; i<3;i++) {
			gridpane.getRowConstraints().add(new RowConstraints());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}