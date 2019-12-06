package day1;

import java.util.ArrayList;
import java.util.Arrays;

public class Day5_Warmup {

    public static void shortestToFront(ArrayList<String> strings) {
        int posOfShort = 0;
        for(int i=0; i<strings.size(); i++){
            if(strings.get(i).length() < strings.get(posOfShort).length()){
                posOfShort = i;
            }
        }
        String temp = strings.get(posOfShort);
        strings.remove(posOfShort);
        strings.add(0,temp);
    }


    public static void doubleList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i+=2) {
            list.add(i,list.get(i));
        }
    }


    public static void main(String[] args) {
        ArrayList<String> arg1 = new ArrayList<>();
        ArrayList<String> arg2 = new ArrayList<>();

        arg1.addAll(Arrays.asList("how", "are", "you?"));
        arg2.addAll(Arrays.asList("Frog", "Peach", "Elephant", "Ant", "Toad"));

        System.out.println("shortestToFront");
        shortestToFront(arg2);
        System.out.println(arg2);

        System.out.println("Doubled list");
        doubleList(arg1);
        System.out.println(arg1);
    }
}
