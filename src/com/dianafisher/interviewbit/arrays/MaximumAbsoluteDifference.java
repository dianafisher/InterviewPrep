package com.dianafisher.interviewbit.arrays;

import java.util.*;

/**
 * Created by dianafisher on 11/27/17.
 *
 * You are given an array of N integers, A1, A2 ,…, AN.
 * Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 * For example,
 *
 * A=[1, 3, -1]
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.

 */
public class MaximumAbsoluteDifference {

    public static int maxArr(ArrayList<Integer> A) {
        int N = A.size();
        int maxDiff = 0;

        /*
        * |A[i] - A[j]| + |i - j| can be written as
        *
        *  (A[i] + i) - (A[j] + j)
        * -(A[i] + i) - (A[j] - j)
        *  (A[i] - i) - (A[j] - j) which equals -(A[i] + i) - A[j] - j)
        * -(A[i] - i) - (A[j] + j) which equals -(A[i] + i) - (A[j] + j)
        *
        * Construct two arrays:
        * One with values A[i] + i
        * and one with values A[i] - i
        *
        * Then find the maximum value possible by storing the minimum and maximum values of
        * A[i] + i and A[i] - i for all i.
        * */

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            max1 = Math.max(max1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) * -1 + i);
            max3 = Math.max(max3, A.get(i) - i);
            max4 = Math.max(max4, A.get(i) * -1 - i);
        }

        // find the overall maximum
        for (int i = 0; i < N; i++) {
            maxDiff = Math.max(maxDiff, max1 - A.get(i) - i);
            maxDiff = Math.max(maxDiff, max2 + A.get(i) - i);
            maxDiff = Math.max(maxDiff, max3 - A.get(i) + i);
            maxDiff = Math.max(maxDiff, max4 + A.get(i) + i);
        }
        return maxDiff;
    }

    public static int maxArr_nSquared(ArrayList<Integer> A) {
        int N = A.size();
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int f = Math.abs(A.get(i-1) - A.get(j-1)) + Math.abs(i-j);
//                System.out.println("f(" + i + ", " + j + ") = " + f);
                maxDiff = Math.max(maxDiff, f);
            }

        }

        return maxDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, -1));
        System.out.println(maxArr(A));  // expect 5

        A = new ArrayList<Integer>(Arrays.asList(-39, -24, 82, 95, 91, -65, 16, -76, -56, 70));
        System.out.println(maxArr(A));  // expect 175

        A = new ArrayList<Integer>(Arrays.asList(2, 2, 2));
        System.out.println(maxArr_nSquared(A));  // expect 2
        System.out.println(maxArr(A));  // expect 2

    }
}
