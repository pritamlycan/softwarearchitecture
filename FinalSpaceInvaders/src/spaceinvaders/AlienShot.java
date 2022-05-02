package spaceinvaders;

import java.awt.*;

import activeObject.Message;
import activeObject.Proxy;

/**
 *
 */
public class AlienShot implements Runnable {

	private int shotSpeed = 30;
	private int SHOT_WIDTH  = 2;
	private int SHOT_HEIGHT = 5;    
	private int x = 0;
	private int shotHeight = 0;

	boolean shotState = true;

	Ship ship = null;
	Alien alien; // who does this shot belong to
	private Proxy proxy;
	/**
	 *
	 */
	public AlienShot(int xVal, int yVal, Ship s, Alien a) {
		x = xVal;//Set the shot direction
		shotHeight = yVal;
		ship = s;
		alien = a;
		proxy = s.spaceInvaders.getProxy();
//		proxy.put(new Message(x, shotHeight, s, a, this));
//		Thread thread = new Thread(this);
//		thread.start();
	}

    /**
	 *
	 */
	// public Alien moveShot() {
	public Object moveAndWhoWon() {
//		System.out.println("AS moveAnd... called");
		//Now we need to see if the ship has been hit
		if (ship.checkShot(x, shotHeight)) {
			System.out.println("An alien shot the ship!");
			ship.hitByAlien();
			shotState = false;
			//return true;
			return alien;
		}
//		System.out.println("AS checking to move");
		shotHeight = shotHeight+2;

		//Now check we haven't gone off the screen
		if (shotHeight > SpaceInvaders.HEIGHT) {
			shotState = false;
			//   return true;
			return alien;
		}

		return ship;
	}

	/**
	 * Draw the image of the shot
	 */    
	public void drawShot(Graphics g) {
		if (shotState) {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.black);
		}
		g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);
	} 

	public boolean getShotState() {
		return shotState;
	}

	public void animate() {
		proxy.put(new Message(x, shotHeight, ship, alien, this));
		Thread thread = new Thread(this);
		thread.start();
	}
	public void run() {
//		proxy.put(new Message(x, shotHeight, ship, alien, this));
		while(true) {
			try {
				Thread.sleep(shotSpeed);
				proxy.put(new Message(x, shotHeight, ship, alien, this));
				
			} catch(InterruptedException ie) {
				//Ignore this exception
			}
			
			if (!shotState) {
				break;
			}
		}
//		Thread.currentThread().interrupt();
	}
}
