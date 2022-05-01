package spaceinvaders;

import java.awt.Graphics;

import activeObject.Message;
import activeObject.Proxy;

import java.awt.Color;
/**
 *
 */
public class Shot implements Runnable, Missile {
    private int shotSpeed = 15;

    private int SHOT_WIDTH = 2;
    private int SHOT_HEIGHT = 5;

    private int x;

    private int shotHeight;
    private int shotDir;
    boolean shotState = true;

    AlienArmy alienArmy = null;
    Alien hitAlien;
    Proxy proxy;

    /**
     *
     */
    public Shot(int xVal, int yVal, AlienArmy aa) {
        x = xVal;//Set the shot position
        shotHeight = yVal;
        shotDir = -2;
        alienArmy = aa;
        proxy = aa.getProxy();
        Thread thread = new Thread(this);
        thread.start();
   //     proxy.put(new Message(x, shotHeight, null, null, this));
    }

    /**
     *
     */
    public boolean moveShot() {

        //Now we need to see if we've hit anything!
    //	hitAlien = alienArmy.checkShot(x, shotHeight);
      //  if (hitAlien.hasBeenHit()) {
        	if (alienArmy.checkShot(x, shotHeight)) {

            //We hit something!
            System.out.println("We shot an alien!");
            shotState = false;
            return true;
        }

        shotHeight = shotHeight +shotDir;

        //Now check we haven't gone off the screen
        if (shotHeight < 0) {
            shotState = false;
            return true;
        }

        return false;
    }

    /**
     * Draw the image of the shot
     */
    public void drawShot(Graphics g) {
        if (shotState) {
            g.setColor(Color.white);
        } else {
            g.setColor(Color.black);
        }
        g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);
    }

    public boolean getShotState() {
        return shotState;
    }

    /**
     * The thread that moves the shot
     Moved to Active Object package (servant class)
     */
   
    public void run() {
        while(true) {
            try {
                Thread.sleep(shotSpeed);
                proxy.put(new Message(x, shotHeight, alienArmy.ship, null, this));
            } catch(InterruptedException ie) {
                //Ignore this exception
            }
            if (!shotState) {
				
				break;
			}

//            if (moveShot()) {
//                break;
//            }

        }
//        Thread.currentThread().interrupt();
    }

	public Alien whoWasHit() {
			if (shotState) {
				return null;
			}
			else {
				return hitAlien;
			}
	}

	public Proxy getProxy() {
		return proxy;
	}

	
}
