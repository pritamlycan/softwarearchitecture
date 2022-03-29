package spaceinvaders;



public class Mouse1 implements ShotInterface {
	
	 SpaceInvaders spaceInvaders = null;
	 Shot shot = null;
	 Ship ship =null;
	 AlienArmy army =null;
	 public static int SHIP_HEIGHT = 25;
	  public static int SHIP_WIDTH = 15;
	  private int x = 0; 
	  private int heightPosition = 0;
	  
	 public Mouse1(SpaceInvaders si, int x1, int heightPosition2) {
		  this.spaceInvaders = si;
		  this.x=x1;		 
	      this.heightPosition = heightPosition2;
	 }
	  
	  
	 
	 public Shot runs() {
	
	AlienArmy army = spaceInvaders.getAlienArmy();
	shot = new Shot(x+(int)(SHIP_WIDTH/2), heightPosition, army);
	return shot;
	 }


	@Override
	public Shot getNormalshot(String shottype) {
		if (shottype == "singlepress") {
		AlienArmy army = spaceInvaders.getAlienArmy();
		shot = new Shot(x+(int)(SHIP_WIDTH/2), heightPosition, army);
		//return shot;
		}
		return shot;
	}
	
	



	@Override
	public FastShot getFastShot(String shottype) {
		
		return null;
	}



	
}
