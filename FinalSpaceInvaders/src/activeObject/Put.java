package activeObject;

public class Put implements MethodRequest {
	private Servant serv;
	private Message msg;
	//this correspond to the Run method. might refactor name later
	public Put(Servant req, Message m) {
		serv=req;
		msg=m;
	}
	@Override
	public boolean can_run() {
		// TODO Auto-generated method stub
	//	System.out.println("PUT can run check "+serv.isFull());
		return !serv.isFull();
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		//think this is gonna call some sort of
	//	System.out.println("PUT call");
		serv.moveShot(msg);

	}

}
