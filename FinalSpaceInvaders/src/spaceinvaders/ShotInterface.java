package spaceinvaders;

public interface ShotInterface//abstractfactoory 
{
	
	abstract Shot getNormalshot(String shottype);
	abstract FastShot getMissileshot(String shottype);

}
