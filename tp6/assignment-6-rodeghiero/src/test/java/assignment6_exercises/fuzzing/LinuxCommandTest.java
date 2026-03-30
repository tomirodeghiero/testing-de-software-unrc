package assignment6_exercises.fuzzing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class LinuxCommandTest {

	static int trials = 100;

	
	static BufferedWriter writer;
	static String program; // External program to run
	static String FILE; // Input file to use for the program
	static Fuzzer  mutationFuzzer  ;
	
	@BeforeAll
	public static  void setUpClass() throws Exception {
		program = "bc"; 
		FILE = "bc.txt"; 
		ArrayList<String> seeds = new ArrayList<String>();
		seeds.add("2 + 2");
		mutationFuzzer  = new MutationFuzzer(seeds, 1, 1);
		
	}
	
	
	@BeforeEach
	public  void setUp() throws Exception {
		try {
			writer = new BufferedWriter(new FileWriter(FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	@AfterEach
	public   void tearDown() throws Exception {
		writer.close();
	}
	
	
	
	/**
	 * 
	 * Generation methods
	 */
	
	private static String generateString() {
		return mutationFuzzer.fuzz();
	}
	
	
	
	private static Stream<Arguments> stringProvider() {
		Stream<Arguments> stream = Stream.generate(() -> Arguments.of(generateString())).limit(trials);
	    return stream;
	}
	
	
	/*
	 * Tests
	 */
	
	
	@ParameterizedTest
	@MethodSource("stringProvider")
	public void bcCommandTest(String data) throws IOException, InterruptedException{

		String interactiveData = data + "\nquit"; // Ensure bc terminates
		writer.write(interactiveData);
		writer.close();
		
		

		// Run the external program using ProcessBuilder
		ProcessBuilder pb = new ProcessBuilder(program, FILE);
		Process process = pb.start();
		
		BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		
		StringBuilder stdout = new StringBuilder();
		StringBuilder stderr = new StringBuilder();
		String line;
		while ((line = stdoutReader.readLine()) != null) {
			stdout.append(line).append('\n');
		}
		while ((line = stderrReader.readLine()) != null) {
			stderr.append(line).append('\n');
		}
		
		int exitCode = process.waitFor();
		
		//Assertion
		assertNotEquals(134, exitCode); // abort signal
		assertNotEquals(139, exitCode); // segfault signal
		String stderrLower = stderr.toString().toLowerCase();
		assertFalse(stderrLower.contains("segmentation fault"));
		assertFalse(stderrLower.contains("core dumped"));
		assertFalse(stderrLower.contains("illegal instruction"));
		
	}
	
	

}
