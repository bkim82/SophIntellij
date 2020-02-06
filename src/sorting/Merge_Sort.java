package sorting;

import java.util.*;

public class Merge_Sort {


    public static int[] mergeLists(int[] listA, int[] listB) {
        int[] merged = new int[listA.length + listB.length];
        int i = 0;
        int a = 0;
        int b = 0;

        while (a < listA.length && b < listB.length) {
            if ( listA[a] < listB[b]) {
                merged[i++] = listA[a++];
            }
            else {
                merged[i++] = listB[b++];
            }
        }
        while (a < listA.length) {
            merged[i++] = listA[a++];
        }
        while (b < listB.length) {
            merged[i++] = listB[b++];
        }
        return merged;
    }

    public static int[] mergeSort(String indent, int[] list) {
        System.out.println(indent + "IND: " + Arrays.toString(list));
        int n = list.length;

        if (n <= 1) {
            return list;
        }

        int[] halfA = Arrays.copyOfRange(list, 0, n/2);
        int[] halfB = Arrays.copyOfRange(list, n/2, n);

        int[] sortedA = mergeSort(indent + "  ", halfA);
        int[] sortedB = mergeSort(indent + "  ", halfB);

        int[] sorted = mergeLists(sortedA, sortedB);
        System.out.println(indent + "Out: " + Arrays.toString(sorted));
        return sorted;
    }

    public static int binarySearch(int[] list, int val) {
        return binarySearch(0, list.length-1, list, val);

    }

    private static int binarySearch(int minPos, int maxPos, int[] list, int val) {
        if (maxPos < minPos) {
            return -1;
        }
        int pos = (maxPos+minPos) / 2;
        if (list[pos] == val) {
            return pos;
        }
        else if (list[pos] < val) {
            return binarySearch(pos+1, maxPos,list, val);
        }
        else {
            return binarySearch(minPos, pos -1, list, val);
        }
    }


    public static void main(String[] args) {
        int[] list1 = {14,4,2,7,12,17,0,-1,8,15};
        System.out.println(Arrays.toString(list1));
        int[]sorted = mergeSort("", list1);
        System.out.println(Arrays.toString(sorted));
        System.out.println(binarySearch(sorted,13));
        System.out.println(binarySearch(sorted, 14));
    }

}