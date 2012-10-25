public class Polynom1 {
    private final int[] coef;

    /**
     * Polynom implementation using simple arrays.
     * 
     * @param coefficients
     *            as: a + bx + cx^2 + dx^4<br/>
     *            <code>new int[] {a,b,c,d}</code>
     */
    public Polynom1(int[] coefficients) {
        this.coef = coefficients;
    }

    private Polynom1 operation1(Polynom1 p, boolean isPlus) {
        int max = Math.max(coef.length, p.coef.length);
        Polynom1 result = new Polynom1(new int[max]);
        for (int i = 0; i < max; i++)
            if (isPlus)
                result.coef[i] = getValue(coef, i) + getValue(p.coef, i);
            else
                result.coef[i] = getValue(coef, i) - getValue(p.coef, i);
        return result;
    }

    private static int getValue(int[] coef, int index) {
        int value = 0;
        if (index < coef.length)
            value = coef[index];
        return value;
    }

    /**
     * 
     * @param p
     *            the polynom to be added
     * @return a new polynom that represents the addition of the parameter
     */
    public Polynom1 plus(Polynom1 p) {
        return operation1(p, true);
    }

    /**
     * 
     * @param p
     *            the polynom to be substracted
     * @return a new polynom that represents the substraction of the parameter
     */
    public Polynom1 minus(Polynom1 p) {
        return operation1(p, false);
    }

    /**
     * 
     * @param p
     *            the polynom to be multiplied
     * @return a new polynom that represents the multiplication with the parameter
     */
    public Polynom1 multiplyBy(Polynom1 p) {
        Polynom1 result = new Polynom1(new int[coef.length + p.coef.length - 1]);
        for (int i = 0; i < coef.length; i++)
            for (int j = 0; j < p.coef.length; j++)
                result.coef[i + j] += coef[i] * p.coef[j];
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (coef.length > 0 && coef[0] != 0)
            builder.append(coef[0]);
        for (int i = 1; i < coef.length; i++) {
            int c = coef[i];
            if (c != 0) {
                if (c > 1 || c < -1)
                    builder.append(c > 1 ? " + " : " - ").append(Math.abs(c));
                builder.append("x");
                if (i > 1)
                    builder.append("^").append(i);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Polynom1 p1 = new Polynom1(new int[] { 4, 2, 3 });
        Polynom1 p2 = new Polynom1(new int[] { 7, 2, 0, -4, 5 });
        Polynom1 p = p1.plus(p2);
        System.out.println(p);
        p = p1.minus(p2);
        System.out.println(p);
        p = p1.multiplyBy(p2);
        System.out.println(p);
    }

}
