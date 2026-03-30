package assignment6_exercises.fuzzing;

import java.util.Random;

/**
 * 
 * Implements mutations operator on String
 *
 */
public class Mutator {
	
	private static final Random RANDOM = new Random();
	
	
	
	/**
	 * Deletes a random character from the given string.
	 * 
	 * This method randomly selects a character from the input string and removes it,
	 * returning a new string with the character deleted. If the input string is empty, 
	 * the method returns it unchanged.
	 *
	 * @param s the input string from which a random character will be deleted
	 * @return a new string with one random character removed
	 *
	 * @throws IllegalArgumentException if the input string is null
	 *
	 */
	private static String deleteRandomCharacter(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Input string cannot be null");
		}
		if (s.isEmpty()) {
			return s;
		}
		int pos = RANDOM.nextInt(s.length());
		return s.substring(0, pos) + s.substring(pos + 1);
    }
	
	
	
	
	/**
	 * Inserts a random ASCII character into a random position within the given string. 
	 * The random position could be at any index from 0 to the length of the string, allowing insertion at the end as well.
	 *
	 * @param s the input string into which a random character will be inserted
	 * @return a new string with the random character inserted at a random position in the input string
	 *
	 * @throws IllegalArgumentException if the input string is null
	 *
	 */
	private static String insertRandomCharacter(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Input string cannot be null");
		}
		int pos = RANDOM.nextInt(s.length() + 1);
		char randomChar = (char) (32 + RANDOM.nextInt(95)); // printable ASCII [32, 126]
		return s.substring(0, pos) + randomChar + s.substring(pos);  
    }
	
	
	/**
	 * Flips a random bit in a randomly selected character of the given string.
	 * 
	 * This method randomly selects a character in the input string, and then flips 
	 * a random bit 
	 *
	 * @param s the input string from which a character will be randomly selected and modified
	 * @return a new string where a single character has been modified by flipping a random bit;
	
	 * @throws IllegalArgumentException if the input string is null
	 *
	 */
	
	private static String flipRandomCharacter(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Input string cannot be null");
		}
		if (s.isEmpty()) {
			return s;
		}
		int pos = RANDOM.nextInt(s.length());
		int bit = 1 << RANDOM.nextInt(7); // flip one bit from low 7 bits
		char flipped = (char) (s.charAt(pos) ^ bit);
		return s.substring(0, pos) + flipped + s.substring(pos + 1);
    }
	
	
	/**
	 * Mutates the given string by randomly choosing one of three operations: 
	 * deleting a random character, inserting a random character, or flipping a random bit 
	 * in one of the string's characters. The operation is selected based on a random number.
	 
	 * @param s the input string to mutate
	 * @return a new string that has been mutated based on a random operation
	 * @throws IllegalArgumentException if the input string is null
	 *
	 */
	public static String mutate(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Input string cannot be null");
		}
		int choice = RANDOM.nextInt(3);
		switch (choice) {
		case 0:
			return deleteRandomCharacter(s);
		case 1:
			return insertRandomCharacter(s);
		default:
			return flipRandomCharacter(s);
		}
	
	}		 
		 
}
