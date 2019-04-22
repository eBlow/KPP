package lab2;

import java.util.ArrayList;

public abstract class Flower {
	private double height = 0;
	protected ArrayList<Bud> buds = new ArrayList<Bud>();
	
	public void grow() {
		height++;
	}
	public double getHeight() {
		return height;
	}
	public String getSmell() {
		return buds.get(0).getSmell();
	}
}