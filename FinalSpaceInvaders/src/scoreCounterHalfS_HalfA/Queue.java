package scoreCounterHalfS_HalfA;

import java.util.LinkedList;

public class Queue {
	LinkedList<Integer> rj = new LinkedList<Integer>();

	public Queue() {

	}
	public void enqueue(int msg) {
		if (rj.size()<6) {
			rj.addLast(msg);
		}
	}

	public int read() {
		if (rj.isEmpty()){
			return 0;
		}
		return rj.pop();
	}
	
}
