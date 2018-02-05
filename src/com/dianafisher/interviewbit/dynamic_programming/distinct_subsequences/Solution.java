package com.dianafisher.interviewbit.dynamic_programming.distinct_subsequences;

import java.util.Arrays;

/**
 * Created by dianafisher on 2/4/18.
 *
 * Given two sequences S, T, count number of unique ways in sequence S,
 * to form a subsequence that is identical to the sequence T.

 Subsequence : A subsequence of a string is a new string which is formed from
 the original string by deleting some (can be none ) of the characters without disturbing
 the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Example :

 S = "rabbbit"
 T = "rabbit"
 Return 3. And the formations as follows:

 S1= "ra_bbit"
 S2= "rab_bit"
 S3="rabb_it"

 "_" marks the removed character.

 */
public class Solution {

    public int numDistinct(String A, String B) {
        if (A.equals(B)) return 1;

        // if we made it here, we know A != B
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                int idxA = j-1;
                int idxB = i-1;
                if (A.charAt(idxA) == B.charAt(idxB)) {
                    dp[i][j] = dp[i][idxA] + dp[idxB][idxA];
                } else {
                    dp[i][j] = dp[i][idxA];
                }

//                printdp(dp);
            }
        }
        return dp[m][n];
    }

    private void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.numDistinct("rabbbit", "rabbit")); // 3
    }
}
