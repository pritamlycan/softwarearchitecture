package mvc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class View extends JFrame {
	

	private JTextField usrname = new JTextField(20);

	private JButton checkUsername = new JButton("Filter It");
	private JTextField passResult = new JTextField(20);
	private JCheckBox noSpace = new JCheckBox("no spaces filter");
	private JCheckBox tooLong = new JCheckBox("too long filter");
	private JCheckBox noCap = new JCheckBox("only capitals filter");
	private JCheckBox noNum = new JCheckBox("no numbers filter");
	private JButton toGame = new JButton("Continue to game");

	public View() {

		// set up the GUI for the user make it look pretty

		JPanel calcPanel = new JPanel();
		JPanel filterPanel = new JPanel();
		JPanel continueToGame = new JPanel();
		//calcPanel.setBackground(Color.grey);
		//filterPanel.setBackground(Color.black);
		//continueToGame.setBackground(Color.black);
		calcPanel.setBorder(BorderFactory.createTitledBorder("Username Check"));
		filterPanel.setLayout(new GridLayout(4, 1));
		filterPanel.setBorder(BorderFactory.createTitledBorder("filters"));
		continueToGame.setLayout(new GridLayout(4, 1));
		continueToGame.setBorder(BorderFactory.createTitledBorder("Continue to game"));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);

		calcPanel.add(usrname);
		calcPanel.add(checkUsername);
		calcPanel.add(passResult);
		filterPanel.add(noSpace);
		filterPanel.add(tooLong);
		filterPanel.add(noCap);
		filterPanel.add(noNum);
		continueToGame.add(toGame);

		// add this to the frame
		this.add(calcPanel, BorderLayout.PAGE_START);
		this.add(filterPanel, BorderLayout.LINE_START);
		this.add(continueToGame, BorderLayout.CENTER);

	}

	// return if user wants no space filter\

	public boolean getNoSpace() {
		return noSpace.isSelected();
	}

	// return a short username

	public boolean gettooLong() {

		return tooLong.isSelected();

	}

	// return idf user wants no lowercase filter

	public boolean onlyCaps() {

		return noCap.isSelected();

	}

	// returns if user wants no numbers in username

	public boolean getNoNum() {

		return noNum.isSelected();

	}

	// returns the users entered username

	public String getUsername() {
		return usrname.getText();
	}

	// this is the order of filters

	public String[] getOrder() {
		String[] temp = { "1", "2", "3", "4" };
		return temp;
	}

	public void setUsernamePassOrFail(String result) {
		passResult.setText(result);
	}

	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed

	void addCalculateListener(ActionListener listenForCalcButton) {

		checkUsername.addActionListener(listenForCalcButton);

	}

	// throw a nasty message if you try and mess with my program
	void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);

	}

}
