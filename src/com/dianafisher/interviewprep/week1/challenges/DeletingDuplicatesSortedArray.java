package com.dianafisher.interviewprep.week1.challenges;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 11/29/17.
 *
 * Remove duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such
 * that each element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length,
 * make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Example:
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class DeletingDuplicatesSortedArray {

    /*
    * Solution Approach:
    *
    * Initialize index to 1.
    * Loop through array and keep track of current value vs. prev value.
    * If prev value is not equal to current value, move the current value to index and increment index.
    *
    * */

    public static int removeDuplicates(ArrayList<Integer> a) {

        if (a == null || a.size() == 0) return 0;

        int index = 1;
        int N = a.size();

        for (int i = 1; i < N; i++) {
            System.out.println(a);
            int current = a.get(i);
            int prev = a.get(i-1);
            if (current != prev) {
                a.set(index, current);
                index++;
            }
        }

        // resulting array..
        System.out.println(a);

        return index;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        System.out.println(removeDuplicates(A));

        System.out.println("----------");

        A = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 4, 5, 5));
        System.out.println(removeDuplicates(A));

        A = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5));
        System.out.println(removeDuplicates(A));

        A = new ArrayList<Integer>(Arrays.asList(2,3,5,5,7,11,11,11,11,13));
        System.out.println(removeDuplicates(A));
    }
}
