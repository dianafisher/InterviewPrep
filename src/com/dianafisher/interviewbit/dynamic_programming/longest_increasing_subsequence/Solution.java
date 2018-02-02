package com.dianafisher.interviewbit.dynamic_programming.longest_increasing_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dianafisher on 2/1/18.
 *
 * Find the longest increasing subsequence of a given sequence / array.

 In other words, find a subsequence of array in which the subsequence’s elements
 are in strictly increasing order, and in which the subsequence is as long as possible.

 This subsequence is not necessarily contiguous, or unique.
 In this case, we only care about the length of the longest increasing subsequence.

 Example :

 Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 Output : 6
 The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */

public class Solution {

    public int lis_editorial(final List<Integer> a) {
        int res = 0;
        int[] lens = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (a.get(j) < a.get(i)) {
                    maxLen = Math.max(maxLen, lens[j]);
                }
            }
            lens[i] = maxLen + 1;
            res = Math.max(res, lens[i]);
        }
        return res;
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        if (A == null) return 0;

        int N = A.size();

        int[] dp = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int len = 0;
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    len = Math.max(len, dp[j]);
                }
            }
            dp[i] = len + 1;
            printdp(dp);
            max = Math.max(max, dp[i]);
        }


        return max;
    }

    private void printdp(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));
        System.out.println(s.lis(A));
    }
}
