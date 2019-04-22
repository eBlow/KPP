package lab2;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SmellButton extends Button {
	public SmellButton(String text, ArrayList<Flower> flowers, Label theLabel) {
		super(text);
		super.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			if(!flowers.isEmpty())theLabel.setText("Запах: " + Human.smell(flowers.get(0)));
		}
	});
	}
}
