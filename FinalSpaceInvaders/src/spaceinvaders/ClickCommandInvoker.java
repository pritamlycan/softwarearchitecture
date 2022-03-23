package spaceinvaders;

public class ClickCommandInvoker {
	ButtonClickCommand cmd;
	
	public ClickCommandInvoker() {
			}

	public void setCommand(ButtonClickCommand cmd) {
		this.cmd=cmd;
	}
	
	public Shot buttonPressed() {
		return cmd.execute();		
		
	}
	public Missileshot buttonPressed1() {
	return cmd.execute2();
	}
}
