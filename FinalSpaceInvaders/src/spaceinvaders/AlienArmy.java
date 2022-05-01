package spaceinvaders;

import java.awt.*;
import java.util.*;

import abstractFactory.AbstractFactory;
import abstractFactory.ClassicFactory;
import activeObject.Proxy;

public class AlienArmy {
	int rows = 3;
	//The army has 3 rows of aliens
//	Alien rowOne[] = new Alien[10];
//	Alien rowTwo[] = new Alien[10];
//	Alien rowThree[] = new Alien[10];

	Alien allAliens[][]= new Alien[rows][10];

	//The direction the army is moving in
	boolean movingRight = true;

	//The number of pixels to move at a time
	int moveDistance = 15;

	//A container to store details of the current alien shots
	Vector alienShots = new Vector();  


	Ship ship;
	private SpaceInvaders spaceInvaders;
//	private Proxy proxy = spaceInvaders.getProxy();


	Image alienImage = null;

	public AlienArmy(Ship s, SpaceInvaders si, Image ai) {
		ship = s;
		spaceInvaders = si;
		alienImage = ai;

		//	alienImage = new javax.swing.ImageIcon("alienFull.jpg").getImage();

		//for now, type of factory is hard coded as the same as in space invaders. should be inputted in constructor 
		//when level types are set (boss/normal, etc) 
		AbstractFactory classic = si.factory;
		createArmy(classic);
		setStartingPositions();
	}

	public Proxy getProxy() {
		return spaceInvaders.getProxy();
	}
	/**
	 * In this method we initialise the 3 rows of aliens
	 * that make up the army.
	 */
	//private void createArmy() {
	private void createArmy(AbstractFactory factory){

		for (int j = 0; j < rows; j++) {
			for (int i=0;i<10;i++) {
				allAliens[j][i]=(Alien) factory.getAlien();
			}
		}	
	}

	/**
	 * Set where our alien army will start attacking from
	 */
	private void setStartingPositions() {

		int rowHeight = 50;//Set the height of the top row
		int leftStart = 50;//Sets the furtherest position to the left

		for (int j = 0; j < rows; j++) {
			for (int i=0;i<10;i++) {
				allAliens[j][i].setPosition(leftStart, rowHeight);
				leftStart+=40;
			}
			rowHeight += 50;//Ready for the next row
			leftStart = 50;
		}

		//		for (int i = 0; i < 10; i++) {
		//			rowOne[i].setPosition(leftStart, rowHeight);
		//			leftStart += 40;
		//		}
		//		rowHeight += 50;//Ready for the next row
		//		leftStart = 50;//Reset the left position
		//		for (int i = 0; i < 10; i++) {
		//			rowTwo[i].setPosition(leftStart, rowHeight);
		//			leftStart += 40;
		//		}
		//		rowHeight += 50;//Ready for the third row
		//		leftStart = 50;//Reset the left position
		//		for (int i = 0; i < 10; i++) {
		//			rowThree[i].setPosition(leftStart, rowHeight);
		//			leftStart += 40;
		//		}	


	}

