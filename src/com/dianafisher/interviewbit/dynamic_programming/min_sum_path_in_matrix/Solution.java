package com.dianafisher.interviewbit.dynamic_programming.min_sum_path_in_matrix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 1/29/18.
 *
 * Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example :

 Input :

 [  1 3 2
    4 3 1
    5 6 1
 ]

 Output : 8

 1 -> 3 -> 2 -> 1 -> 1

 */
public class Solution {

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        if (A == null) return 0;

        int N = A.size();
        if (N == 0) return 0;

        int M = A.get(0).size();

        int[][] dp = new int[N][M];

        // right
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[i][0] = A.get(0).get(0);
            } else {
                dp[i][0] = dp[i-1][0] + A.get(i).get(0);
            }
        }

        // down
        for (int j = 0; j < M; j++) {
            if (j == 0) {
                dp[0][j] = A.get(0).get(0);
            } else {
                dp[0][j] = dp[0][j-1] + A.get(0).get(j);
            }
        }
        printMatrix(dp, N, M);

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int a = dp[i-1][j];
                int b = dp[i][j-1];
                dp[i][j] = A.get(i).get(j) + Math.min(a, b);
            }
        }
        System.out.println();
        printMatrix(dp, N, M);
        return dp[N-1][M-1];
    }

    private static void printMatrix(int[][] dp, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        A.add(new ArrayList<>(Arrays.asList(4, 3, 1)));
        A.add(new ArrayList<>(Arrays.asList(5, 6, 1)));

        System.out.println(s.minPathSum(A));
    }
}
