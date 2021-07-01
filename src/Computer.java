import java.util.Random;

public class Computer {
	Interface game;//create game interface object
	String userChoice;//var holds the users choice
	String compChoice;//var holds the computers choice
	
	//method is called to begin the game
	public void startGame(Interface game) {
		this.game = game;//obtain the parsed reference to the interface
		game.setChoiceEnabled(true);//call method to enable the game option buttons
		game.display.append("Welcome, when you're ready select your choice. \n");//display message to user
		game.display.append("I will make my decision at the same time. \n");//display message to user
		game.display.append("\n");//create a blank space
	}
	
	//method is called once the user has selected a game option
	//the users selected is parsed as a var
	//method will run over again if the user and computer chose the same option
	public void decisionMade(String userChoice) {
		String choice = "";//var holds the choice made by the computer
		
		int val = getRandomNumberInRange(1,3);//call method to get a random number between 1 and 3
		this.userChoice = userChoice;//set global variable to parsed local var
				
		switch(val) {//switch statement based on the generated integer
			case 1://if the generated value is 1
				choice = "Rock";//set the computers choice to rock
			break;
				
			case 2://if the generated value is 2
				choice = "Paper";//set the computers choice to paper
			break;
				
			case 3://if the generated value is 3
				choice = "Scissors";//set the computer chocie to scissors
			break;
		}
		compChoice = choice;//update th global variable with the obtained choice
		
		if(!userChoice.equals(compChoice)) {//if the user choice and computer choice aren't the same
			game.setChoiceEnabled(false);//call method to disable the game option buttons
			game.display.append("You chose " + userChoice + "\n");//display users choice
			game.display.append("I chose " + choice + "\n");//display computers choice
			
			int winVal = detectWinner();//set var to return of method that detects the winner
			if(winVal == 1) {//if the return value is 1 then the user has won
				game.display.append("You won! \n");//display message
				game.score++;//increment the score variable
				game.scoreLabel.setText("score:" + game.score);//update the socre displayed on the interface
				
			}else {//if the user lost the game
				game.display.append("You Lost! \n");//display message
			}
			game.display.append("\n");//create a line space
			game.gameStarted = false;//set global game started var to false as the game is over
			
		}else {//if the user and computer choices were the same then re-call method to run again
			decisionMade(userChoice);//call method with users choice
		}
	}
	
	//method is called to detect the winner of the game
	//value returned represents winner with 1, and loser with 0
	//by default sets computer to winner and check through scenarios where user would win
	private int detectWinner() {
		int val = 0;//zero means player loses
		
		if(userChoice.equals("Scissors") && compChoice.equals("Paper")) {//if player chose scissors and computer chose paper
			val = 1;//player wins
		}else
		if(userChoice.equals("Paper") && compChoice.equals("Rock")) {//if player chose paper and computer chose rock
			val = 1;//player wins
		}else
		if(userChoice.equals("Rock") && compChoice.equals("Scissors")) {//if player chose rock and computer chose scissors
			val = 1;//player wins
		}
		
		return val;//return the value
		
	}
	
	//method generates a random number from within a range (1-3)
	private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {//if the min is greater than the max
            throw new IllegalArgumentException("max must be greater than min");//throw error message
        }

        Random r = new Random();//generate new number
        return r.nextInt((max - min) + 1) + min;//return number from within the range
    }
}
