package lab3;

import java.util.ArrayList;

public abstract class Flower {
	private double height = 0;
	protected static int time = 0;
	protected int x, delta = 1; //x Ц момент времени, в который цветок полили
								//delta Ц врем€, которое цветок может прожить без воды
	
	protected ArrayList<Bud> buds = new ArrayList<Bud>();
	protected ArrayList<Leave> leaves = new ArrayList<Leave>();
	
	public void grow() {
		height++;
		x = time;
	}
	public double getHeight() {
		return height;
	}
	public String getSmell() {
		return buds.get(0).getSmell();
	}
	private void wither() {
		this.height = 0;
		buds.clear();
		leaves.clear();
	}
	public static void life() {
		time++;
	}
	public void live() {
		if(time - x > delta) wither();
	}
}