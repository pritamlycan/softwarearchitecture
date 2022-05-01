package spaceinvaders;

import scoreCounterHalfS_HalfA.AsynchronousLayer;

public class ConcreteElement1 implements Element {
	
	SpaceInvaders spaceInvaders = null;
	
	public ConcreteElement1(SpaceInvaders si) {
		this.spaceInvaders=si;
	}

	@Override
	public void accept(Visitor v) {
		
		v.visit(this);
	}

	@Override
	public boolean row1() {
		spaceInvaders.hitAlienScore();
		return true;
	}

	@Override
	public boolean row2() {
		
		return false;
	}

	@Override
	public boolean row3() {
		
		return false;
	}

}
