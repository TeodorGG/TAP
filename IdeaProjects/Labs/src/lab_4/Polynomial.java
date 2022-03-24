package lab_4;

public class Polynomial {
    private int[] coef;   // coefficients p(x) = sum { coef[i] * x^i }
    private int degree;

    public Polynomial(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("exponent cannot be negative: " + b);
        }
        coef = new int[b+1];
        coef[b] = a;
        reduce();
    }
    private void reduce() {
        degree = -1;
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                degree = i;
                return;
            }
        }
    }

    public int degree() {
        return degree;
    }

    public int min_coef(){
        int b = 999;
//        for(int a : coef){
//            b = Math.min(a, b);
//        }

        for (int i = degree - 1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            if (i >=  1)  b = Math.min(b,i);
        }
        return b;
    }

    public void reduce_degree(int a){
        for (int i = 0; i <= this.degree; i++) {
            if(coef[i] == 0) {

                continue;
            }
            if(i>=1){
                this.coef[i-a] = this.coef[i];
                this.coef[i] = 0;
            }
        }
    }

    public Polynomial plus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] += that.coef[i];
        poly.reduce();
        return poly;
    }

    public Polynomial minus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] -= that.coef[i];
        poly.reduce();
        return poly;
    }

    public double getValue(int base){
        double value = 0;
        for (int i = 0; i <= this.degree; i++) {
            if(coef[i] == 0) {
                continue;
            }
            value += Math.pow(base,i) * this.coef[i];

        }
        return value;
    }
    @Override
    public String toString() {
        if      (degree == -1) return "0";
        else if (degree ==  0) return "" + coef[0];
        else if (degree ==  1) return coef[1] + "x + " + coef[0];
        String s = "";
        for (int i = degree ; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + (coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i == 0) s = s + "";
            else s = s + "x^" + i;
        }
        return s.substring(3);
    }

}
