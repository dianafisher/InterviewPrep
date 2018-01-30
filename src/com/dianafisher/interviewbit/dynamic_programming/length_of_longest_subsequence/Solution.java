package com.dianafisher.interviewbit.dynamic_programming.length_of_longest_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dianafisher on 1/29/18.
 *
 * Given an array of integers, find the length of longest
 * subsequence which is first increasing then decreasing.

 **Example: **

 For the given array [1 11 2 10 4 5 2 1]

 increasing subsequences:
 1, 11
 1, 2
 1, 2, 10
 1, 2, 4, 5

 decreasing subsequences:

 11, 10, 5, 2, 1
 11, 2
 10, 4, 2, 1

 combined..

 1, 2, 10, 4, 2, 1

 Longest subsequence is [1 2 10 4 2 1]

 Return value 6

 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        int N = A.size();
        int[] dp = new int[N];
        // initialize dp array
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // increasing..
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {

                if (A.get(j) > A.get(i)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(dp[i]+ ", ");
        }
        System.out.println();

        // decreasing
        int[] dec = new int[N];
        // initialize dp array
        for (int i = 0; i < N; i++) {
            dec[i] = 1;
        }
        for (int i = N-1; i > -1; i--) {
            for (int j = i-1; j > -1; j--) {
                if (A.get(j) > A.get(i)) {
                    dec[j] = Math.max(dec[j], dec[i] + 1);
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = i+1; j < N; j++) {
//                if (A.get(j) < A.get(i)) {
//                    dec[j] = Math.max(dec[j], dec[j] + 1);
//                }
//            }
//        }

        for (int i = 0; i < N; i++) {
            System.out.print(dec[i] + ", ");
        }
        System.out.println();

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, dp[i] + dec[i] - 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int len = s.longestSubsequenceLength(new ArrayList<>(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1)));
        System.out.println(len);
    }
}
