package abstractFactory;

import spaceinvaders.AlienBoss;
import spaceinvaders.ShipPlayerTwo;
import spaceinvaders.SpaceInvaders;

public class SpecialFactory implements AbstractFactory {
	
	SpaceInvaders si;
	
	public SpecialFactory(SpaceInvaders si) {
		this.si=si;
	}
	
	@Override
	public AbstractShip getShip() {
		return new ShipPlayerTwo(si);
	}

	@Override
	public AbstractAlien getAlien() {
		// TODO Auto-generated method stub
		return new AlienBoss(null, si);
	}
	
	
}
