import abstractFactory.AbstractShip;
import abstractFactory.ClassicFactory;
import abstractFactory.SpecialFactory;
import spaceinvaders.Ship;
import spaceinvaders.ShipPlayerTwo;
import spaceinvaders.SpaceInvaders;

public class FactoryTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpaceInvaders si = new SpaceInvaders("tester");
		//ClassicFactory classic = new ClassicFactory(si);
		SpecialFactory special = new SpecialFactory(si);
		ShipPlayerTwo sh = (ShipPlayerTwo) special.getShip();
		sh.drawShip(si.getGraphics());
	}

}
