package spaceinvaders;

public interface ShotInterface//abstractfactoory 
{
	
	abstract Shot getNormalshot(String shottype);
	abstract Missileshot getMissileshot(String shottype);

}
