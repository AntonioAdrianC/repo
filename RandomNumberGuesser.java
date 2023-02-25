/*
 * Class: CMSC203 
 * Instructor: Professor Gary Thai
 * Description: This code uses the class, "RNG.java", in order to generate a random number
 * between 0 and 100. The user must guess the generated number.
 * Due: 2/23/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

import java.util.Scanner;

public class RandomNumberGuesser {
	public static void main(String[] args) 
	{
		String userInput;
		
		// scanner object. kb = keyboard
		Scanner kb = new Scanner(System.in);
		
		System.out.println("This application generates a random integer between 0 and 100 "
				+ "\nand asks the user to guess repeatedly until they guess correctly.\n");
		
		// do-while loop to check if the user would like to continue game.
		do 
		{
			// This constant will be a new variable holding the number the user will have to guess.
			final int RANDOMNUM = RNG.rand();
			RNG.resetCount(); // reset for new game.
			
			// ask user for first guess.
			System.out.println("Please input your first guess: ");
			
			boolean foundNum = false;
			int extraGuesses = 0;
			// below are two variables will hold the new ranges when the user guesses.
			int higherRangeEnd = 100; // variable to hold the user's highest guess.
			int lowerRangeEnd = 0; // variable to hold user's lowest guess.
			
			// finally, we are checking if they guessed correct.
			while(!foundNum) // while correctNum is false.
			{
				int userNum = getInteger(kb);
				// continue to ask user for correct number within range.
				// (method already informs user)
				while (!RNG.inputValidation(userNum, lowerRangeEnd, higherRangeEnd))
				{
					userNum = getInteger(kb);
					extraGuesses++;
				}
				
				// check if the guess is correct.
				if (userNum == RANDOMNUM)
				{
					System.out.println("Congratulations, you guess correctly!");
					foundNum = true;
					break;
				} else if((RNG.getCount() - extraGuesses) == 7)
				{
					System.out.println("You have exceeded the maximum number of guesses, 7. Try again.");
					System.out.println("The actual number was: " + RANDOMNUM);
					break;
				}
				
				// change the ranges. (already checked if it's range)
				if((higherRangeEnd > userNum && userNum > RANDOMNUM) && !foundNum)
				{
					System.out.println("Your guess is too high.");
					System.out.println("Number of guesses is: " + (RNG.getCount() - extraGuesses));
					higherRangeEnd = userNum;
					System.out.println("Enter your next guess between " + lowerRangeEnd + " and " + higherRangeEnd);
				}
				else if(userNum < RANDOMNUM && userNum > lowerRangeEnd && !foundNum)
				{
					System.out.println("Your guess is too low.");
					System.out.println("Number of guesses is: " + (RNG.getCount() - extraGuesses));
					lowerRangeEnd = userNum;
					System.out.println("Enter your next guess between " + lowerRangeEnd + " and " + higherRangeEnd);
				}	
				
			}
			
			userInput = "";
		} while(checkConfirmation(userInput, kb));
		
		System.out.println("Thanks for playing!");
		System.out.println("Programmer name: Adrian Carrasco");
		kb.close();
	}
	
	/**
	 * this method will check if the user inputed yes or no. uses scanner from main code...
	 * @param response
	 * @param keyboard
	 * @return a boolean. By the end, the method has confirmed a valid input. 
	 * If the user will continue, return true. If they finished, return false.
	 */
	public static boolean checkConfirmation(String response, Scanner keyboard)
	{
		// ask user if they'd like to start a new game.
		System.out.println("Try again? (yes or no)");
		response = keyboard.nextLine(); // to eat the empty lines.
		response = keyboard.nextLine();
		// checks for valid String response.
		while(!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"))
		{
			System.out.println("You did not type in yes or no. Please try again.");
			response = keyboard.nextLine();
		}
		
		// check if response said yes or no. return true or false respectively.
		boolean output = switch(response)
		{
			case "yes"-> true;
			default -> false; 
			// return false. We already checked for valid input above.
		};
		
		return output;
	}
	
	/**
	 * this method checks if the user inputted an incorrect datatype. we want to ensure they
	 * typed in an integer.
	 * @param input
	 * @param keyboard
	 * @return the actual primitive integer, extracted from string.
	 */
	public static int getInteger(Scanner keyboard)
	{
		int output = -1;
		// while passed = false. continue asking the user for the correct datatype.
		boolean passed = false; 
		do
		{
			try
			{
				output = keyboard.nextInt();
				passed = true;
			} catch (Exception InputMismatchException) { // if we catch this exception. then ask the user to try again.
				System.out.println("What you have typed in is not an integer. Please try again");
				keyboard.next(); // eat the lines.
			}
		} while (!passed);
		return output;
	}
}
