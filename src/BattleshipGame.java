
/**
 * A simple implementation of the game Battleship.  There are two players, each with 5 ships as in
 * the real game.  This version uses the extends relation to create 5 ship types: Carrier
 *                                                                                Battleship
 *                                                                                Destroyer
 *                                                                                Submarine
 *                                                                                PTBoat
 * 
 * 
 * The ships, one each of the above types, are placed on the board at random but do not overlap.  
 * Boards are displayed in ASCII characters.  One player wins win he/she sinks all of the other 
 * player's ships.
 * 
 *          
 * 
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

class BattleshipGame
{
    // This is the method that begins and controls game play.
    public static void main(String[] args)
    {
        // Scanner for getting player moves
        Scanner scan = new Scanner(System.in);
        
        // There are two players, each with their own board.
        // Player 0 plays first.
        Board player0 = new Board(scan);
        Board player1 = new Board(scan);
        int current_player = 0;

        // Play until someone wins
        while(!player0.allSunk() && !player1.allSunk())
        {
            if(current_player == 0)
            {
                System.out.printf("Player 0, it is your turn.  Here is the board:%n%n");
                player1.printBoard();
                player1.makeGuess();
                player1.printBoard();
                current_player = 1;
            }
            else if(current_player == 1)
            {
                System.out.printf("Player 1, it is your turn.  Here is the board:%n%n");
                player0.printBoard();
                player0.makeGuess();
                player0.printBoard();
                current_player = 0;
            }
            System.out.printf("%n%n");

        }

        if(player0.allSunk())
        {
            System.out.printf("Player 1, you win!%n%n");
        }
        else
        {
            System.out.printf("Player 0, you win!%n%n");
        }
        
        scan.close();
    }
}
