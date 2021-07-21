/* *************************************************************
 * Programmer Name: Nandita Lohani 
 * Date: June 16, 2021
 * *************************************************************
 * Purpose: 'Cruise'ship, a simplistic alternate version of the classic game Battleship, where players battle each other's 5 cruise ships 
 *          until one player has no ships left. 
 */
package cruiseship;

import javax.swing.JOptionPane;

public class cruisehipetester {
	public static void main(String[] args){
		 
    	String space = "        ";
    	int input = 0;
    	
    	try { 
    	//ask for user input
    	input = Integer.parseInt(JOptionPane.showInputDialog
    			( space+space+space+space+ " ! WELCOME TO 'CRUISE'SHIP !" 
    	+ "\n\n" +space+ "Cruiseship is a strategy type guessing game for two players."
    	+ "\nThis game is played on ruled grids where each player marks their ships."
    	+ "\n  The objective of this game is to destroy the opposing player's fleet."
    	+ "\n\n Press 1 - Continue"
    	+ "\n Press 2 - EXIT"));
    	
    	} catch (NumberFormatException nfe) {
    		//exit the program if an error occurs
    		System.exit(0);
    	}
    	
    	
    	if (input == 2) {
    		System.exit(0);
    	
    	} else if (input == 1){
    		JOptionPane.showMessageDialog(null, " Here are the rules to the game:" 
    		+ "\n\n- Player1 will place 5 ships on the grid using XY coordinates." 
    	    + "\n- Only one ship can occupy any given square on the grid." 
    	    + "\n- Player2 or the computer will also place 5 ships on the grid using XY coordinates." 
    	    + "\n- Once both players have deployed their ships, the battle begins."
    	    + "\n- Each player chooses a target in the opponet's grid to shoot."
    	    + "\n- If a player looses all of their ships, the other player wins."
    	    + "\n\n Please be careful not to press random keys "
    	    + "(i.e unnecessary enter/return button) during a prompt! "
    	    + "\nThis can cause the game to exit."
    	    + "\n\n ( ! ) = Sunken Ships   ( - ) = Missed Location"
    	    + "\n\n LET THE GAME BEGIN!");
    	
            //create the ocean grid
    		cruiseship.createPlayer1OceanGrid();
    		cruiseship.createPlayer2OceanGrid();
    		
    		//place Player 1's ships
    		cruiseship.placePlayer1Ships();

    		//place Player 2' ships
    		cruiseship.placePlayer2Ships();

    		// BATTLE MODE
    		do {
    			cruiseship.game();
    		}while(cruiseship.player1Ships != 0 && cruiseship.player2Ships != 0);

    		//show final scores and victory message
    		cruiseship.gameOver();
         
    	} else { 
    		//display invalid message and close the program
    		JOptionPane.showMessageDialog(null, space+"   Invalid input!");
    		System.exit(0);
    	}
    }
}
