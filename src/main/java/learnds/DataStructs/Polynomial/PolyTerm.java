package learnds.DataStructs.Polynomial;

public class PolyTerm {
    private double coefficient;
    private int exponent;
    private final char var;
    private String[] sup = { "\u2070", "\u00b9", "\u00b2", "\u00b3", "\u2074", "\u2075", "\u2076", "\u2077", "\u2078",
            "\u2079" };

    public PolyTerm(double coefficient, int exponent, char var) {
        this.var = var;
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public char getVar() {
        return var;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    private String supExponent() {
        String superscript = "", num = String.valueOf(Math.abs(this.exponent));
        int N, i = 0;
        do {
            N = Character.getNumericValue(num.charAt(i));
            superscript = superscript.concat(this.sup[N]);
            i++;
        } while (i < num.length());
        return superscript;
    }

    public void printTerm() {
        if (this.exponent == 0)
            System.out.format("%+.3f", this.coefficient);
        else
            System.out.format("%+.3f%c%s", this.coefficient, this.var, this.supExponent());
    }
}
