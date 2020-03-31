package anagrams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LookupList {
    private ArrayList<String> wordlist;

    public LookupList() {
        wordlist = new ArrayList<String>();
    }

    public LookupList (String fileName) throws FileNotFoundException {
        wordlist = new ArrayList<String>();
        Scanner file = new Scanner(new FileReader(fileName));
        while(file.hasNextLine())
        {
            String word = file.nextLine();
            if(word.length() == 0 || word.charAt(0) == '#') //skip blank lines or starting with #, treating them as comments
                continue;
            insert(word);
      /*
      // Track how quickly the wordlist is forming...
      if (wordlist.size() % 5000 == 0)
        System.out.println("Added " + numWords + " words.");
      */
        }
        file.close();
        wordlist = mergeSort(wordlist);

        // TODO update to use merge sort!
    }

    public int size(){
        return wordlist.size();
    }

    private static ArrayList mergeSort(ArrayList<String> list) {
        int n = list.size();
        if (n <= 1) {
            return list;
        }
//        ArrayList<String> halfA = new ArrayList<String>(n/2);
//        for (int i = 0; i < (n/2)-1; i++) {
//            halfA.add(list.get(i));
//        }
//
//        ArrayList<String> halfB = new ArrayList<String>(n/2);
//
//        for (int j = n/2; j < n-1; j++) {
//            halfB.add(list.get(j));
//        }
        ArrayList<String> halfA = new ArrayList<String>(list.subList(0, n/2));
        ArrayList<String> halfB = new ArrayList<String>(list.subList(n/2, n));

        ArrayList<String> sortedA = mergeSort(halfA);
        ArrayList<String> sortedB = mergeSort(halfB);

        return mergeLists(sortedA, sortedB);
    }

    private static ArrayList<String> mergeLists(ArrayList<String> listA, ArrayList<String> listB) {
        ArrayList<String> merged = new ArrayList<String>(listA.size()+listB.size());
        int b = 0;
        int a = 0;

        while (a < listA.size() && b < listB.size()) {
            if (listA.get(a).compareTo(listB.get(b)) < 0) {
                merged.add(listA.get(a++));
            }
            else {
                merged.add(listB.get(b++));
            }
        }
        while (a < listA.size()) {
            merged.add(listA.get(a++));
        }
        while (b < listB.size()) {
            merged.add(listB.get(b++));
        }
        return merged;
    }

    public String get(int index){
        return wordlist.get(index);
    }

    public int indexOf(String word){
        return binarySearch(wordlist, word);
    }

    public boolean contains(String word){
        return binarySearch(wordlist, word) != -1;
    }

    public static int binarySearch(ArrayList<String> list, String val) {
        return binarySearch(0, list.size()-1, list, val);
    }

    private static int binarySearch(int minPos, int maxPos, ArrayList<String> list, String val) {
        if (maxPos < minPos) {
            return -1;
        }

        int pos = (minPos + maxPos) / 2;

        if (list.get(pos).compareTo(val) == 0 ) {
            return pos;
        }
        else if (list.get(pos).compareTo(val) < 0) {
            return binarySearch(pos+1, maxPos, list, val);
        } else {
            return binarySearch(minPos, pos-1, list, val);
        }

    }

    public List<String> toList(){
        return wordlist;
    }

    public void print() {
        int maxdigits = String.valueOf(wordlist.size()).length();;
        String format = "%" + maxdigits +"d: %s\n";

        System.out.printf("Wordlist (%d total):\n", wordlist.size());
        for (int i = 0; i < wordlist.size(); i++){
            System.out.printf(format,i,wordlist.get(i));
        }
    }


    public void insert(String word){
        //This inserts a word into the list in sorted position,
        //assuming that the list is already sorted.

//    for(int i = wordlist.size(); i > 0; i--){ //work backwards
//      String w = wordlist.get(i - 1);
//      if (word.compareTo(w) >= 0){ //if >= item in list (w),
//        wordlist.add(i, word); //insert at correct place, which is right after the item
//        return; //done!
//      }
//    }
        wordlist.add(0, word); //if < all items in list, add to front of list

        //TODO Optional?? Rewrite to work a little bit faster! Hint: Use binarySearch to know WHERE to insert...
    }

}
