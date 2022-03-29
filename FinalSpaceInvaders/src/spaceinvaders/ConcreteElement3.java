package spaceinvaders;

public class ConcreteElement3 implements Element {
	
	SpaceInvaders spaceInvaders = null;
	
	public ConcreteElement3(SpaceInvaders si) {
		this.spaceInvaders=si;
	}


	@Override
	public boolean row1() {
		
		return false;
	}

	@Override
	public boolean row2() {
	
		return false;
	}

	@Override
	public boolean row3() {
		
		spaceInvaders.hitAlienScore();
		return true;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

}
