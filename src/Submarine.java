
/**
 * Class for the Submarine of the Battleship Game.
 * 
 * Superclass: Ship
 * Subclasses: none
 * 
 * Attributes: String name
 *             int torpedos
 * 
 * name = "Submarine"
 * size = 3
 * torpedos = number of torpedos on this Submarine
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

public class Submarine extends Ship
{
	//Initializing variables
    private String name;
    private int torpedos;


    /**
     * Constructors for objects of class Carrier
     */
    //Setting the attributes 
    public Submarine()
    {
    	name = "Submarine";
    	size = 3;
    	torpedos = 10;
    }
    
    //Invoking constructor to parent class
    public Submarine(int row, int col, int dir)
    {
    	super ( row , col , dir);
    }
    
    //Returning name 
    public String getName()
    {
        return name;
    }
    

}
