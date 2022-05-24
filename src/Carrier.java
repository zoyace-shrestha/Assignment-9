
/**
 * Class for the Aircraft Carrier of the Battleship Game.
 * 
 * Superclass: Ship
 * Subclasses: none
 * 
 * Attributes: String name
 *             int aircraft
 * 
 * name = "Aircraft Carrier"
 * size = 5
 * aircraft = number of aircraft on this aircraft carrier
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

public class Carrier extends Ship
{
    // instance variables
	private String name;
	private Ship carrier;
	private int aircarft;

    /**
     * Constructors for objects of class Carrier
     */
    public Carrier()
    {
        // initialize name, size and aircraft and
        // invoke the Ship constructor
    	name = "Carrier";
    	carrier = new Ship();
    	size = 5;
    	aircarft = 50;
    }
    
    //Invoking to constructor the parent class
    public Carrier(int row, int col, int dir)
    {
    	super ( row , col , dir);
    }
    
    //Returning the name
    public String getName()
    {
        return name;
    }
    
}
