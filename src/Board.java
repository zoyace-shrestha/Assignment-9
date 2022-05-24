
/**
 * Board class for the Battleship game.  
 * 
 * A board is an nxn array containing one each of: Carrier
 *                                                 Battleship
 *                                                 Destroyer
 *                                                 Submarine
 *                                                 PTBoat
 * 
 * @author David Mathias 
 * @version November 12, 2013
 * 
 * 
 * This program is a two player game where there is a board and ships are placed 
 * randomly in the board players have to guess the location of the board by guessing 
 * the rows and columns and and if they guess the coordinate of the ship correctly the
 * board will show as a hit and if the guess is wrong it shows as a miss. Whoever sinks 
 * the opponents boards first wins.
 * 
 * Zoyace Shrestha
 * CS-120 Section 01
 * Fall 2019
 * 
 * Programming Assignment 8
 * December 9th 2019
 * 
 */

import java.util.Scanner;

public class Board
{
    // class variables
    // If the number of ships is changed, the constructor must be
    // updated as well
    
    // When debug is true, positions of ships will be shown when the
    // board is displayed.  This is helpful when testing the game since
    // you won't have to guess the ships' locations.
    final static boolean debug = true;
    final static int board_size = 10;
    final static int num_ships = 5;
    
    // Characters printed when the board is displayed.  Not all are used.
    final static char hit = 'H';
    final static char miss = 'M';
    final static char used = 'S';
    final static char blank = ' ';
    final static char sunk = 'X';
    
    // instance variables - replace the example below with your own
    private char[][] board = new char[board_size][board_size];
    private int num_sunk;
    private Ship[] ships = new Ship[num_ships];
    
    private Scanner scanIn;
    
    
    /**
     * Default constructor for objects of class Board
     */
    public Board(Scanner s)
    {
        // initialise instance variables
        scanIn = s;
        
        num_sunk = 0;
        initializeBoard();
        
        // create the ships
        ships[0] = new PTBoat();
        hideShip(0);
        ships[1] = new Submarine();
        hideShip(1);
        ships[2] = new Destroyer();
        hideShip(2);
        ships[3] = new Battleship();
        hideShip(3);
        ships[4] = new Carrier();
        hideShip(4);
    }
    
    
    /**
     * Set every board position to blank
     */
    private void initializeBoard()
    {
        for(int i=0; i < board_size; i++)
        {
            for(int j=0; j < board_size; j++)
            {
                board[i][j] = blank;
            }
        }
    }
   
    
    /**
     * Place a ship on the board at a random but valid location.
     * In other words, a ship can't go beyond the bounds of the board
     * or intersect another ship.
     * 
     * Parameter: int s - index into the array of ships
     */
    private void hideShip(int s)
    {
        boolean valid = false;
        
        // keep looking until a randomly generated position is valid
        while(!valid)
        {
            // choose a direction and a starting row or column
            int start = (int)(Math.random() * (board_size - ships[s].getSize()));
            int dir = (int)(Math.random() * 2);
            
            if(dir == 0)    // horizontal
            {
                ships[s].setDir(0);
                ships[s].setCol(start);
                int row = (int)(Math.random() * 32767) % board_size;
                ships[s].setRow(row);
                valid = true;
                for(int i=0; i < ships[s].getSize(); i++)
                {
                    valid = (valid && (board[row][start + i] != used));
                }
                if(valid)
                {
                    for(int i=0; i < ships[s].getSize(); i++)
                    {
                        board[row][start + i] = used;
                    }
                }
            }
            else    // dir == 1, vertical
            {
                ships[s].setDir(1);
                ships[s].setRow(start);
                int col = (int)(Math.random() * 32767) % board_size;
                ships[s].setCol(col);
                valid = true;
                for(int i=0; i < ships[s].getSize(); i++)
                {
                    valid = (valid && (board[start + i][col] != used));
                }
                if(valid)
                {
                    for(int i=0; i < ships[s].getSize(); i++)
                    {
                        board[start + i][col] = used;
                    }
                }
            }
        }
    }		

    	
    /*
     * Changes the value of S to X if the ship is sunk
     */
    
    private void sunkenShip(int x)
    {
    	//find the direction and the used row or column
    	int start = ships[x].getSize();
    	int dir = ships[x].getDirection();
    	int row = ships[x].getStartRow();
    	int col = ships[x].getStartCol();
    	
    	if (dir == 0)		//horizontal
    	{
    			for(int i = 0 ; i < start ; i ++)
    			{
    				board[row][col + i] = sunk;
    			}
    	}
    	
    	else if ( dir == 1)	//vertical
    	{
    			for ( int i = 0 ; i < start ; i++)
    			{
    				board[row + i][col] = sunk;
    			}
    	}
    }
    
    /**
     * Return true if all of the ships on the board have been sunk
     */
    public boolean allSunk()
    {
        return (num_sunk == num_ships);
    }
    
    
    /**
     * Output a representation of the board
     */
    public void printBoard()
    {
        System.out.printf("  ");
        for(int i=0; i < board_size; i++)
        {
            System.out.printf("%4d", i);
        }
        System.out.printf("%n%n");
        
        // for each board position, print blank, hit or miss
        for(int i=0; i < board_size; i++)
        {
            System.out.printf("%d ", i);
            for(int j=0; j < board_size; j++)
            {
                // don't want to reveal position of ships when printing
                // the board so print a blank instead
                if(board[i][j] == used && !debug)
                {
                    System.out.printf("%4c", blank);
                }
                else
                {
                    System.out.printf("%4c", board[i][j]);
                }
            }
            
            System.out.printf("%n%n");
        }
    }
    
    
    /**
     * Get a guess from the user.  Make sure it hasn't been guessed 
     * previously.  Call evaluateGuess to see if it is a hit or a miss.
     */
    public void makeGuess()
    {
        // boolean flag variable
        boolean done = false;
        int row=-1, col=-1;
        
        while(!done)
        {
            // prompt user and read values
            System.out.printf("%n Enter a row (0 -- %d): ", board_size - 1);
            row = scanIn.nextInt();
            System.out.printf("%n Enter a column (0 -- %d): ", board_size - 1);
            col = scanIn.nextInt();
            
            // if this position has already been guessed, repeat
            if((board[row][col] == hit || board[row][col] == miss || board[row][col] == sunk))
            {
                System.out.printf("You've already guessed that position.  Please guess again.%n");
            }
            else
            {
                done = true;
            }
        }
        
        // now that we have a valid guess, check to see if it is
        // a hit or a miss
        evaluateGuess(row, col);
    }
    
    
    /**
     * Determine if a guess is a hit or a miss
     * 
     * Parameters: int r - row of guess
     *             int c - column of guess
     */
    private void evaluateGuess(int r, int c)
    {
        // assume the guess is a miss until we see otherwise
        int i = 0;
        boolean is_hit = false;
        
        // check each ship by calling the Ship isAHit method
        while((i < num_ships) && !is_hit)
        {
            // if it's a hit, update that board position to hit
            if(ships[i].isAHit(r, c))
            {
                System.out.printf("That's a Hit! %n");
                board[r][c] = hit;
                is_hit = true;
                if(ships[i].isSunk())
                {
                    num_sunk++;
                    sunkenShip(i);
                    System.out.printf("You sunk my %s!%n%n", ships[i].getName());
                }
            }
            i++;
        }
        // if it's a miss, update board position to miss
        if(!is_hit)
        {
            board[r][c] = miss;
            System.out.printf("%nThat's a miss.%n");
        }
    }    
}
