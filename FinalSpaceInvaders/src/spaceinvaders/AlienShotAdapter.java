package spaceinvaders;

import java.util.function.Supplier;

public class AlienShotAdapter extends AlienShot implements Missile, Runnable {
	//this method adapts the moveAndWhoWon() method in AlienShot to the target moveShot()
	
	public AlienShotAdapter(int xVal, int yVal, Ship s, Alien a) {
		super(xVal, yVal, s, a);
	}
	
	AlienShot as;

	public Supplier<Boolean> Request;
	
	public AlienShotAdapter(int xVal, int yVal, Ship s, Alien a, Missile missiletg) {
		super(xVal, yVal, s, a);
		System.out.println("AlienShotAdapter for missile was called");
		Request = () -> missiletg.moveShot();
	}
	
	//Adapter-Adaptee
	public AlienShotAdapter(int xVal, int yVal, Ship s, Alien a, AlienShot as) {
		super(xVal, yVal,s, a);
		this.as = as;
	//	System.out.println("AlienShotAdapter for AlienShot was called");
		Request =  () -> (moveShot()); //can simply rewrite this later as 
		//Request = () -> (as.moveAndWhoWon().getClass().getName()=="spaceinvaders.Alien");
		//keeping it separate for now for easier comprehension
	}
	
	public boolean moveShot() {
	//	System.out.println("moveShot was called");
		Object moveWinner = as.moveAndWhoWon();
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
