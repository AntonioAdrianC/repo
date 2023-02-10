import java.util.Scanner;

public class WifiDiagnosis {
	public static void main(String[] args)
	{
		/*
		 * Class: CMSC203 
		 * Instructor: Professor Thai
		 * Description: Troubleshooting Wifi.
		 * Due: 2/10/2023
		 * Platform/compiler: Eclipse.
		 * I pledge that I have completed the programming 
		 * assignment independently. I have not copied the code 
		 * from a student or any source. I have not given my code 
		 * to any student.
		   Print your Name here: Adrian Carrasco
		*/
		
		// print project header.
		System.out.println("If you have a problem with internet connectivity this WiFi Diagnosis might work.\n");
		//create Scanner object.
		Scanner stdin = new Scanner(System.in);
		
		String userInput = ""; // variable for user input.
		boolean completeDiagnosis = false; // flag in order to check if we have to continue.
		boolean repeatDiagnosis = false; // flag in order to check if they want to try the program again.
		
		do
		{
			// first step: reboot your computer
			System.out.println("First step: reboot your computer.");
			System.out.println("Are you able to connect with the internet? (yes or no)");
			userInput = stdin.nextLine();
			
			// check if the input was an viable answer.
			while(!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no"))
			{
				// if input isn't "yes" or "no" (ignore case), then tell user to try again.
				System.out.println("Invalid answer; try again");
				
				userInput = stdin.nextLine();
			}
			
			completeDiagnosis = userInput.equalsIgnoreCase("yes") ? true : false;
			// second step: reboot your router
			if(!completeDiagnosis)
			{
				System.out.println("Second step: reboot your router.");
				System.out.println("Now are you able to connect with the internet? (yes or no)");
				userInput = stdin.nextLine();
				// check if the input was an viable answer.
				while(!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no"))
				{
					// if input isn't "yes" or "no" (ignore case), then tell user to try again.
					System.out.println("Invalid answer; try again");
					userInput = stdin.nextLine();
				}
				
				completeDiagnosis = userInput.equalsIgnoreCase("yes") ? true : false;
				// third step: make sure the cables to your router are plugged in firmly and your router is getter power.
				if(!completeDiagnosis)
				{
					System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getter power.");
					System.out.println("Now are you able to connect with the internet? (yes or no)");
					userInput = stdin.nextLine(); // get user input.
					// check if the input was an viable answer.
					while(!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no"))
					{
						// if input isn't "yes" or "no" (ignore case), then tell user to try again.
						System.out.println("Invalid answer; try again");
						userInput = stdin.nextLine();
					}
					
					completeDiagnosis = userInput.equalsIgnoreCase("yes") ? true : false;
				}
					//fourth step: move your computer closer to your router
					if(!completeDiagnosis)
					{
						System.out.println("Fourth step: move your computer closer to your router.");
						System.out.println("Now are you able to connect with the internet? (yes or no)");
						userInput = stdin.nextLine();
						// check if the input was an viable answer.
						while(!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no"))
						{
							// if input isn't "yes" or "no" (ignore case), then tell user to try again.
							System.out.println("Invalid answer; try again");
							userInput = stdin.nextLine();
						}
						
						completeDiagnosis = userInput.equalsIgnoreCase("yes") ? true : false;
					}
						// fifth step: contact your ISP
						if(!completeDiagnosis)
						{
							System.out.println("Fifth step: contact your ISP.");
							System.out.println("Make sure your ISP is hooked up to your router.");
						}
			}
			
			System.out.println("\nWould you like to run this Diagnosis again? (yes or no)");
			userInput = stdin.nextLine();
			repeatDiagnosis = userInput.equalsIgnoreCase("yes") ? true : false;
		} while (repeatDiagnosis);
		
		System.out.println("\nWi-fi Diagnosis Complete");
		System.out.println("Programmer: Adrian Carrasco");
		
		
	}
}
