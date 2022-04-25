package pool;
import javax.swing.*;

public class Bridge{
  Bridge() 
  {
    JFrame f = new JFrame("Add an image to JFrame");
    ImageIcon icon = new ImageIcon("/Users/keijeff/Desktop/Virtual Studio Code/softwarearchitecture/FinalSpaceInvaders/src/spaceinvaders/bridge.jpg");
    f.add(new JLabel(icon));
    f.pack();
    f.setVisible(true);
  }
  public static void main(String args[]) 
  {
    new Bridge();
  }
}