package assignment3_exercises;

import java.util.List;

public class ListUtils {
	
	
	/**
	 * Counts the number of occurrences of a specified element in a given list.
	 *
	 * <p>This method iterates through the provided list to count how many times
	 * the specified element appears. If the list or the element is {@code null}, 
	 * an {@code IllegalArgumentException} is thrown.</p>
	 *
	 * @param l the list in which to count the occurrences of the specified element
	 * @param element the element whose occurrences need to be counted
	 * @return the number of times the specified element appears in the list
	 * @throws IllegalArgumentException if the list {@code l} or the element {@code element} is {@code null}
	 */
	public static int numberOfOcurrences(List<Integer> l, Integer element) {
		if (l == null || element == null) {
			throw new IllegalArgumentException("List and element must be non-null");
		}

		int count = 0;
		for (Integer current : l) {
			if (element.equals(current)) {
				count++;
			}
		}
		return count;
	}		

}
