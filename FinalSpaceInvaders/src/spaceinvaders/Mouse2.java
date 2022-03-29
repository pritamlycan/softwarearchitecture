package spaceinvaders;

public class Mouse2  implements ShotInterface {
	
	SpaceInvaders spaceInvaders = null;
	 FastShot FastShot = null;
	 public static int SHIP_HEIGHT = 25;
	  public static int SHIP_WIDTH = 15;
	  private int x = 0;
	  private int heightPosition = 0;
	  
	 public Mouse2(SpaceInvaders si, int x2, int heightPosition2) {
		  spaceInvaders = si;
		  x = x2;
	      heightPosition = heightPosition2;
	 }
	  
	  
	 
	 public  FastShot runs() {
	
	AlienArmy army = spaceInvaders.getAlienArmy();
	FastShot = new FastShot(x+(int)(SHIP_WIDTH/2), heightPosition, army);
     return FastShot;
	 }



	@Override
	public Shot getNormalshot(String shottype) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public FastShot getFastShot(String shottype) {
		AlienArmy army = spaceInvaders.getAlienArmy();
		FastShot = new FastShot(x+(int)(SHIP_WIDTH/2), heightPosition, army);
	     return FastShot;
	}



	//@Override
/*	public Shot getshot(String shottype) {
		AlienArmy army = spaceInvaders.getAlienArmy();
	     shot = new FastShot(x+(int)(SHIP_WIDTH/2), heightPosition, army);
	     return shot;*/

}
