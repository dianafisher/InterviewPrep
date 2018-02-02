package com.dianafisher.interviewbit.dynamic_programming.stairs;

/**
 * Created by dianafisher on 1/31/18.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Example :

 Input : 3
 Return : 3

 Steps : [1 1 1], [1 2], [2 1]

 */
public class Solution {

    public int climbStairs(int A) {
        if (A == 1) return 1;

        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[A];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(5));
        System.out.println(s.climbStairs(13));
    }
}
