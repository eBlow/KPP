package lab2;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public final class PlantButton extends Button {
	
	public PlantButton(String text, ArrayList<Flower> flowers, Label theLabel) {
		super(text);
		super.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			Human.plant(new Rose());
			theLabel.setText("Цветок посажен.");
		}
	});
	}
}
