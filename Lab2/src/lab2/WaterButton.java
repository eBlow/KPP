package lab2;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WaterButton extends Button {

	public WaterButton(String text, ArrayList<Flower> flowers, Label theLabel) {
		super(text);
		super.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(!flowers.isEmpty())Human.water(flowers.get(0));
				theLabel.setText("Рост.");
			}
		});
	}
}
