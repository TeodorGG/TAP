package lab_4;

public class FractionPolynom extends Fraction {

    public Polynomial numerator, denominator;

    public FractionPolynom(Polynomial numerator, Polynomial denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator.toString() + " / " + denominator.toString();
    }

    public String simplify(){
        int m1 = numerator.min_coef();
        int m2 = denominator.min_coef();
        int min = Math.min(m1,m2);
        if(m1 > 0){
            if(m2 > 0){
                numerator.reduce_degree(min);
                denominator.reduce_degree(min);
            }
        }
        return this.toString();
    }

    public double getResult(int x){
        return numerator.getValue(x) / denominator.getValue(x);
    }
}
