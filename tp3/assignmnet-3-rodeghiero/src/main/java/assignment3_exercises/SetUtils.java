package assignment3_exercises;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetUtils{
	
	/**
	 * Computes the intersection of two sets of integers.
	 *
	 * <p>This method returns a new set containing only the elements that are present
	 * in both of the input sets. The input sets themselves are not modified.</p>
	 *
	 * @param set1 the first set of integers
	 * @param set2 the second set of integers
	 * @return a new set containing the intersection of {@code set1} and {@code set2}
	 *         (i.e., the elements that are common to both sets)
	 * @throws NullPointerException if either {@code set1} or {@code set2} is {@code null}
	 */
    public static  Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
		Objects.requireNonNull(set1, "set1 must be non-null");
		Objects.requireNonNull(set2, "set2 must be non-null");

		Set<Integer> result = new HashSet<>(set1);
		result.retainAll(set2);
		return result;
		
	}

   	
}
