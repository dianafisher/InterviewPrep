package com.dianafisher.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dianafisher on 11/26/17.
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 *
 * Assume that there will only be one solution
 *
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSum {

    public static int threeSumClosest(ArrayList<Integer> a, int b) {

        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        int n = a.size();
        // sort the array first..
        Collections.sort(a);

        // divide the list in half
        int left = 0;
        int right = n-1;

        for (int i = 0; i < n - 2; i++) {
            left = i + 1;
            right = n - 1;

            while (left < right) {
                int sum = a.get(i) + a.get(left) + a.get(right);
                int diff = Math.abs(sum - b);
                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }
                if (sum < b) {
                    left++;
                } else {
                    right--;
                }
            }
        }


        return result;
    }

    private static int threeSumBruteForce(ArrayList<Integer> a, int b) {

        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                for (int k = j+1; k < a.size(); k++) {
//                    System.out.println(a.get(i) + " + " + a.get(j) + " + " + a.get(k));
                    int sum = a.get(i) + a.get(j) + a.get(k);
                    int diff = Math.abs(sum - b);
                    if (diff < minDiff) {
                        minDiff = diff;
                        result = sum;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-1);
        a.add(2);
        a.add(1);
        a.add(-4);

        System.out.println(threeSumClosest(a, 1)); // expect 2

        a = new ArrayList<Integer>();
        a.add(12);
        a.add(3);
        a.add(4);
        a.add(1);
        a.add(6);
        a.add(9);

        System.out.println(threeSumClosest(a, 24)); // expect
    }
}
