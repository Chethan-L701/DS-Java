package learnds.DataStructs.Polynomial;

import java.util.Arrays;

public class Polynomial {
    public static PolyExp addPolynomial(PolyExp poly1, PolyExp poly2) {
        PolyExp poly = new PolyExp();
        poly.attach(poly1.getRaw());
        poly.attach(poly2.getRaw());
        return sort(poly);
    }

    public static PolyExp sort(PolyExp poly) {
        PolyExp p = new PolyExp();
        double[][] terms = poly.getRaw();
        Arrays.sort(terms, (a, b) -> Double.compare(b[1], a[1]));
        p.attach(terms);
        return p;
    }

    /**
     * <b>Multiplies the entire expression Polynomial <i>poly1</i> with term having
     * <i>exponent exp</i>
     * in Polynomial <i>poly2</i></b>
     * 
     * @param poly1 Polynomial poly1.
     * @param poly2 Polynomial whose term will be multiplied.
     * @param exp   Exponent of term in poly2 to be multiplied with poly1.
     */
    public static PolyExp singleMulti(PolyExp poly1, PolyExp poly2, int exp) {
        PolyExp poly = new PolyExp();
        double[][] terms1 = poly1.getRaw();
        double coefficient = poly2.isExponent(exp)[1];
        double[][] terms = new double[poly1.getSize()][2];
        for (int i = 0; i < poly1.getSize(); i++) {
            terms[i][0] = terms1[i][0] * coefficient;
            terms[i][1] = terms1[i][1] + exp;
        }
        poly.attach(terms);
        return poly;
    }

    public static PolyExp multiPoly(PolyExp poly1, PolyExp poly2) {
        PolyExp poly = new PolyExp();
        double[][] term1 = poly1.getRaw();
        double[][] terms2 = poly2.getRaw();
        for (double[] t2 : terms2) {
            poly.attach(singleMulti(poly1, poly2, (int) t2[1]).getRaw());
        }
        return poly;
    }

    public static PolyExp subPoly(PolyExp poly1, PolyExp poly2) {
        PolyExp poly = new PolyExp();
        poly.attach(poly1.getRaw());
        double[][] terms2 = poly2.getRaw();
        for (double[] term2 : terms2)
            poly.appendTerm(term2[0] * (-1), (int) term2[1]);
        return sort(poly);
    }
}
