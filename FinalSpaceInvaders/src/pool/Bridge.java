package pool;
import java.awt.*;
import spaceinvaders.SpaceInvaders;

public class Bridge{

    public static int BRIDGE_HEIGHT = 10;
    public static int BRIDGE_WIDTH = 50;
    
    private int leftPosition = 0;
    private int heightPosition = 0;
    private int hitCount = 0; //counter for how many times this bridge has been shot
    public boolean brokenState = false;

    SpaceInvaders spaceInvaders = null;
    
    public Bridge(SpaceInvaders si) {
        spaceInvaders = si;
        //Dynamically work out the starting position of the ship
        leftPosition = (int)((SpaceInvaders.WIDTH/2)+(BRIDGE_WIDTH/2)- 55);
        heightPosition = SpaceInvaders.HEIGHT-BRIDGE_HEIGHT-70;
    }
    

    public boolean checkShot(int x, int y) {

      if (hitCount>= 10) {
          brokenState = true;
          return false;
      }

      //Next lets check the X range
      if ((x >= leftPosition) && (x <= (leftPosition+BRIDGE_WIDTH))) {
          //X critia is met we check the Y range
          if ((y >= heightPosition) && (y <= (heightPosition+BRIDGE_HEIGHT))) {
              hitCount += 1;
              return true;
          }
      }
      return false;

  } 
  
  
/**
     * Set the position of the BRIDGE on the screen
     */
    public void setPosition(int x, int y) {
        leftPosition = 20;
        heightPosition = 20;
    }

    /**
     * "Draw" the image of the Bridge
     */
    public void drawBridge(Graphics g) {
      if (!brokenState) {
          g.setColor(Color.green);
          g.fillRect(leftPosition, heightPosition, BRIDGE_WIDTH, BRIDGE_HEIGHT);
      }
    }

}



