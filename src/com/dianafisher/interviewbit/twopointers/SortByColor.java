package com.dianafisher.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 11/29/17.
 *
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: Using library sort function is not allowed.
 *
 * Example :
 *
 * Input : [0 1 2 0 1 2]
 *
 * Modify array so that it becomes : [0 0 1 1 2 2]
 */

public class SortByColor {

    public static void sortColors(ArrayList<Integer> a) {

        if (a == null || a.size() <= 1) return;

        // create two pointers, red and blue.
        // red points to the beginning of the array and blue points to the end.
        int red = 0;
        int blue = a.size() - 1;

        int i = 0;

        while(i <= blue) {
            if (a.get(i) == 0) {
                // swap with red and increment red pointer
                swap(a, i, red);
                red++;
                i++;
            } else if (a.get(i) == 2) {
                // swap with blue and decrement blue pointer
                swap(a, i, blue);
                blue--;
            } else {
                // just increment i
                i++;
            }
        }
        System.out.println(a);
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 0, 1, 2));
        sortColors(A);


        A = new ArrayList<Integer>(Arrays.asList(2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2));
        sortColors(A);

    }
}
