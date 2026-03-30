package assignment6_exercises;

public class Palindrome {

	/**
	 *  Return whether an array is palindromic
	 * @param An array if char
	 * @return return true if the given array is palindromic.
	 */
	public static boolean capicua(char[] list) {
		int index = 0;
		int l = list.length;
		boolean res = true;
		while(index<(l-1) && res){
			if(list[index] != list[(l-index)-1]){
				res= false;
			}
			index++;
		}
		return res;
	}
	
}

