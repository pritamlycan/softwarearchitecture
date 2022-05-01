package activeObject;

public class Get implements MethodRequest {

	@Override
	public boolean can_run() {
		// can't call get method until queue is not empty (page 326)
		//returns true is queue (= list in servant) is not, false if yes. 
		return false;
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		// Bind dequeued message to the future result.
		//result_=servant_->get();
		//declare servant (pointer to a servant) and result (message future) outside of this method

	}

}
