package lab_2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int y, m, d;

        Scanner scan = new Scanner(System.in);

        System.out.println("Introduceti date (anul, luna, ziua) :");

        y = scan.nextInt();
        m = scan.nextInt();
        d = scan.nextInt();

        CustomDate cDate = new CustomDate(y, m,d);


        System.out.println(cDate.getSeason());
    }
}
