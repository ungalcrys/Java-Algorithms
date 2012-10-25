public class NumberChecker {

    /**
     * Checks if a number is prime.
     * 
     * @param n
     *            number to be checked.
     * @return <code>true</code> if the number is prime otherwise returns <code>false</code>.
     */
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                isPrime = false;
        return isPrime;
    }

    /**
     * 
     * @param n
     *            number to be checked.
     * @return <code>true</code> if the number is palindromic otherwise returns <code>false</code>.
     */
    public static boolean isPalindromic(String n) {
        boolean isPalindromic = true;
        for (int i = 0; i <= n.length() / 2; i++) {
            if (n.charAt(i) != n.charAt(n.length() - (i + 1)))
                isPalindromic = false;
        }
        return isPalindromic;
    }

    public static boolean isPalindromic(int n) {
        return isPalindromic(String.valueOf(n));
    }

    /**
     * Computes the greatest common divisor using Euclid's algorithm.
     * 
     * @param a
     *            first number
     * @param b
     *            second number
     * @return greatest common divisor
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        while (a != b)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    /**
     * Computes the lowest common multiple.
     * 
     * @param a
     *            first number
     * @param b
     *            second number
     * @return lowest common multiple
     */
    public static int getLowestCommonMultiple(int a, int b) {
        return a * b / getGreatestCommonDivisor(a, b);
    }
}
