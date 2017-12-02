package com.dianafisher.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dianafisher on 12/1/17.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example:

 Given the array [-2, 1, -3, 4, -1, 2, 1, -5, 4],

 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 For this problem, return the maximum sum.

 */

public class MaxSumContiguousSubarray {

    /*
    * a[0] = -2
    * a[0] + a[1] = -1
    * a[0] + a[1] + a[3] = -4
    *
    * a[1] = 1
    * a[1] + a[2] = 1 + -3
    * a[
    * */

    // DO NOT MODFIY THE LIST.
    public static int maxSubArray(final List<Integer> a) {
        int n = a.size();
        if (n == 1) return a.get(0);

        int max = Integer.MIN_VALUE;
        int previous = 0;

        for (int i : a) {
//            System.out.println("i = " + i + ", previous = " + previous);
            previous += i;
            max = Math.max(max, previous);
//            System.out.println("max = " + max);
            if (previous < 0) {
                previous = 0;
            }
//            System.out.println("----");
        }

        return max;

    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));  // expect 6
    }

}