	/**
	 * In this method we move the alien army.
	 */
	public void moveArmy() {

		if (movingRight) {
			//We are moving right
			for(int j=0;j<rows;j++) {
				//First step: Check if the alien furthest to the right has hit the edge
				for (int i = 9; i >= 0; i--) {//Notice how this loop counts down
					if (!allAliens[j][i].hasBeenHit()) {

						//If the alien has not been hit - then it is the edge
						//Now check if the alien if at the edge
						if (allAliens[j][i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
							//Change direction
							movingRight = false;


							//Set the new lower y positions
							for (int z = 0;z<rows;z++) {
							for (int y = 0; y < 10; y++) {
								allAliens[z][y].setPosition(allAliens[z][y].getXPos(), allAliens[z][y].getYPos()+moveDistance);
							}	
							}

							return;//Return from this method, don't bother checking the rest.

						}
					}
				}
				//				if (!rowTwo[i].hasBeenHit()) {
				//
				//					//If the alien has not been hit - then it is the edge
				//					//Now check if the alien if at the edge
				//					if (rowTwo[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
				//						//Change direction
				//						movingRight = false;
				//
				//
				//						//Set the new lower y positions
				//						for (int y = 0; y < 10; y++) {
				//							rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+moveDistance);
				//							rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+moveDistance);
				//							rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+moveDistance);
				//						}
				//
				//						return;//Return from this method, don't bother checking the rest.
				//
				//					}		   
				//
				//				}
				//				if (!rowThree[i].hasBeenHit()) {
				//
				//					//If the alien has not been hit - then it is the edge
				//					//Now check if the alien if at the edge
				//					if (rowThree[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
				//						//Change direction
				//						movingRight = false;
				//
				//
				//						//Set the new lower y positions
				//						for (int y = 0; y < 10; y++) {
				//							rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+moveDistance);
				//							rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+moveDistance);
				//							rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+moveDistance);
				//						}
				//
				//						return;//Return from this method, don't bother checking the rest.
				//
				//					}		  
				//
				//				}		
			}	    

			//Second step: Move everyone to the right
			for (int j=0;j<rows;j++) {
				for (int i = 0; i < 10; i++) {
					allAliens[j][i].setPosition(allAliens[j][i].getXPos()+moveDistance, allAliens[j][i].getYPos());
				} 	
			}




		} else {
			//We are moving left

			//First step: Check if the alien farthest to the left has hit the edge
			for (int j=0;j<rows;j++) {
				for (int i = 0; i < 10; i++) {//Notice how this loop counts down
					if (!allAliens[j][i].hasBeenHit()) {

						//If the alien has not been hit - then it is the edge
						//Now check if the alien if at the edge
						if (allAliens[j][i].getXPos() < Alien.ALIEN_WIDTH) {
							//Change direction
							movingRight = true;

							//Set the new lower y positions
							for (int z = 0;z<rows;z++) {
							for (int y = 0; y < 10; y++) {
								allAliens[z][y].setPosition(allAliens[z][y].getXPos(), allAliens[z][y].getYPos()+moveDistance);
								//								rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+moveDistance);
								//								rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+moveDistance);
							}
							}

							return;//Return from this method, don't bother checking the rest.		
						}

					}
					//					if (!rowTwo[i].hasBeenHit()) {
					//
					//						//If the alien has not been hit - then it is the edge
					//						//Now check if the alien if at the edge
					//						if (rowTwo[i].getXPos() < Alien.ALIEN_WIDTH) {
					//							//Change direction
					//							movingRight = true;
					//
					//							//Set the new lower y positions
					//							for (int y = 0; y < 10; y++) {
					//								rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+moveDistance);
					//								rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+moveDistance);
					//								rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+moveDistance);
					//							}
					//
					//							return;//Return from this method, don't bother checking the rest.		
					//						}		    
					//
					//					}
					//					if (!rowThree[i].hasBeenHit()) {
					//
					//						//If the alien has not been hit - then it is the edge
					//						//Now check if the alien if at the edge
					//						if (rowThree[i].getXPos() < Alien.ALIEN_WIDTH) {
					//							//Change direction
					//							movingRight = true;
					//
					//							//Set the new lower y positions
					//							for (int y = 0; y < 10; y++) {
					//								rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+moveDistance);
					//								rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+moveDistance);
					//								rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+moveDistance);
					//							}

					//							return;//Return from this method, don't bother checking the rest.		
					//						}	

					//					}		
				}
			}

			//Second step: Move everyone to the left
			for (int j=0;j<rows;j++) {
				for (int i = 0; i < 10; i++) {
					allAliens[j][i].setPosition(allAliens[j][i].getXPos()-moveDistance, allAliens[j][i].getYPos());
					//					rowTwo[i].setPosition(rowTwo[i].getXPos()-moveDistance, rowTwo[i].getYPos());
					//					rowThree[i].setPosition(rowThree[i].getXPos()-moveDistance, rowThree[i].getYPos());
				}	    
			}

		}
		//Start some random alien firing!
		//		Random generator = new Random();
		//		int rnd1 = generator.nextInt(10);
		//		int rnd2 = generator.nextInt(10);
		//		int rnd3 = generator.nextInt(10);
		//		if (!rowOne[rnd1].hasBeenHit()) {
		//			AlienShot as = new AlienShot(rowOne[rnd1].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowOne[rnd1].getYPos(), ship,rowOne[rnd1]);
		//			alienShots.addElement(as);
		//		}
		//		if (!rowOne[rnd2].hasBeenHit()) {	
		//			AlienShot as = new AlienShot(rowTwo[rnd2].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowTwo[rnd2].getYPos(), ship, rowTwo[rnd2]);
		//			alienShots.addElement(as);
		//		}
		//		if (!rowOne[rnd3].hasBeenHit()) {	
		//			AlienShot as = new AlienShot(rowThree[rnd3].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowThree[rnd3].getYPos(), ship, rowThree[rnd3]);
		//			alienShots.addElement(as);
		//		}
		
		//random alien firing with odds of firing set to x%
		double odds = 2; //n out of 10 chances of it firing
		Random generator = new Random();
		for (int j=0;j<rows;j++) {
			int shoots = generator.nextInt(10);
			int alienNumb = generator.nextInt(10);
			if (shoots<odds&&!allAliens[j][alienNumb].hasBeenHit()) {
				AlienShot as = new AlienShot(allAliens[j][alienNumb].getXPos()+(int)(Alien.ALIEN_WIDTH/2), allAliens[j][alienNumb].getYPos()+(int)(Alien.ALIEN_HEIGHT/2), ship,allAliens[j][alienNumb]);
				alienShots.addElement(as);
				as.animate();
			}
		}
	
	}

	/**
	 *
	 */
	public void drawArmy(Graphics g) {
		//Draw the first row
		for(int j=0;j<rows;j++) {
			for (int i = 0; i < 10; i++) {
				allAliens[j][i].drawAlien(g);//Draw the first row
				//			rowTwo[i].drawAlien(g);//Draw the second row
				//			rowThree[i].drawAlien(g);//Draw the third row
			} 
		}
		//Now we need to draw any of the shots the aliens have fired
		Vector tmp = new Vector();
		for (int i = 0; i < alienShots.size(); i++) {
			AlienShot as = (AlienShot)alienShots.elementAt(i);
			//Need to remove old shots at this point!
			if (as.getShotState()) {
				//This is NOT an old shot
				tmp.addElement(as);
			}

			as.drawShot(g);


		}
		alienShots = tmp;
	}

	/**
	 * This is where the collision detection takes place
	 */
	/*public Alien checkShot(int x, int y) {
		for (int i = 0; i < 10; i++) {
			if (rowOne[i].hitAlien(x, y)) {
				spaceInvaders.hitAlienScore();
				return rowOne[i];
						}
			if (rowTwo[i].hitAlien(x, y)) {
				spaceInvaders.hitAlienScore();		    
				return rowTwo[i];
						}
			if (rowThree[i].hitAlien(x, y)) {
				spaceInvaders.hitAlienScore();		    
				return rowThree[i];
			//	return true;
			}	    
		}
		return new Alien(null, null);
		//return false;
	}*/

	public boolean checkShot(int x, int y) {

		ConcreteElement1 el1 = new ConcreteElement1(spaceInvaders);
		ConcreteElement2 el2 = new ConcreteElement2(spaceInvaders);
		ConcreteElement3 el3 = new ConcreteElement3(spaceInvaders);

		Visitor e1 = new Concretevisitor1();
		Visitor e2 = new Concretevisitor2();
		Visitor e3 = new Concretevisitor3();

			for (int i = 0; i < 10; i++) {
				if (allAliens[0][i].hitAlien(x, y)) {

					el1.accept(e1);
				}
				if (allAliens[1][i].hitAlien(x, y)) {

					el2.accept(e2);
				}
				if (allAliens[2][i].hitAlien(x, y)) {

					el3.accept(e3);
				}	    
			}
		return false;
	}

}
