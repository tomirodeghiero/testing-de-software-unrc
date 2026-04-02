package assignment9_exercises;
import java.util.Random;


/**
 * 
 * Partially implemented ThreesTile Class for Threes game
 * 
 * */

public class ThreesTile {

	private int value;
	
	public ThreesTile() {
		 // Tile should be unset
		value = 0;
	}
	
	public ThreesTile(int v) {
		if(isValidValue(v))
			value = v;
		else
			throw new IllegalArgumentException("The value should be value is either 1, 2 or 3 * 2^i.");
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int v) {
		if(isValidValue(v))
			value = v;
		else
			throw new IllegalArgumentException("The value should be value is either 1, 2 or 3 * 2^i.");
	}
	
	public void clear(){
		value = 0;
	}
	
	public void setRandomValue() {
		Random randomGenerator = new Random();
	    value = randomGenerator.nextInt(3) + 1;
	}

	
	/**
	 * 
	 * @param v
	 * @return Returns true iff value is either 1, 2 or 3 * 2^i
	 */
	public boolean isValidValue (int v){
		if (v == 0 || v == 1 || v == 2) {
			return true;
		}
		if (v < 3 || v % 3 != 0) {
			return false;
		}
		int quotient = v / 3;
		return isPowerOfTwo(quotient);
	}

	/**
	 * Returns true iff n is a power of two.
	 *
	 * @param n number to evaluate
	 * @return true when n is 1, 2, 4, ...; false otherwise
	 */
	private boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
	
	
	/**
	 * 
	 * @return true iff the tile is free, false otherwise
	 */
	public boolean isFree(){
		return (value == 0);
	}
	
	
	/**
	 * Provides a string representation of the tile (shows its value as a string)
	 */
	public String toString(){
		return Integer.toString(value);
	}
	
	
	public ThreesTile combineTile(ThreesTile t){
		int v2 = t.getValue();
		if(isValidValue(v2))
			return new ThreesTile(value + v2);
		else
			throw new IllegalArgumentException();
	}
}
