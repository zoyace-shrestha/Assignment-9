
/**
 * Ship class for the Battleship game.
 * 
 * Superclass: none (Object)
 * Subclasses: Carrier
 *             Battleship
 *             Destroyer
 *             Submarine
 *             PTBoat
 *             
 * Attributes: int size - the number of board positions for this ship
 *                        note that size is intitalized in the subclasses
 *             int start_row - the first row on which this ship appears
 *             int start_col - the first columb on which this ship appears
 *             int direction - is this ship horizontal or vertical on the board
 *             int hits - number of times this ship has been hit
 *             boolean sunk - if this ship has been sunk or not
 * 
 * You must declare the attributes, complete the body of the isAHit method 
 * as well as all of the getters and setters.  isAHit is a complicated 
 * operation -- reason it through before you start coding.  
 * 
 * @author 
 * @version 
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

public class Ship
{
    // class variables
    // Constants used to encode direction
    // What does the static keyword mean in this context?
    protected static final int horizontal = 0;
    protected static final int vertical = 1;
    
    // instance variables (attributes) go here
    int hits;
    int size;
    boolean sunk;
    int start_row;
    int start_col;
    int direction;
    boolean hit;



    // Are any objects of type Ship ever declared?
    // Think about what this means for when these
    // constructors are invoked.
     /**
     * Default constructor for objects of class Ship
     */
    public Ship()
    {
        // initialise instance variables
        hits = 0;
        sunk = false;
    }

    
     /**
     * Constructor for objects of class Ship
     */
    public Ship(int row, int col, int dir)
    {
        // initialise instance variables
        hits = 0;
        sunk = false;
        start_row = row;
        start_col = col;
        direction = dir;
    }

    
    /**
     * Given a guess (row, col) determine if it is a hit for this ship
     * Update hits and sunk attributes of ship as appropriate
     * 
     * Parameters: int row -- row of the guess
     *             int col -- column of the guess
     *             
     * Return: true: if the guess hits this ship
     *         false: otherwise
     *         
     * Note: you do not have to determine if this position has been guessed
     *       previously -- that has already been done in the Board class.
     *       Also - in this method, you are evaluating one guess for one ship.
     *       That is very important -- the guess you are provided as a parameter
     *       is being evaluated by this method with respect to one ship, the
     *       ship to which this method is being applied.  In the Board class,
     *       this method is called for each ship -- in that way we check all of
     *       the ships.
     */
    public boolean isAHit(int row, int col)
    {
    
    	//Check whether the guess is matched with the ship coordinates
    	//If the coordinates matches then its a hit
    	//Checking horizontally 
    	if ( direction == horizontal)
    	{
    		if (row == start_row)
    		{
    			if ( col>= start_col && col < start_col + size)
    			{
    				hits++;
    				hit = true;
    			}
    			
    			else 
    			{
    				hit = false;
    			}
    		}
    		
    		else 
    		{
    			hit = false;
    		}
    	}
    	
    	//Checking vertically
    	else if ( direction == vertical)
    	{
    		if ( (col == start_col) )
    		{
    			if ( row >= start_row && row < start_row + size)
    			{
    				hits++;
    				hit = true;
    			}
    			
    			else 
    			{
    				hit = false;
    			}
    		}
    		
    		else {
    			hit = false;
    		}
    	}
    	
    	return hit;
    	
    }
    
    
    // getters and setters
    /**
     * Indicate if the ship has been sunk
     */
    public boolean isSunk()
    {
    	
    	if ( hits == size )
    	{
    		sunk = true;
    	}
    	else 
    	{
    		sunk = false;
    	}
    	return sunk;
    }
    
    
    /**
     * Set value of start_row
     */
    public void setRow(int row)
    {
    	start_row = row;
    }
    
    
    /**
     * Set value of start_col
     */
    public void setCol(int col)
    {
    	start_col = col;
    }
    
    
    /**
     * Set value of size
     */
    public void setSize(int sizeVal)
    {
    	size = sizeVal;
    }
    
    
    /**
     * Set value of direction
     */
    public void setDir(int dir)
    {
    	direction = dir ;
    }
    
    
    /**
     * Return value of size
     */
    public int getSize()
    {
    	return size ;
    }
    
    
    /**
     * Return value of start_row
     */
    public int getStartRow()
    {
    	return start_row;
    }
    
    
    /**
     * Return value of start_col
     */
    public int getStartCol()
    {
    	return start_col; 
    }
    
    
    /**
     * Return value of direction
     */
    public int getDirection()
    {
    	return direction;
    }
    
    
    /**
     * This method exists solely so that it can be overriden in
     * the subclasses of Ship
     */
    public String getName()
    {
        return "";
    }
}
