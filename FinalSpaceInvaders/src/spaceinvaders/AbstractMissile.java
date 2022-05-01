package spaceinvaders;

public abstract class AbstractMissile {
	private int shotSpeed = 15;

    private int SHOT_WIDTH = 2;
    private int SHOT_HEIGHT = 5;

    private int x;

    private int shotHeight;
    private int shotDir;
    boolean shotState = true;

    AlienArmy alienArmy = null;
    Alien hitAlien;
    
	public Alien whoWasHit() {
		if (shotState) {
			return null;
		}
		else {
			return hitAlien;
		}
}

	
}
