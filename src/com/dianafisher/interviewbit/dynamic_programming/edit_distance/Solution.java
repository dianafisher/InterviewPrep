package com.dianafisher.interviewbit.dynamic_programming.edit_distance;


/**
 * Created by dianafisher on 1/29/18.
 *
 * Given two words A and B, find the minimum number of steps required
 * to convert A to B. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character

 Example :
 edit distance between

 "Anshuman" and "Antihuman" is 2.

 Operation 1: Replace s with t.
 Operation 2: Insert i.

 A vs A -> do nothing
 n vs n -> do nothing
 s vs t -> replace (s becomes t)     Anthuman
        -> delete (remove s?)        Anhuman
        -> insert (add t)            Antshuman


 */
public class Solution {

    public int minDistance(String A, String B) {

        if (A.equals(B)) return 0;

        int N = A.length();
        int M = B.length();

        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                // insert all of B
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    // all of A
                    dp[i][j] = i;
                } else if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int replace = dp[i-1][j-1];
                    int remove = dp[i-1][j];
                    int insert = dp[i][j-1];

                    dp[i][j] = 1 + Math.min(replace, Math.min(remove, insert));

                }
            }
        }

        return dp[N][M];

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("Anshuman", "Antihuman"));  // 2
    }
}
