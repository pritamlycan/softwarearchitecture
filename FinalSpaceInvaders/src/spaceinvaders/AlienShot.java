package spaceinvaders;

import java.awt.*;

/**
 *
 */
public class AlienShot implements Runnable {

    private int shotSpeed = 10;
    private int SHOT_WIDTH  = 2;
    private int SHOT_HEIGHT = 5;    
    private int x = 0;
    private int shotHeight = 0;

    boolean shotState = true;

    Ship ship = null;
    Alien alien; // who does this shot belong to
    
    /**
     *
     */
    public AlienShot(int xVal, int yVal, Ship s, Alien a) {
        x = xVal;//Set the shot direction
		shotHeight = yVal;
		ship = s;
		alien = a;
		Thread thread = new Thread(this);
		thread.start();
    }

    /**
     *
     */
   // public Alien moveShot() {
    public Object moveAndWhoWon() {
		
		//Now we need to see if the ship has been hit
		if (ship.checkShot(x, shotHeight)) {
	            //We hit something!
	            System.out.println("An alien shot the ship!");
		    ship.hitByAlien();
		    shotState = false;
		    //return true;
		    return alien;
		}
	
	        shotHeight = shotHeight + 2;
		//We could have written this as
		//shotHeight -= 2;
		
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

    public void run() {
        while(true) {
            try {
                Thread.sleep(shotSpeed);
            } catch(InterruptedException ie) {
                //Ignore this exception
            }
	    
	    if (moveAndWhoWon().getClass().getName()=="Alien") {
                break;
	    }

	}
    }

    

}
