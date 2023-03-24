import java.util.*;
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */

/*
 * Class: CMSC203 
 * Instructor: Professor Gary Thai
 * Description: 
 * 
 * Due: 3/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco.
*/

public class CryptoManager 
{

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	public static final int RANGE = (int)UPPER_RANGE - LOWER_RANGE + 1;
	

	// the chars that are in range. :)
	private static ArrayList<String> CHARS = new ArrayList<>();
	static // adding the letters
	{
		for (int i = LOWER_RANGE; i <= UPPER_RANGE; i++)
			CHARS.add((char)i + ""); 
		// convert int -> char. convert char -> String, to be able to add it into the ArrayList
	}
	
	// declaring and initializing the arraylist that will hold ASCII codes.
	public static ArrayList<Integer> CODES4CHARS = new ArrayList<>();
	static // adding the codes
	{
		for (int i = LOWER_RANGE; i <= UPPER_RANGE; i++)
			CODES4CHARS.add(i); // an arraylist allows me not to worry about an array's index. yada yada.
	}
	
	// declaring and initializing the ACSII dictionary/hashmap.
	public static HashMap<Integer, String> ASCIIMAP = getASCIIMAP();

	
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) 
	{	
		for(int i = 0; i < plainText.length(); i++)
		{
			char currentLetter = plainText.charAt(i);
			if (currentLetter < LOWER_RANGE || currentLetter > UPPER_RANGE)
				return false;
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) 
	{
		if(!isStringInBounds(plainText)) 
			return "The selected string is not in bounds, Try again.";
		
		String encryptedOutput = "";
		String encryptedLetter = "";
		for(int i = 0; i < plainText.length(); i++)
		{
			Integer newASCII = (int)plainText.charAt(i) + key;
			// while key is higher, keep subtracting the RANGE value. "wrapping" around
			while(UPPER_RANGE < newASCII) newASCII -= RANGE;
			// using the hashmap to get our value. very sexy. <3
			encryptedLetter = ASCIIMAP.get(newASCII);
			encryptedOutput += encryptedLetter;
		}
		
		return encryptedOutput;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) 
	{
		if(!isStringInBounds(plainText)) 
			return "The selected string is not in bounds, Try again.";
		
		int index = 0;
		// make string long enough. using while loop to avoid dealing with longer bStr's
		while(plainText.length() >= bellasoStr.length())
		{
			bellasoStr += bellasoStr.charAt(index);
			index++;
		}
			
		
		String encryptedOutput = "";
		String encryptedLetter = "";
		for(int i = 0; i < plainText.length(); i++)
		{
			Integer newASCII = (int)plainText.charAt(i) + (int)bellasoStr.charAt(i);
			// while key is higher, keep subtracting the RANGE value. "wrapping" around
			while(UPPER_RANGE < newASCII) newASCII -= RANGE;
			// using the hashmap to get our value.
			encryptedLetter = ASCIIMAP.get(newASCII);
			encryptedOutput += encryptedLetter;
		}
		
		return encryptedOutput;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) 
	{
		if(!isStringInBounds(encryptedText)) 
			return "The selected string is not in bounds, Try again.";
		
		String decryptedOutput = "";
		String decryptedLetter = "";
		// while key is higher, keep subtracting the RANGE value. "wrapping" around
		while(UPPER_RANGE < key) key -= RANGE;
		for(int i = 0; i < encryptedText.length(); i++)
		{
			Integer newASCII = (int)encryptedText.charAt(i) - key;
			// since the key is able to subtract from the orginal ASCII code. 
			// Make sure to check if it's below the LOWER_RANGE, add RANGE until high enough.
			while(LOWER_RANGE > newASCII) newASCII += RANGE;
			// using the hashmap to get our value.
			decryptedLetter = ASCIIMAP.get(newASCII);
			decryptedOutput += decryptedLetter;
		}
		
		return decryptedOutput;	
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) 
	{
		if(!isStringInBounds(encryptedText)) 
			return "The selected string is not in bounds, Try again.";
		
		int index = 0;
		// make string long enough. using while loop to avoid dealing with longer bellasoStr's.
		while(encryptedText.length() >= bellasoStr.length())
		{
			bellasoStr += bellasoStr.charAt(index);
			index++;
		}
		
		String decryptedOutput = "";
		String decryptedLetter = "";
		// while key is higher, keep subtracting the RANGE value. "wrapping" around
		for(int i = 0; i < encryptedText.length(); i++)
		{
			Integer newASCII = (int)encryptedText.charAt(i) - (int)bellasoStr.charAt(i);
			// since the key is able to subtract from the original ASCII code. 
			// Make sure to check if it's below the LOWER_RANGE, add RANGE until high enough.
			while(LOWER_RANGE > newASCII) newASCII += RANGE;
			// using the hashmap to get our value.
			decryptedLetter = ASCIIMAP.get(newASCII);
			decryptedOutput += decryptedLetter;
		}
		
		return decryptedOutput;		
	}
	
	/**
	 * This method is to create the HashMap to hold the keys and ASCII codes. 
	 * Putting it in a method allows me to create an easily accessible "constant".
	 * Though, not completely immutable. 
	 * @return the created HashMap.
	 */
	public static HashMap<Integer, String> getASCIIMAP()
	{
		HashMap<Integer, String> outputHM = new HashMap<>();
		
		int i = 0; // hold the value of an index. will be used for the ALPHABET array.
		for (Integer num: CODES4CHARS)
		{
			String currentLetter = CHARS.get(i);
			// now we have a hashmap w/ key = valid letter (or char) and value = the corresponding ASCII code
			outputHM.put(num, currentLetter);
			i++;
		}
		
		return outputHM;
	}
	
}
