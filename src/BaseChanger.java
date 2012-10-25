public class BaseChanger {
    /**
     * Converts numbers from base 10 to specified bases.
     * 
     * @param n
     *            number in base 10 to work with
     * @param newBase
     *            to be changed
     * @return a string that represents the number converted in new base.
     */
    public static String from10ToX(int n, int newBase) {
        StringBuilder builder = new StringBuilder();
        do {
            int cifra = n % newBase;
            char cifraChar = '0';
            if (cifra > 9)
                cifraChar = (char) ('A' + cifra - 10);
            else if (cifra > 0)
                cifraChar = (char) ('1' + cifra - 1);
            builder.append(cifraChar);
            n = n / newBase;
        } while (n > 0);
        StringBuilder result = new StringBuilder(builder.length());
        for (int i = builder.length() - 1; i >= 0; i--)
            result.append(builder.charAt(i));
        return result.toString();
    }

    /**
     * Converts numbers from a specific base to bases 10.
     * 
     * @param n
     *            number in to work with
     * @param oldBase
     *            from to convert
     * @return number in base 10
     */
    public static int fromXTo10(String n, int oldBase) {
        int start = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        int result = 0;
        for (int i = start; i < n.length(); i++) {
            char charStr = n.charAt(i);
            int digit = 0;
            if (charStr >= 'A')
                digit = 10 + charStr - 'A';
            else if (charStr >= '1')
                digit = charStr - '0';
            if (i == 0)
                result += digit;
            else
                result = result * oldBase + digit;
        }
        return result;
    }

}
