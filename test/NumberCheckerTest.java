import org.junit.Test;

import junit.framework.TestCase;

public class NumberCheckerTest extends TestCase {

    @Test
    public void testIsPrime() {
        assertTrue(NumberChecker.isPrime(5));
        assertFalse(NumberChecker.isPrime(4));
    }

    @Test
    public void testIsPalindromic() {
        assertTrue(NumberChecker.isPalindromic("12321"));
        assertFalse(NumberChecker.isPalindromic("1231"));
    }

    public void testGetGreatestCommonDivisor() {
        assertEquals(6, NumberChecker.getGreatestCommonDivisor(12, 18));
        assertEquals(1, NumberChecker.getGreatestCommonDivisor(5, 17));
    }

    public void testGetLowestCommonMultiple() {
        assertEquals(36, NumberChecker.getLowestCommonMultiple(12, 18));
        assertEquals(85, NumberChecker.getLowestCommonMultiple(5, 17));
    }

}
