package spaceinvaders;

public class SingleclickonCommand implements ButtonClickCommand {
	Mouse1 m1;//reference to receiverm class
	
	public SingleclickonCommand(Mouse1 m1)
	{
		this.m1=m1;
	}
	@Override
	public Shot  execute() {
		 return m1.runs();
	}
	@Override
	public FastShot execute2() {
		// TODO Auto-generated method stub
		return null;
	}

}
