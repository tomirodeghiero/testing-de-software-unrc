package assignment6_exercises.fuzzing;


import java.util.Random;


public class RandomFuzzer implements Fuzzer{

	private int maxLength;
	private int charStart;
	private int charRange;
	private final Random random = new Random();

	public RandomFuzzer(int maxLength, int charStart, int charRange) {
		this.maxLength = maxLength;
		this.charStart = charStart;
		this.charRange = charRange;
	}


	
	/**
	 * Generates a random string of random length, with characters from a specified range.
	 * 
	 * The length of the generated string is randomly determined between 0 and maxLength (inclusive).
	 * Each character in the string is selected randomly from the range starting at charStart
	 * and ending at charStart + charRange.
	 *
	 * @return a randomly generated string, with random length and random characters within the defined range
	 *
	 */
	public String fuzz() {
		int stringLength = random.nextInt(maxLength + 1);
		StringBuilder result = new StringBuilder(stringLength);
		for (int i = 0; i < stringLength; i++) {
			char randomChar = (char) (charStart + random.nextInt(charRange));
			result.append(randomChar);
		}
		return result.toString();

	}


	




}
