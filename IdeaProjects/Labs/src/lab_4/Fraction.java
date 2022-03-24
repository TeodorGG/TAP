package lab_4;

public class Fraction implements FractionInterface {

    private int numerator, denominator;

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public double getResult(){
        return numerator/denominator;
    }



    private int gcd() {
        int s = Math.min(this.numerator, this.denominator);
        for (int i = s; i > 0; i--) {
            if ((this.numerator % i == 0) && (this.denominator % i == 0))
                return i;
        }
        return -1;
    }

    @Override
    public String simplify() {

        int gcd = gcd();
        if (gcd > 1) {
            this.numerator = this.numerator / gcd;
            this.denominator = this.denominator / gcd;
        }

        return this.toString();
    }


    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }
}
