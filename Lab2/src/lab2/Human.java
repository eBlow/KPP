package lab2;

public abstract class Human {
	public static void plant(Flower flower) {
		Main.flowers.add(flower);
	}
	public static void water(Flower flower) {
		flower.grow();
	}
	public static String smell(Flower flower) {
		if(flower.getHeight() > 0) return flower.getSmell();
		return "You need to water it first!";
	}
}