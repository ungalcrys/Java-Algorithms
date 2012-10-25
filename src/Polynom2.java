import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polynom2 {
    private final List<Integer> coef;

    /**
     * Polynom implementation using ArrayList.
     * 
     * @param coefficients
     *            as: a + bx + cx^2 + dx^4<br/>
     *            <code>new List() with a,b,c,d as values.</code>
     */
    public Polynom2(List<Integer> coeficienti) {
        this.coef = coeficienti;
    }

    private Polynom2 operation1(Polynom2 p, boolean isPlus) {
        int max = Math.max(coef.size(), p.coef.size());
        Polynom2 result = new Polynom2(new ArrayList<Integer>(max));
        for (int i = 0; i < max; i++)
            if (isPlus)
                result.coef.add(i, getValue(coef, i) + getValue(p.coef, i));
            else
                result.coef.add(i, getValue(coef, i) - getValue(p.coef, i));
        return result;
    }

    private static Integer getValue(List<Integer> coef, int index) {
        int value = 0;
        if (index < coef.size())
            value = Integer.parseInt(coef.get(index).toString());
        return value;
    }

    /**
     * 
     * @param p
     *            the polynom to be added
     * @return a new polynom that represents the addition of the parameter
     */
    public Polynom2 plus(Polynom2 p) {
        return operation1(p, true);
    }

    /**
     * 
     * @param p
     *            the polynom to be substracted
     * @return a new polynom that represents the substraction of the parameter
     */
    public Polynom2 minus(Polynom2 p) {
        return operation1(p, false);
    }

    /**
     * 
     * @param p
     *            the polynom to be multiplied
     * @return a new polynom that represents the multiplication with the parameter
     */
    public Polynom2 multiplyBy(Polynom2 p) {
        Polynom2 result = new Polynom2(new ArrayList<Integer>(coef.size() + p.coef.size() - 1));
        for (int i = 0; i < coef.size(); i++)
            for (int j = 0; j < p.coef.size(); j++) {
                int ij = i + j;
                int newValue = coef.get(i) * p.coef.get(j);
                try {
                    Integer value = result.coef.get(ij);
                    result.coef.set(ij, value + newValue);
                } catch (IndexOutOfBoundsException e) {
                    result.coef.add(ij, getValue(result.coef, ij) + newValue);
                }
            }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (coef.size() > 0 && coef.get(0) != 0)
            builder.append(coef.get(0));
        for (int i = 1; i < coef.size(); i++) {
            int c = coef.get(i);
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
        Polynom2 p1 = new Polynom2(Arrays.asList(4, 2, 3));
        Polynom2 p2 = new Polynom2(Arrays.asList(7, 2, 0, -4, 5));
        Polynom2 p = p1.plus(p2);
        System.out.println(p);
        p = p1.minus(p2);
        System.out.println(p);
        p = p1.multiplyBy(p2);
        System.out.println(p);
    }
}
