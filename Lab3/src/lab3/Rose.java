package lab3;

public final class Rose extends Flower {
	public Rose() {
		super();
		super.delta = 10;
	}
	@Override
	public void grow() {
		super.grow();
		super.leaves.add(new Leave(3));
		if(buds.isEmpty()) buds.add(new Bud("rose","red",15));
		
	}
}