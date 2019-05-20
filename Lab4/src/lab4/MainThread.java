package lab4;

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

import java.util.Stack;


public class MainThread extends Application{
	private Stack<Producer> producersStack = new Stack<Producer>();
	private Stack<Consumer> consumersStack = new Stack<Consumer>();
	private Buffer buffer = new Buffer(20);
	
	private Button createProducerButton, createConsumerButton, deleteProducerButton,
					deleteConsumerButton, checkResultButton;
	private Label theLabel;
	private GridPane gridpane;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setResizable(false);
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 540, 250);
		
		editPane();
		
		theLabel = new Label();
		theLabel.setMaxWidth(180);
		theLabel.setWrapText(true);
		gridpane.add(theLabel, 0, 2);
		
		addButtons();
		
		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void editPane() {
		gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5);
		
		int columnWidth[] = {180,180,180};
		for (int i = 0; i < 2; i++) {
			gridpane.getColumnConstraints().add(new ColumnConstraints(columnWidth[i]));
		}
		int rowHeight[] = {40, 40, 170};
		for(int i = 0; i<3;i++) {
			gridpane.getRowConstraints().add(new RowConstraints(rowHeight[i]));
		}
	}
	private void addButtons() {
		createProducerButton = new Button("Create producer");
		createProducerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				producersStack.add(new Producer(buffer, producersStack.size() + 1));
				producersStack.peek().start();
				deleteProducerButton.setDisable(false);
			}
		});
		gridpane.add(createProducerButton, 0, 0);

		createConsumerButton = new Button("Create consumer");
		createConsumerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				consumersStack.add(new Consumer(buffer, consumersStack.size() + 1));
				consumersStack.peek().start();
				deleteConsumerButton.setDisable(false);
				checkResultButton.setDisable(false);
			}
		});
		gridpane.add(createConsumerButton, 1, 0);
		
		deleteProducerButton = new Button("Delete producer");
		deleteProducerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				producersStack.pop().kill();
				if(producersStack.size() == 0)deleteProducerButton.setDisable(true);
			}
		});
		deleteProducerButton.setDisable(true);
		gridpane.add(deleteProducerButton, 0, 1);
		
		deleteConsumerButton = new Button("Delete consumer");
		deleteConsumerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				consumersStack.pop().kill();
				if(consumersStack.size() == 0) {
					deleteConsumerButton.setDisable(true);
					checkResultButton.setDisable(true);
				}
			}
		});
		deleteConsumerButton.setDisable(true);
		gridpane.add(deleteConsumerButton, 1, 1);
		
		checkResultButton = new Button("Check result");
		checkResultButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				theLabel.setText(consumersStack.peek().result.toString());
			}
		});
		checkResultButton.setDisable(true);
		gridpane.add(checkResultButton, 2, 2);
	}

	
	public static void main(String[] args) {
		launch(args);
	}

}
