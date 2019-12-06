package day1.BCAList;

public class Day4_Demo {

    public static void main(String[] args) {
        BCArrayList<String> strs = new BCArrayList<>();

        strs.add("Sam");
        strs.add("Grace");
        strs.add(0,"Sara");

        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));

        }

        System.out.println("Removing Sam.");
        strs.remove("Sam");
        System.out.println(strs);


    }





}
