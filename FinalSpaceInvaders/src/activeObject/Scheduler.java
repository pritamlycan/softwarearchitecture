package activeObject;

import java.util.Iterator;

public class Scheduler implements Runnable {
//	// Initialise the <Activation_Queue> to have 
//	// the specified capacity and make 
//	<MQ_Scheduler> 
//	// run in its own thread of control. 
//	MQ_Scheduler (size_t high_water_mark); 
	protected ActivationQueue actqueue;
	int i=0;
	
//!!!!!!!!!!!!!add line for new thread here!!!!!!!!!!!!!
	
	public Scheduler(int maxSize){
//		System.out.println("SCH making scheduler...");
		actqueue = new ActivationQueue(maxSize);
		//give size and high water mark?
		Thread thread = new Thread(this);
		thread.setName("Scheduler");
		thread.start();
//		System.out.println("SCH made.");
	}

	public void enqueue(MethodRequest mr) {
//		System.out.println("SCH enqueue received by scheduler");
		actqueue.enqueue(mr);
	}
	
	public void run() { //run for the thread, it's a dispatcher though
	//	System.out.println("SCH running scheduler thread");
		while(true) {
			i++;
			/*might choose not to use an iterator here like in POSA2, because 
			iterator does not allow modification of the structure of the element 
			being iterated as it stores its position. This means that I might get 
			Concurrent modification exceptions.*/
			//Iterator<MethodRequest> it = actqueue.itr;
//			System.out.println("SCH checking if it has next");
//			System.out.println(i +"run");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(actqueue.hasNext()) {
//				System.out.println("SCH it did");
				MethodRequest m = actqueue.peek();
				if(m.can_run()) {
//					System.out.println("SCH dequeuing");
					actqueue.dequeue(m);
					m.call();
				}
			}
		
			//c'est enlever de la queue le prochain method request, 
			//et s'il est libre, le call 
			
		}
	}
	
}
