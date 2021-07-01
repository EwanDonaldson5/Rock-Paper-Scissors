import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interface extends JFrame implements ActionListener{
	JPanel content = new JPanel();//create jpanel to hold the content 
	JPanel controls = new JPanel();//create jpanel to hold the controls of the game
	public JTextArea display = new JTextArea();//create text area to hold the computer output
	public JLabel scoreLabel = new JLabel("score: 0");//create label to hold the score
	
	public JButton rockButton = new JButton("ROCK");//create button for selecting rock
	public JButton paperButton = new JButton("PAPER");//create button for selecting paper
	public JButton scissorsButton = new JButton("SCISSORS");//create button for selecting scissors
	public JButton newGame = new JButton("New Game");//create button for starting a new game
	public JButton endGame = new JButton("End Game");//create button for ending the game
	
	public String userChoice = "";//create string to hold the choice made by the user
	Boolean gameStarted = false;//create boolean to represent if game has begun
	Computer comp;//create computer class object
	public int score = 0;//var holds the users score
	
	Interface(){//constructor
		initComponents();//initialise the interface components
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//when a button is pressed
		if(e.getSource() == newGame) {//if the new game button is pressed
			gameStarted = true;//set the game start boolean to true
			comp = new Computer();//create the computer using external class
			comp.startGame(this);//call method to start the game
		}
		
		if(e.getSource() == endGame) {//if the end game button is pressed
			System.exit(0);//exit the application
		}
		
		if(gameStarted) {//if the game has started
			if(e.getSource() == rockButton) {//if the rock button is pressed
				userChoice = "Rock";//set user choice var to rock
				comp.decisionMade(userChoice);//call method that a decision has been made
			}
			
			if(e.getSource() == paperButton) {//if the paper button is pressed
				userChoice = "Paper";//set users choice to paper
				comp.decisionMade(userChoice);//call method that a decision has been made
			}
			
			if(e.getSource() == scissorsButton) {//if the scissors button is pressed
				userChoice = "Scissors";//set the user choice to scissors
				comp.decisionMade(userChoice);//call method that a decision has been made
			}
		}
		
	}
	
	//method will enable or disable the game option buttons depending on the parsed variable
	public void setChoiceEnabled(Boolean bool) {
		rockButton.setEnabled(bool);//set the enabled value of the rock button
		paperButton.setEnabled(bool);//set the enabled value of the paper button
		scissorsButton.setEnabled(bool);//set the enabled value of the scissors button
	}
	
	//method initialises the components of the user interface
	private void initComponents(){
		this.setSize(500, 600);//set the size of the jframe
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));//assign a vertical layout to the content jpanel
		content.setSize(this.getWidth(), this.getHeight());//set the size of the content jpanel to the size of the frame
		
		//display.setMinimumSize(new Dimension(380,300));
		//display.setMaximumSize(new Dimension(380,300));
		display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//set a border around the text area
		
		//controls.setBackground(Color.red);
		controls.setLayout(new BoxLayout(controls, BoxLayout.X_AXIS));//assign a horizontal layout to the controls jpanel
		
		JScrollPane scrollPane = new JScrollPane(display);//create a scroll pane for the text area to be contained within
		display.setEditable(false);//prevent user input in the text area
		
		this.add(content);//add the content jpanel to the frame
		content.add(scrollPane);//add the scrollpane to the content jpanel
		content.add(controls);//add the controls panel to the content jpanel
		
		controls.add(rockButton);//add the rock button to the controls panel
		controls.add(paperButton);//add the paper button to the controls panel
		controls.add(scissorsButton);//add the scissors button to the controls panel
		controls.add(newGame);//add the new game button to the controls panel
		controls.add(endGame);//add the end game button to the controls panel
		controls.add(scoreLabel);//add the score label to the controls panel
		
		this.setLocationRelativeTo(null);//set the game to appear in the centre of the screen
		this.setVisible(true);//set the game to visible
		
		rockButton.addActionListener(this);//add action listener to the rock button
		paperButton.addActionListener(this);//add action listener to the paper button
		scissorsButton.addActionListener(this);//add action listener to the scissors button
		newGame.addActionListener(this);//add action listener to the new game button
		endGame.addActionListener(this);//add action listener to the end game button
		
		setChoiceEnabled(false);//call method to disable the game option buttons
	}
}
