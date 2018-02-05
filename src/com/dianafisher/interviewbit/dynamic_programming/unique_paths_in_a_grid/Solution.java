package com.dianafisher.interviewbit.dynamic_programming.unique_paths_in_a_grid;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 2/4/18.
 *
 * Given a grid of size m * n, lets assume you are starting at (1,1) and
 * your goal is to reach (m,n). At any instance, if you are on (x,y),
 * you can either go to (x, y + 1) or (x + 1, y).

 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Example :
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
    [0,0,0],
    [0,1,0],
    [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */
public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {

        if (A == null) return 0;

        int N = A.size();
        if (N == 0) return 0;

        int M = A.get(0).size();

        int[][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int cell = A.get(i-1).get(j-1);
//                System.out.println("cell = " + cell);
                if (cell == 1) {
                    // cannot move any further
                    dp[i][j] = 0;
                } else if (i == 1 && j == 1) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }


        }


//        printdp(dp);

        return dp[N][M];
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
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        grid.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
        grid.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        System.out.println(s.uniquePathsWithObstacles(grid));
    }
}
