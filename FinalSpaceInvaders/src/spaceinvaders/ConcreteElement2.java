package spaceinvaders;

public class ConcreteElement2 implements Element {
	
	SpaceInvaders spaceInvaders = null;
	
	public ConcreteElement2(SpaceInvaders si) {
		this.spaceInvaders=si;
	}


	@Override
	public void accept(Visitor v) {
		
		v.visit(this);
		
	}

	@Override
	public boolean row1() {
	
		return false;
	}

	@Override
	public boolean row2() {
		
		spaceInvaders.hitAlienScore();
		return true;
	}

	@Override
	public boolean row3() {
		
		return false;
	}

}
