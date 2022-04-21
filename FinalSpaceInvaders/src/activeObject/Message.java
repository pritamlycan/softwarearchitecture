package activeObject;
import spaceinvaders.Alien;
import spaceinvaders.AlienShot;
import spaceinvaders.AlienShotAdapter;
import spaceinvaders.Missile;
import spaceinvaders.Ship;

public class Message {
	
	AlienShot as;

	Missile ms;

	AlienShotAdapter ada;
	
	public Message(int xval, int yval, Ship s, Alien ali, AlienShot as) {
		super();
		this.as = as;
		ada = new AlienShotAdapter(xval, yval, s, ali, as);
	}
	
	public Message(int xval, int yval, Ship s, Alien ali, Missile ms) {
		super();
		this.ms=ms; 
		ada = new AlienShotAdapter(xval, yval, s, ali, ms);
	}
	
	public AlienShotAdapter getAda() {
		return ada;
	}

	public AlienShot getAs() {
		return as;
	}

	public Missile getMs() {
		return ms;
	}
	
}
