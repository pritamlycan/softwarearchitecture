package activeObject;

import java.util.Iterator;
import java.util.LinkedList;

public class ActivationQueue {
	// Block for an "infinite" amount of time waiting 
	 // for <insert> and <remove> methods to complete. 
//	 enum { INFINITE = -1 }; 
	int infinite =-1;
	LinkedList<MethodRequest> actQueue= new LinkedList<MethodRequest>(); ;
	
	// Define a "trait". 
	Iterator<MethodRequest> itr;
//	 typedef Activation_List_Iterator iterator; 
	
//	 // Constructor creates the list with the specified 
//	 // high water mark that determines its capacity. 
	
	public ActivationQueue(int HWM){
		actQueue = new LinkedList<MethodRequest>(); 
		//MethodRequest[] actQueue = new MethodRequest[HWM];  
		itr = actQueue.iterator();
		System.out.println("AQ act q made");
	}
	
	
//	 // Insert <method_request> into the list, waiting up 
//	 // to <timeout> amount of time for space to become 
//	 // available in the queue. Throws the <System_Ex> 
//	 // exception if <timeout> expires.
	
	public void enqueue(MethodRequest metReq) {
		// timeOut = infinite) {
		actQueue.add(metReq);
		System.out.println("AQ MR enqueued");
	}
	
	public void dequeue(MethodRequest m) {
		actQueue.remove(m);
		System.out.println("AQ MR removed");
	}
	
	public MethodRequest poper() {
		return actQueue.pop();
	}

	public MethodRequest peek() {
		return actQueue.peekFirst();
	}
	
	public boolean hasNext() {
		return !actQueue.isEmpty();
	}
}
