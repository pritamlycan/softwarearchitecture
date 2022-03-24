package spaceinvaders;

public class AlienShotAdapter extends AlienShot implements Missile, Runnable {
	
	
	public AlienShotAdapter(int xVal, int yVal, Ship s) {
		super(xVal, yVal, s);
	}

	public boolean moveShot() {
		Object moveWinner = moveAndWhoWon();
		if(moveWinner.getClass().getName()=="spaceinvaders.Alien") {
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public Alien whoWasHit() {
		if (getShotState()) {
			System.out.println("This shot hasn't hit the ship, yay!");
		};
		return null; //
	}
	
}
