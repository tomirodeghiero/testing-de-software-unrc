package assignment6_exercises.fuzzing;

/**
 * Base Class for fuzzers 
 * */

public interface Fuzzer {
	
	/**
	 * subclasses must implement this method
	 */
	public String fuzz();

}
