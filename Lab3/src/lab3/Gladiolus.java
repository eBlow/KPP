package lab3;

class Gladiolus extends Flower {
	public Gladiolus() {
		super();
		super.delta = 7;
	}
	@Override
	public void grow() {
		super.grow();
		super.leaves.add(new Leave(50));
		buds.add(new Bud("gladiolus","yellow",1));
	}
}
