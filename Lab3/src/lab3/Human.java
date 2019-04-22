package lab3;
import java.util.ArrayList;

public class Human {
	private String name = "Human";
	public static void plant(ArrayList<Flower> flowers, String flowerType) {
		switch(flowerType) {
		case "Rose": flowers.add(new Rose());
			break;
		case "Viola": flowers.add(new Viola());
			break;
		case "Gladiolus": flowers.add(new Gladiolus());
		}
	}
	public static void water(Flower flower) {
		flower.grow();
	}
	public static String smell(Flower flower) {
		if(flower.getHeight() > 0) return flower.getSmell();
		return "You need to water it first!";
	}
	public static void waiting() {
		Flower.life();
	}
}