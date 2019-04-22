package lab2;

public final class Rose extends Flower {
	@Override
	public void grow() {
		super.grow();
		if(buds.isEmpty()) buds.add(new Bud("rose"));
	}
}