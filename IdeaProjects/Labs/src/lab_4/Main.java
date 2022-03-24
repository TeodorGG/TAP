package lab_4;

public class Main {
    public static void main(String[] args) {

        Fraction f1 = new Fraction(9,3);
        System.out.println("Base : " + f1);
        System.out.println("Simplificat : " + f1.simplify());
        System.out.println("Result : " + f1.getResult());

        f1 = new FractionPolynom(
                new Polynomial(3,3).plus(new Polynomial(2,2).plus(new Polynomial(5,2))),
                new Polynomial(6,4).plus(new Polynomial(1,2).plus(new Polynomial(5,2)))
        );
        System.out.println("Base : " + f1);
        System.out.println("Simplificat : " + f1.simplify());
        System.out.println("Result : " + ((FractionPolynom)f1).getResult(1));

    }
}
