package lab2;

public final class Viola extends Flower {
	@Override
	public void grow() {
		super.grow();
		buds.add(new Bud("viola"));
	}
}