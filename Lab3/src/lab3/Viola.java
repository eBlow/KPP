package lab3;

public final class Viola extends Flower {
	public Viola() {
		super();
		super.delta = 3;
	}
	@Override
	public void grow() {
		super.grow();
		super.leaves.add(new Leave(5));
		buds.add(new Bud("viola","violet",5));
	}
}