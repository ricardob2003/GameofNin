//Author @Ricardo Barahona 
//IT 2400 
//Professor Tabernik 

import java.util.Scanner;
import java.util.Random;
public class GameofNin {
	public static void main(String[] args) {

		// Define Instance Variables
		Scanner scan = new Scanner(System.in);
		final int MAX_MARBLES = 13;
		int limit = 3;
		boolean playAgain = true;
		String play;
		System.out.print("********* " + "Welcome to The Game of Nin" + " *********");
		System.out.print("\n The object of the game is to make your opponent take the last marble off the table."
				+ "\n You get to choose between 1 and 3 marbles when it is your turn ");
		// Do while loop to run program once
		do {
			int marbles = MAX_MARBLES;
			boolean userturn = true;

			// You need a nested loop to actually play the game through User Selection and
			// Computer Selection
			// For the program to work We need the parameter requirements to be fulfilled.
			while (marbles >= 0) {
				System.out.println("\nThere are " + marbles + " Marble(s)");
				if (userturn) {
					System.out.println("How many marble(s) would you like to take?");
					marbles = marbles - getUserSelection();
					// Use getter method defined outside the main method
					if (marbles <= 0) {
						System.out.println("\nUnlucky you loose");
					}
					userturn = false;
				} else {
					int compselec = getComputerSelection(limit);
					System.out.println("Computer removes " + compselec);
					marbles = marbles - compselec;
					if (marbles <= 0) {
						System.out.println("\n Congrats You Win");
					}
					userturn = true;
				}
				if (marbles == 0) {
					System.out.println("\nGame is over");
					break;
				}
			}
			// Final part of the Do while loop
			System.out.println("\nWould you like to play again? (y/n)");
			play = scan.nextLine();
		} while (play.charAt(0) == 'y');
	}
	// The code outside of the main method where the methods are defined, in order
	// to be used is called abstraction
	// Section of code that defines the Methods used in the Main Method
	private static boolean isValidMove(int scan) {
		if (scan > 0 && scan <= 3) {
			return true;
		} else {
			return false;
		}
	}
	// Method contains a loop, first define the userSelection and then run a do
	// while loop
	private static int getUserSelection() {
		Scanner scan = new Scanner(System.in);
		int userSelection = 0;

		do {
			System.out.println("Enter a number between 1 and 3: ");
			userSelection = scan.nextInt();
		} while (!isValidMove(userSelection));

		return userSelection;
	}
	private static int getComputerSelection(int limit) {
		return (int) (1.0 + Math.random() * limit);
	}
}
