package abstractFactory;

import spaceinvaders.Alien;
import spaceinvaders.Ship;
import spaceinvaders.SpaceInvaders;

public class ClassicFactory implements AbstractFactory {

	SpaceInvaders si;
	
	public ClassicFactory(SpaceInvaders si) {
		this.si=si;
	}
	
	@Override
	public AbstractAlien getAlien() {
		// TODO Auto-generated method stub
		return new Alien(null, si);
	}

	@Override
	public AbstractShip getShip() {
		// TODO Auto-generated method stub
		return new Ship(si);
	}

}
