package activeObject;

public class Proxy {
	private Servant serv;
	private Scheduler sch;
	int maxSize = 100;
	//set a name on creation that proxy is the same 
	
	public Proxy() {
		System.out.println("PRO creating proxy");
		sch = new Scheduler(maxSize);
		serv = new Servant(maxSize); 
	}
	
	public void put(Message msg) {
		System.out.println("PRO received put");
		MethodRequest mr = new Put(serv, msg);
		sch.enqueue(mr);
		System.out.println("PRO enqueued to scheduler");
	}
	
	//if necessary add a get to get message future
} 
