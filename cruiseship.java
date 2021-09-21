/* *************************************************************
 * Programmer Name: Nandita Lohani and Lysistrata Chin-Kanelakis
 * Date: June 16, 2021
 * *************************************************************
 * Purpose: 'Cruise'ship, a simplistic alternate version of the classic game Battleship, where players battle each other's 5 cruise ships 
 *          until one player has no ships left. 
 */
package cruiseship;

import java.util.Random;
import javax.swing.JOptionPane;

public class cruiseship {
	//set variables as public for easier access
    public static int row1 = 8;
    public static int col1 = 8;
    public static int row2 = 8;
    public static int col2 = 8;
    public static int player1Ships;
    public static int player2Ships;
    public static String[][] grid1 = new String[row1][col1];
    public static String[][] grid2 = new String[row2][col2];
 
    
    public static int getplayer1Ships() { 
    	return player1Ships;
    }
    
    public static int getplayer2Ships() { 
    	return player2Ships;
    }
    
    public static void createPlayer1OceanGrid(){
    	System.out.println("Player 1's Grid" + "\n");
    	//creating the top, horizontal area of grid1
    	System.out.print("  ");
    		
    	for(int i = 0; i < col1; i++)
    		System.out.print(i);
    	System.out.println();

    	//creating the vertical side and the bars of grid1 
    	for(int i = 0; i < grid1.length; i++) {
    		for (int j = 0; j < grid1[i].length; j++) {
    			grid1[i][j] = " ";
    			if (j == 0) 
    				System.out.print(i + "|" + grid1[i][j]);
    			
    			
    			else if (j == grid1[i].length - 1) 
    				System.out.print(grid1[i][j] + "|");
    			else 
    				System.out.print(grid1[i][j]);
    		    
    		}
    		System.out.println();
    	}
    }
    public static void createPlayer2OceanGrid() {
    	System.out.println("\nPlayer2's Grid" + "\n");
    	//creating top, horizontal area of grid2
    	System.out.print("  ");
        for(int i = 0; i < col2; i++)
                System.out.print(i);
        System.out.println();
        
        //creating the vertical side and the bars of grid2 
        for(int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                grid2[i][j] = " ";
                if (j == 0) 
                    System.out.print(i + "|" + grid2[i][j]);
                
                
                else if (j == grid1[i].length - 1) 
                    System.out.print(grid1[i][j] + "|");
                
                else 
                    System.out.print(grid2[i][j]);
            	
            }
            System.out.println();
        }
    } 
    public static void placePlayer1Ships(){

        System.out.println("\n\nPlacing ships for Player 1:");
        //place 5 ships for player1
        cruiseship.player1Ships = 5;
        
        int x = 0; 
        int y = 0;
        
        //ask for user input
        for (int i = 1; i <= cruiseship.player1Ships; ) {
        try {
        	x = Integer.parseInt(JOptionPane.showInputDialog("Player 1:" 
        + "\nEnter X coordinate for your ship #" +i+ ":"));
        }   
         catch (NumberFormatException nfe) {
        	 System.exit(0);
        }
        try {
            y = Integer.parseInt(JOptionPane.showInputDialog("Player 1:" 
        + "\nEnter Y coordinate for your ship #" +i+ ":"));
        }catch  (NumberFormatException nfe) {
        	System.exit(0);
        }

            if((x >= 0 && x < row1) && (y >= 0 && y < col1) && (grid1[x][y] == " ")){
            	grid1[x][y] = "&";
                System.out.println(i + ". SHIP HAS BEEN PLACED");
                i++;
            }
            else if((x >= 0 && x < row1) && (y >= 0 && y < col1) && grid1[x][y] == "&")
            	JOptionPane.showMessageDialog(null,
            			"You can't place more than one ship in the same location");
           
            else if((x < 0 || x >= row1) || (y < 0 || y >= col1)) 
            	JOptionPane.showMessageDialog(null,"You can't place ships outside of the grid");
        
            
        }
        printOceanGrid1();
    }
    
    public static void placePlayer2Ships(){
        System.out.println("\n\nPlacing ships for Player2:");
        //place 5 ships for player2
        cruiseship.player2Ships = 5;
        
       //computer input
        for (int i = 1; i <= cruiseship.player2Ships; ) {
           Random rand1 = new Random();
           Random rand2 = new Random();
           
           int x = rand1.nextInt(8) + 1; 
           int y = rand2.nextInt(8) + 1; 
           
           if((x >= 0 && x < row1) && (y >= 0 && y < col1) && (grid2[x][y] == " ")){
           	grid2[x][y] = "&";
               System.out.println(i + ". SHIP HAS BEEN PLACED");
               i++;
           }
        }
    }

    public static void game(){
        player1();
        player2();

        printOceanGrid1();
        
        System.out.println();
        System.out.println("Player1 ships: " + cruiseship.player1Ships 
        		+ " | Player2 ships: " + cruiseship.player2Ships);
        System.out.println();
    }

    public static void player1(){
        System.out.println("\nPLAYER1'S TURN");
        int x = -1, y = -1;
        
        do {
        	try {
        		x = Integer.parseInt(JOptionPane.showInputDialog
        				("Time to sink some cruise ships!!" + "\nPlayer 1: \nEnter X coordinate: "));
        	}catch (NumberFormatException nfe) {
        		System.exit(0);
        	}
        	
        	try { 
        		y = Integer.parseInt(JOptionPane.showInputDialog
        				("Time to sink some cruise ships!! \nPlayer 1: \nEnter Y coordinate: "));
        	} catch (NumberFormatException nfe) {
        		System.exit(0);
        	}

            if ((x >= 0 && x < row2) && (y >= 0 && y < col2))  {
            	//if player 2's ship is there, player 2 loses their ship
            	if (grid2[x][y] == "&") {
                    System.out.println("MURDERR!! Player1 just sunk one of Player2's ship!");
                    //display player 2's sunken ship
                    grid2[x][y] = "!"; 
                    //decrement player 2's ships
                   cruiseship.player2Ships--;
                }
                else if (grid2[x][y] == " ") {
                    System.out.println("OOPS, Player1 missed");
                    grid2[x][y] = "-";
                    System.out.println("No ships on [" +x+ "," +y+ "]");
                } 
                else if (grid2[x][y] == "-") {
                	System.out.println("You already tried to put a ship here!");
                }
            }
            //if player1's guess is invalid 
            else if ((x < 0 || x >= row2) || (y < 0 || y >= col2))  
                JOptionPane.showMessageDialog(null, "You can't place ships outside the grid");
        
          //until player 1 makes a valid guess, keep looping the code
        } while((x < 0 || x >= row2) || (y < 0 || y >= col2));  
    }

    public static void player2(){
        System.out.println("\nPLAYER2'S TURN");
        Random rand1 = new Random();
        Random rand2 = new Random();
        int x; 
        int y;

        //execute the code, before checking the condition
        do {
            x = rand1.nextInt(8) + 1; 
            y = rand2.nextInt(8) + 1;
            
            if ((x >= 0 && x < row1) && (y >= 0 && y < col1)) {
            	//if player1 ship's is already there; player1 loses ship and computer wins
                if (grid1[x][y] == "&") {
                    System.out.println("WOW!! Player2 sunk one of Player 1's ships!");
                    //display player 1's sunken ship
                    grid1[x][y] = "!";
                    //decrement player 1's ships
                   cruiseship.player1Ships--;
                }
                else if (grid1[x][y] == " ") {
                    System.out.println("OOPS, Player2 missed");
                    grid1[x][y] = "-";
                }
            }

            //until player 1 makes a valid guess, keep looping the code
        } while((x < 0 || x >= row1) || (y < 0 || y >= col1));  
    }

    public static void gameOver(){
        //display the number of ships each player has left 
    	System.out.println("================================================");
    	System.out.println("Player 1 ships: " + cruiseship.player1Ships 
    			+ " | Player 2 ships: " + cruiseship.player2Ships);
        if(cruiseship.player1Ships > 0 && cruiseship.player2Ships <= 0) 
        	//display player 1 victory message
        	System.out.println("Congratualtions Player1! You have won the battle");
        else 
        	//display player 2 victory message 
        	System.out.println("Congratualtions Player2! You have won the battle");
        System.out.println();
            
   }

    public static void printOceanGrid1(){
        System.out.println("\n\nPlayer1's Grid");
    	System.out.println();
        //top, horizontal area of the grid
        System.out.print("  ");
        for(int i = 0; i < col1; i++)
            System.out.print(i);
        System.out.println();

        //vertical side of the grid and the bars of the grid 
        for(int j = 0; j < grid1.length; j++) {
            System.out.print(j + "|");

            for (int k = 0; k < grid1[j].length; k++){
                System.out.print(grid1[j][k]);
            }
            System.out.println("|");
        }
    }
}
