package spaceinvaders;

public class DoubleclickonCommand implements ButtonClickCommand {
Mouse2 m2;//reference to receiverm class
	
	public DoubleclickonCommand(Mouse2 m2)
	{
		this.m2=m2;
	}
	
	@Override
	public Shot execute() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FastShot execute2() {
		// TODO Auto-generated method stub
		return m2.runs();
	}


}
