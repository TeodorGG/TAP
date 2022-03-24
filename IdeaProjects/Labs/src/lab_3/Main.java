package lab_3;

public class Main {

    public static void main(String[] args) {


        Text t1 = new Pagina("Test 2 gse sdt asd gdf");
        Text t2 = new Text("Test 2 asd");

        System.out.println(t1);
        System.out.println(t2);

        System.out.println(t1.nr_de_cuvinte());
        System.out.println(t1.nr_de_cuvinte(1));

        System.out.println("t1 = t2 : " + t2.equals(t1));
        System.out.println(t1.getWord(0));
        System.out.println(t1.getWord(2,4));
    }
}
