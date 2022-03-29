package spaceinvaders;

import java.awt.Graphics;
public interface Missile {
	
	public boolean moveShot();
	public void drawShot(Graphics g);
	public boolean getShotState(); //similar to visibility
	public Alien whoWasHit();
}
