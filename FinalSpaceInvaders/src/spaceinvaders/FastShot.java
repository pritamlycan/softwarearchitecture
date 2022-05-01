package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 */
//
public class FastShot extends AbstractMissile implements Missile, Runnable
{
	 private int shotSpeed = 2;
	    private int SHOT_WIDTH = 12;
	    private int SHOT_HEIGHT = 5;
	    private int x = 0;
	    private int shotHeight = 0;
    boolean shotState = true;
    AlienArmy alienArmy;
    Alien hitAlien;

    /**
     *
     */
    public FastShot(int xVal, int yVal, AlienArmy aa) {
        x = xVal;//Set the shot direction
        shotHeight = yVal;
        alienArmy = aa;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     *
     */
    public boolean moveShot() {

        //Now we need to see if we've hit anything!
    	//hitAlien = alienArmy.checkShot(x, shotHeight);
       // if (hitAlien.hasBeenHit()) {
        	if (alienArmy.checkShot(x, shotHeight)) {

            //We hit something!
            System.out.println("We shot an alien!");
            shotState = false;
            return true;
        }

        shotHeight = shotHeight - 2;
        //We could have written this as
        //shotHeight -= 2;

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
            g.setColor(Color.yellow);
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
     */
    public void run() {
        while(true) {
            try {
                Thread.sleep(shotSpeed);
            } catch(InterruptedException ie) {
                //Ignore this exception
            }

            //Use this line for super AlienShots
            //
            //moveShot()
            //
            //or this for normal AlienShots
            //
            //if (moveShot()) {
            // break;
            //}

            if (moveShot()) {
                break;
            }

        }
    }


	@Override
	public Alien whoWasHit() {
		// TODO Auto-generated method stub
		return null;
	}

}
