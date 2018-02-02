package com.dianafisher.interviewbit.dynamic_programming.max_rectangle_in_binary_matrix;

import java.util.ArrayList;

/**
 * Created by dianafisher on 2/2/18.
 */
public class EditorialSolution {

    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        if (a.size() == 0) return 0;
        int[][] dp = new int[a.size()][a.get(0).size()];
        int maxRec = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int num = a.get(i).get(j);
                if (j == 0) dp[i][j] = num == 1 ? 1 : 0;
                else dp[i][j] = num == 1 ? dp[i][j - 1] + 1 : 0;
                int row = i, width = dp[i][j];
                while (row >= 0 && dp[row][j] > 0) {
                    width = Math.min(width, dp[row][j]);
                    maxRec = Math.max(maxRec, width * (i - row + 1));
                    row--;
                }
            }
        }
        return maxRec;
    }
}
