package activeObject;

import spaceinvaders.AlienArmy;
import spaceinvaders.AlienShot;
import spaceinvaders.Missile;
import spaceinvaders.Shot;

public class AO_Tester { //act as a client
	public static void main(String[] args) {
		Proxy prox = new Proxy();
		//AlienArmy aa = new AlienArmy(null, null, null);
		AlienShot as = new AlienShot(0, 0, null, null);
		
		prox.put(new Message(0, 0, null, null, as));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TES slept");
		Shot sh = new Shot(0, 0, null);
		prox.put(new Message(0, 0, null, null, sh));
	
		
	}
}
