package assignment6_exercises.fuzzing;

import java.util.ArrayList;



/**
 * The purpose of this class is to compare two simple ways of generating random strings:
 * completely random or through mutations of a valid string (which complies with the syntactic description of valid inputs).
 */
public class HttpProgramRunner {
	
	
	/**
	 * Generates random URLs by mutating a list of seed strings.
	 * This method utilizes a mutation fuzzer to create new strings based on the provided seeds.
	 * For each generated string, it checks if it is a valid URL. Valid URLs are collected 
	 * and returned as a list after the specified number of trials.
	 *
	 * @param seeds  an ArrayList of seed strings to be used for URL generation
	 * @param trials the number of random mutations to perform on the seed strings
	 * @return an ArrayList of strings that are valid URLs generated from the seed strings
	 */
	public static  ArrayList<String> urlGenerationFromSeeds(ArrayList<String> seeds, int trials) {
		
		Fuzzer mutationFuzzer = new MutationFuzzer(seeds, 1, 1);
		
		ArrayList<String> validInputs = new ArrayList<String>();

		for (int i = 0; i < trials; i++ ) { 
			String data = mutationFuzzer.fuzz();
			System.out.println(data);
		    if (HttpUtils.isValidUrl(data)) {
		    	validInputs.add(data);
		    }
		        
		}
		return validInputs;
	}

	
	
	
	
	/**
	 * This method generates random strings and checks if they are valid URLs.
	 * It uses a random fuzzer to create random inputs, and for each generated string,
	 * it verifies whether the string is a valid URL. If the string is valid, it is added
	 * to the list of valid inputs. The method returns a list of valid URLs after all trials.
	 *
	 * @param trials the number of random strings to generate and validate
	 * @return an ArrayList of strings that are valid URLs
	 */
	public static  ArrayList<String> StringRandomGeneration(int trials) {
		
		Fuzzer fuzzer = new RandomFuzzer(100,32, 32);
		
		ArrayList<String> validInputs = new ArrayList<String>();

		for (int i = 0; i < trials; i++ ) { 
			String data = fuzzer.fuzz();
			System.out.println(data);

			if (HttpUtils.isValidUrl(data)) {

		    	validInputs.add(data);
		    }
		        
		}
		return validInputs;
	}
	

	/**
	 * Initializes a list of seed URLs and adds a sample Google search URL.
	 * Generates random URLs based on the seed using the `urlGenerationFromSeeds` method,
	 * running 20 trials, and prints the ratio of valid URLs generated.
	 * Generates random URLs using the `StringRandomGeneration` method, also running 20 trials,
	 * and prints the ratio of valid URLs generated.
	 */
	public static void main(String[] args) {
		
		ArrayList<String> seeds = new ArrayList<String>();
		seeds.add("http://www.google.com/search?q=fuzzing");
		
		ArrayList<String> valid = HttpProgramRunner.urlGenerationFromSeeds(seeds, 20);
		
		System.out.println((double)valid.size()/20);
		
		
		valid = HttpProgramRunner.StringRandomGeneration(20);
		
		System.out.println((double)valid.size()/20);
					
	}

}
