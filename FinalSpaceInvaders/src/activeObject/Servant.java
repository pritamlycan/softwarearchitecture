package activeObject;

import java.util.function.Supplier;

import spaceinvaders.AlienShotAdapter;

public class Servant {
	//contains run methods and will call the adapter for moveShot

	int shotSpeed=10;

	public Servant(int size) {
		//?
	}

	//add getter and setter for a message
	

	boolean empty=true;
	boolean full=false;
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isFull() {
		return full;
	}
	//private linked list or array for the internal queue for MQ example
	
	Object typeOfShot;
	Supplier<Boolean> moveShot;

	public void moveShot(Message msg) {
		empty=false;
		AlienShotAdapter ada = msg.getAda();
		ada.Request.get();
		empty=true;
	}

}
