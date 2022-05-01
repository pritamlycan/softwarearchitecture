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
		System.out.println("SERV moveShot called");
		empty=false;
		AlienShotAdapter ada = msg.getAda();
		System.out.println("SERV entering while");
//		while(true) {
//			break; //just added this line for testing remove this for actual use.
//			try {
//				//Thread.sleep(100); //gamespeed
//				Thread.sleep(shotSpeed);
//			} catch(InterruptedException ie) {
//				//Ignore this exception
//			}
//			System.out.println("SERV checking if");
//			if (ada.Request.get()) {
//				break;
//			}
		ada.Request.get();
//		}
		System.out.println("finished loop");
		empty=true;
	}

}
