package com.dianafisher.interviewbit.dynamic_programming.unique_binary_search_trees_II;

/**
 * Created by dianafisher on 2/4/18.
 *
 * Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

 Example :

 Given A = 3, there are a total of 5 unique BST’s.


 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 */
public class Solution {

    public int numTrees(int A) {

        int[] dp = new int[A+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            for (int root = 1; root <= i; root++) {
                dp[i] += dp[root-1] * dp[i-root];
                System.out.println("i = " + i + ", root = " + root);
                printdp(dp);
            }
        }

        return dp[A];
    }

    private void printdp(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(3)); // 5
    }
}
