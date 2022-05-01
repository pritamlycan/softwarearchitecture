package spaceinvaders;

//Needed for the mouse
import java.awt.event.*;

import abstractFactory.AbstractShip;

//Needed for the graphics
import java.awt.*;
/**
* The last defender of earth...
*
* Notice how this class has methods equivalent to those in the Alien class.
*/
public class ShipPlayerTwo extends AbstractShip implements MouseListener, MouseMotionListener {

  public static int SHIP_HEIGHT = 25;
  public static int SHIP_WIDTH = 15;

  private int x = 0;
  private int heightPosition = 0;
  SpaceInvaders spaceInvaders = null;

  //We are only going to allow one shot at a time
  Shot shot = null;
  FastShot FastShot = null;
  //Mouse1 m1=null;
 // Mouse2 m2=null;
  boolean hitState = false;

  /**
   *
   */
  public ShipPlayerTwo(SpaceInvaders si) {
      spaceInvaders = si;
      //Dynamically work out the starting position of the ship
      x = (int)((SpaceInvaders.WIDTH/2)+(SHIP_WIDTH/2));
      heightPosition = SpaceInvaders.HEIGHT-SHIP_HEIGHT-20;
  }


  /**
   * We will use the mouse to fly our ship
   */
  public void mouseMoved(MouseEvent me) {
      int newX = me.getX();
      if (newX > (SpaceInvaders.WIDTH-SHIP_WIDTH-10)) {
          //Stop the ship moving off the screen
          x = SpaceInvaders.WIDTH-SHIP_WIDTH-10;
      } else {
          //Set the new x position
          x = newX;
      }
  }

  /**
   * Unused
   */
  public void mouseDragged(MouseEvent me) {

  }

  /**
   * Restart the game as we put the mouse back over the screen
   */
  public void mouseEntered(MouseEvent me) {
      spaceInvaders.pauseGame(false);
  }

  /**
   * Pause the game as we move the mouse off the screen
   */
  public void mouseExited(MouseEvent me) {
      spaceInvaders.pauseGame(true);
  }

  /**
   *
   */
  public void mouseReleased(MouseEvent me) {

  }

  /**
   *
   */
  public void mousePressed(MouseEvent me) {

  }

  /**
   * Fire a shot at the aliens - mouse click
   */
  public void mouseClicked(MouseEvent me) {
	 //  AlienArmy army = spaceInvaders.getAlienArmy();
	   
	   
	  if (me.getClickCount() == 1) {
	   //   AlienArmy army = spaceInvaders.getAlienArmy();
	    //  shot = new Shot(x+(int)(SHIP_WIDTH/2), heightPosition, army);  
		
		  
		  ClickCommandInvoker invoker = new ClickCommandInvoker();
		  		Mouse1 m1 = new Mouse1(spaceInvaders,x,heightPosition);
			 			 
			 SingleclickonCommand singlepress = new SingleclickonCommand(m1);
			 invoker.setCommand(singlepress);
			 shot = invoker.buttonPressed();
		 }
	  else if (me.getClickCount() == 2) {
	  //
		 // AlienArmy army = spaceInvaders.getAlienArmy();
	  //    FastShot = new FastShot(x+(int)(SHIP_WIDTH/2), heightPosition, army);
		  ClickCommandInvoker invoker = new ClickCommandInvoker();
		  		Mouse2 m2 = new Mouse2(spaceInvaders,x,heightPosition);		  		  		  
			 			 
			 DoubleclickonCommand doublepress = new DoubleclickonCommand(m2);
			 invoker.setCommand(doublepress);
			 FastShot = invoker.buttonPressed1();
		}
	 
  }

  /**
   * Draw the image of the ship
   */
  public void drawShip(Graphics g) {
	  g.setColor(Color.green);  
      g.fillRect(x, heightPosition, SHIP_WIDTH, SHIP_HEIGHT);
      //If the shot is still alive, i.e. still on the screen
      if ((shot != null) && (shot.getShotState())) {
          shot.drawShot(g);
      }
      else if ((FastShot != null) && (FastShot.getShotState())) {
    	  FastShot.drawShot(g);
      }

  }

  /**
   * Check if a shot fired by an alien hit the ship
   */
  public boolean checkShot(int xShot, int yShot) {

      //Is the ship currently alive?
      //if (hitState) {
      //If it's alreay been shot then return false;
      // return false;
      //}

      //First lets check the X range
      if ((xShot >= x) && (xShot <= (x+SHIP_WIDTH))) {
          //X is ok, now lets check the Y range
          if ((yShot >= heightPosition) && (yShot <= (heightPosition+SHIP_HEIGHT))) {
              //The ship was hit!
              hitState = true;
              return true;
          }
      }
      return false;
  }

  public void hitByAlien() {
      spaceInvaders.shotShip();
  }

}