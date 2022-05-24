
/**
 * Class for the Battleship of the Battleship Game.
 * 
 * Superclass: Ship
 * Subclasses: none
 * 
 * Attributes: String name
 *             int guns
 * 
 * name = "Battleship"
 * size = 4
 * guns = number of guns on this Battleship
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
 * 
 */

public class Battleship extends Ship
{
    // instance variables
	private String name ;
	private int gun ;
	

    /**
     * Constructors for objects of class Carrier
     */
	
	//Setting Attributes 
    public Battleship()
    {
    	name = "Battleship";
    	size = 4;
    	gun = 6;
    	
    }
    
    //Invoking constructor to parent class
    public Battleship(int row, int col, int dir)
    {
    	super  ( row , col , dir);
    }
    
    //Returning value
    public String getName()
    {
        return name;
    }
    
}
