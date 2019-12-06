package day7;

import java.util.*;

public class VectorList {


    public static void main(String[] args) {
        Random r = new Random(25);
        ArrayList<Vector> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Vector v = new Vector(r.nextInt(360), r.nextInt(50));
            System.out.println(v);
            list.add(v);


        }

        System.out.println("Searching....");
        Vector v1 = new Vector(156, 4);
        System.out.println("Index: " + list.indexOf(v1));

        Collections.sort(list);

        for (Vector v:list) {
            System.out.println(v);
        }

    }
}
