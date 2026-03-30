package assignment6_exercises.fuzzing;

import java.util.ArrayList;
import java.util.Random;


public class MutationFuzzer implements Fuzzer{
	
	private ArrayList<String> population;
	private int  min_mutations; 
	private int max_mutations;
	private final Random random = new Random();
	
	

	/**
	 * 
	 * @param seeds is a list of (input) strings to mutate
	 * @param min_mutations  is the minimum number of mutations to apply
	 * @param max_mutations is the maximum number of mutations to apply
	 */
	public MutationFuzzer(ArrayList<String> seeds, int  min_mutations, int max_mutations ) {
		this.population = seeds;
		this.min_mutations = min_mutations; 
		this.max_mutations = max_mutations;
	
	}
	

	
	 public String fuzz() {
		 if (population == null || population.isEmpty()) {
			 throw new IllegalArgumentException("Population cannot be null or empty");
		 }
		 if (min_mutations < 0 || max_mutations < min_mutations) {
			 throw new IllegalArgumentException("Invalid mutation range");
		 }
		 String candidate = population.get(random.nextInt(population.size()));
		 int mutations = min_mutations;
		 if (max_mutations > min_mutations) {
			 mutations += random.nextInt((max_mutations - min_mutations) + 1);
		 }
		 for (int i = 0; i < mutations; i++) {
			 candidate = Mutator.mutate(candidate);
		 }
		 return candidate;
		 
	 }
	 
	   
	
	
	
	
			        

}
