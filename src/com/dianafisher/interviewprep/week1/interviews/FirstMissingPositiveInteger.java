package com.dianafisher.interviewprep.week1.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by dianafisher on 11/30/17.
 *
 * Given an unsorted array, find the first missing positive integer.
 *
 * Example:
 * A = [1, 2, 0] should return 3
 * A = [-3, -2, -1] should return 0
 * C = [2, 3, 1, 0, 5] should return 4
 */

public class FirstMissingPositiveInteger {

    public static int firstMissingPositive(ArrayList<Integer> A) {
        HashSet<Integer> set = new HashSet<Integer>();
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            set.add(val);
            max = Math.max(max, val);
        }

        if (max < 0) return 0;

        for (int i = 0; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 0));   // 3
        System.out.println(firstMissingPositive(A));

        A = new ArrayList<Integer>(Arrays.asList(-3, -2, -1));      // 0
        System.out.println(firstMissingPositive(A));

        A = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 0, 5));     // 4
        System.out.println(firstMissingPositive(A));
    }
}
