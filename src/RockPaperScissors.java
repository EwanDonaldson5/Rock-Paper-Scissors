import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class RockPaperScissors{
	static Interface game;//create game interface object
	
	public static void main(String args[]) {
		//open popup window to ask if the user still wishes to proceed
		int choice = JOptionPane.showConfirmDialog(null, "Are you ready to play?", "Rock Paper Scissors", JOptionPane.YES_NO_OPTION);
		if(choice == 1) {//if the user selected no
			System.exit(0);//exit the program
			
		}else {//if the user selected yes
			game = new Interface();//start the game
		}
	}
}
