package assignment9_exercises;

import java.util.Random;

public class RandomValueGenerator implements RandomGenerator{
	
	
	
	public int getRandom(int bound){
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt() % bound;
	    while(randomInt < 0)
	    	randomInt = randomGenerator.nextInt() % bound;
	    return randomInt;
	}

}
