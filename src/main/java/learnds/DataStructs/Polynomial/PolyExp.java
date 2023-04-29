package learnds.DataStructs.Polynomial;

import java.util.ArrayList;

public class PolyExp {
    private ArrayList<PolyTerm> poly = new ArrayList<>();
    private char inTermsOf = 'x';

    public void setInTermsOf(char var) {
        this.inTermsOf = var;
    }

    public double[] isExponent(int exponent) {
        for (int i = 0; i < poly.size(); i++) {
            if (exponent == poly.get(i).getExponent())
                return new double[] { i, poly.get(i).getCoefficient() };
        }
        return new double[] { -1, 0.0 };
    }

    public double getCoefficientOf(int exponent) {
        return isExponent(exponent)[1];
    }

    public void appendTerm(double coefficient, int exponent) {
        if (exponent < 0)
            System.out.println("Exponent lesser than 0 : " + exponent + ",ignoring this term.");
        else {
            double[] exp = this.isExponent(exponent);
            if (exp[0] == -1) {
                poly.add(new PolyTerm(coefficient, exponent, inTermsOf));
            } else {
                coefficient = exp[1] + coefficient;
                if (coefficient == 0)
                    removeTerm(exponent);
                else
                    poly.get((int) exp[0]).setCoefficient(coefficient);
            }
        }
    }

    public int degree() {
        if (poly.size() < 0)
            return 0;
        int max = poly.get(0).getExponent();
        for (int i = 0; i < poly.size(); i++)
            if (max < poly.get(i).getExponent())
                max = poly.get(i).getExponent();
        return max;
    }

    public void attach(double[][] terms) {
        for (double[] term : terms)
            this.appendTerm(term[0], (int) term[1]);
    }

    public void removeTerm(int exponent) {
        int pos = (int) isExponent(exponent)[0];
        if (pos >= 0)
            poly.remove((pos));
    }

    public void displayPoly() {
        System.out.println();
        for (PolyTerm p : poly)
            if (p.getCoefficient() != 0)
                p.printTerm();
        System.out.println();
    }

    public double[][] getRaw() {
        int i = 0;
        double[][] terms = new double[poly.size()][2];
        for (PolyTerm p : poly) {
            terms[i][0] = p.getCoefficient();
            terms[i][1] = p.getExponent();
            i++;
        }
        return terms;
    }

    public int getSize() {
        return poly.size();
    }
}
