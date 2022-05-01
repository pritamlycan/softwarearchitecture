package activeObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
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
	}
	
	
//	 // Insert <method_request> into the list, waiting up 
//	 // to <timeout> amount of time for space to become 
//	 // available in the queue. Throws the <System_Ex> 
//	 // exception if <timeout> expires.
	
	public void enqueue(MethodRequest metReq) {
		// timeOut = infinite) {
		infinite++;
	//	System.out.println(actQueue.size());
	//	System.out.println(infinite);
		if(infinite>50) {
			infinite =0;
			actQueue = new LinkedList<MethodRequest>();
		}
		actQueue.add(metReq);
	//	System.out.println("AQ MR enqueued");
	}
	
	public void dequeue(MethodRequest m) {
		actQueue.remove(m);
//		if(infinite>20) {
//			infinite=0;
//			actQueue = new LinkedList<MethodRequest>();
//		}
		actQueue.remove(null);
		//actQueue.removeAll(Collections.singleton(null));
	//	System.out.println("AQ MR removed");
	}
	
	public MethodRequest poper() {
		return actQueue.pop();
	}

	public MethodRequest peek() {
		return actQueue.peekFirst();
	}
	
	public boolean hasNext() {
		try {
			actQueue.peek().can_run();
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
}
