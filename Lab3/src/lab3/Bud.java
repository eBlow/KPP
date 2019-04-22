package lab3;

import java.util.ArrayList;

public class Bud {
	private String smell;
	private ArrayList<Petal> petals;
	
	Bud(String smell, String color, int numberOfPetals){
		this.smell = smell;
		petals = new ArrayList<Petal>(numberOfPetals);
		for(int i = 0; i<numberOfPetals;i++) {
			petals.add(new Petal(color));
		}
	}
	public String getSmell() {
		return smell;
	}
}