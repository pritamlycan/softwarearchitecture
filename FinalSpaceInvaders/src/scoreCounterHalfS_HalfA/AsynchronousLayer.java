package scoreCounterHalfS_HalfA;

public class AsynchronousLayer implements Runnable {
	public Thread asyncLayerScore;
	Queue q;
	boolean flag=true;

	public AsynchronousLayer(Queue qu, Thread t){
		//		asyncLayerScore = new Thread(this);
		asyncLayerScore = t;
		asyncLayerScore.start();
		q = qu;
	}

	public AsynchronousLayer(Queue qu){
		//		asyncLayerScore = new Thread(this);
		Thread asyncLayerScore = new Thread(this);
		asyncLayerScore.start();
		q = qu;
	}
	
	public void switchFlag(){
		flag = false;
	}

	public void run(){
		while(true) {
			while(flag) {
				try {
					Thread.sleep(20);
				}
				catch(InterruptedException ie) {
//					System.out.println("received interrupt : an alien was hit");
//					Thread.currentThread().interrupt();
//					//send info to queue here 
//					//get cause of interrupt and accordingly dispatch number on queue
//					//nevermind. we'll say cause is : a shot hit an alien
//					q.enqueue(5);
				}
			}
			q.enqueue(5);
			flag = true;
		}
	}
}
