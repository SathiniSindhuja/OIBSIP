import javax.swing.JOptionPane;
import java.util.Scanner;

public class guessnum {
	static int left_attempts = 0;
	static int total = 0;	
	Scanner sc = new Scanner(System.in);

	void addAttempts() {
		int i = 0 , total = 0;
	    int input = JOptionPane.showConfirmDialog(null,"Do you want to add  Attempts");
	    if (input == JOptionPane.YES_OPTION) {
	    	String numOfTrails = JOptionPane.showInputDialog("Number of Attempts you want to add: ");
	    	guess(i,numOfTrails);
	    } 
	    else if (input == JOptionPane.NO_OPTION) {
	    	if (total == 0) {
	    		JOptionPane.showMessageDialog(null,"Result Not Generated because, \n User didn't guess the number");
	    	}
	    	else {
	    		displayScore(left_attempts,total);
	    	}
	    	
	    }
	}
	
	
	void guess(int i ,String numOfTrails) {
	 
		total = Integer.parseInt(numOfTrails);
		
		System.out.print("Random value from 1 to 100 is: ");
	    int random_num = (int)(Math.random()*100+1);
	    System.out.println(random_num);
	    left_attempts = Integer.parseInt(numOfTrails);
	    
		while(i < left_attempts) {
		    String num = JOptionPane.showInputDialog("Guess the number: ");
		    
			if(random_num == Integer.parseInt(num)) {
				JOptionPane.showMessageDialog(null,"Guessed number matches the Random Number!!!");
				break;
		    }
		    else if(random_num > Integer.parseInt(num)) {
		    	JOptionPane.showMessageDialog(null,"Try Again!!! \nGuessed number is smaller than the Random number");
		    	JOptionPane.showMessageDialog(null,left_attempts-1 + " attempts left.");
		    }
		    else if(random_num < Integer.parseInt(num)) {
		    	JOptionPane.showMessageDialog(null,"Try Again!!! \nGuessed number is greater than the Random number");
		    	JOptionPane.showMessageDialog(null,left_attempts-1 + " attempts left.");
		    }

			i++;
			left_attempts--;
		}
		displayScore(left_attempts,total);
	}
	
	void displayScore(int left_attempts, int total) {
		double score = (left_attempts * 100)/total;
		JOptionPane.showMessageDialog(null,"You got "+ score + "%");
	}
	
	public static void main(String[] args) {
		guessnum n1 = new guessnum();   
	    n1.addAttempts();
		
	}

}