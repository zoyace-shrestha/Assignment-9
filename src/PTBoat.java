
/**
 * Class for the PT Boat of the Battleship Game.
 * 
 * Superclass: Ship
 * Subclasses: none
 * 
 * Attributes: String name
 *             int charges;
 * 
 * name = "PT Boat"
 * size = 2
 * charges - number of depth charges on this PT Boat
 * 
 * You must declare the attributes, complete the constructors and
 * write any necessary getters and setters
 * 
 * @author 
 * @version 
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

public class PTBoat extends Ship
{
    // instance variables
	private String name ;
	private int charges;

    /**
     * Constructors for objects of class Carrier
     */
	//Setting Attributes 
    public PTBoat()
    {
    	name = "PTBoat";
    	size = 2;
    	charges = 6;
    	
    }
    
    //Invoking constructor to parent class
    public PTBoat(int row, int col, int dir)
    {
    	super ( row , col , dir);
    }
    
    //Returning the name
    public String getName()
    {
        return name;
    }
    

}
