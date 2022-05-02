package scoreCounterHalfS_HalfA;

public class SynchronousLayer implements Runnable {
	Queue q;
	int score=0; 
	int prevscore;
	
	public SynchronousLayer(Queue qu){
		q=qu;
		Thread syncLayerScore = new Thread(this);
		syncLayerScore.start();
	}

	public void run(){
		while(true) {
			try {
				Thread.sleep(20);
			}
			catch(Exception e) {
			}
			prevscore = score;
			score += q.read();
			if (prevscore!=score) {
				System.out.println("An alien was hit ! ");
				System.out.println("Positive score is : "+score);
			}			
		}

	}	
}