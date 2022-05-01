package abstractFactory;

public interface AbstractFactory {
//	public AbstractMissile drawMissilePlayerOne(String type);
//	public AbstractMissile drawMissilePlayerTwo(String type);
	public abstract AbstractShip getShip();
	public abstract AbstractAlien getAlien();
	//public abstract AbastractObstacle getObstacle();
}
