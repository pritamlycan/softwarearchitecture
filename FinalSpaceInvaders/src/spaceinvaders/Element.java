package spaceinvaders;

public interface Element {
	public boolean row1();
	public boolean row2();
	public boolean row3();
	public void accept(Visitor v);

}
