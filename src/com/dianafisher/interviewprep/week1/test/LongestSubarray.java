package com.dianafisher.interviewprep.week1.test;

/**
 * Created by dianafisher on 12/2/17.
 *
 * Return the length of the longest subarray having elements that sum to a number less than or equal to k.
 *
 * You cannot reorder the array's elements.
 *
 * 1 <= n <= 100000
 * 1 <= a[i] <= 1000
 * 1 <= k <= 1000000000
 */
public class LongestSubarray {

    static int maxLength(int[] a, int k) {
        System.out.println("k = " + k);
        int N = a.length;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <= N; j++) {
                int len = j-i;
                int sum = subarraySum(a, i, j);
//                System.out.println("i: " + i + ", j:" + j + ", len = " + len + " sum = " + sum);

                if (sum <= k) {
                    maxLength = Math.max(maxLength, len);
                }
            }
        }
        return maxLength;
    }

    static int subarraySum(int[]a, int start, int end) {
//        System.out.println("start: " + start + ", end:" + end);
        int sum = 0;
        int[] sub = new int[end-start];
        int idx = 0;
        for (int i = start; i < end; i++) {
//            System.out.println("a["+i+"] = " + a[i]);
            sub[idx] = a[i];
            sum += a[i];
            idx++;
        }

//        for(int i : sub) {
//            System.out.println(i);
//        }
//        System.out.println("----");

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 3, 4};
        int k = 4;
        System.out.println(maxLength(a, k));

        System.out.println("--------------------");
        int[] b = {4, 3, 1, 2, 1};
        System.out.println(maxLength(b, 4));
    }
}

/*
* 3
* 3 + 1
* 3 + 1 + 2
* 3 + 1 + 2 + 3 + 4
* 1
* 1 + 2
* 1 + 2 + 3
*
*
* **/
