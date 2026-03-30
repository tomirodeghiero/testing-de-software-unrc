package assignment6_exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class PalindromeTests {

    @Test
	public void testCapicua() {
		char [] a ={'n', 'e','u','q','u','e','n'};
		boolean b  = Palindrome.capicua(a);
		assertTrue(b);
	}

    @Test
    public void testNoCapicuaPar() {
        char[] a = {'a', 'b'};
        boolean b = Palindrome.capicua(a);
        assertFalse(b);
    }

    @Test
    public void testNoCapicuaConExtremosIguales() {
        char[] a = {'a', 'b', 'c', 'a'};
        boolean b = Palindrome.capicua(a);
        assertFalse(b);
    }


    @Test
    public void testArregloVacioEsCapicua() {
        char[] a = {};
        boolean b = Palindrome.capicua(a);
        assertTrue(b);
    }

    @Test
    public void testUnElementoEsCapicua() {
        char[] a = {'x'};
        boolean b = Palindrome.capicua(a);
        assertTrue(b);
    }
}
