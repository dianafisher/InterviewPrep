package com.dianafisher.interviewbit.dynamic_programming.coin_sum_infinite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by dianafisher on 1/31/18.
 *
 * You are given a set of coins S. In how many ways can you make sum N assuming
 * you have infinite amount of each coin in the set.

 Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

 Example :

 Input :
 S = [1, 2, 3]
 N = 4

 Return : 4

 Explanation : The 4 possible ways are
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}

 Note that the answer can overflow. So, give us the answer % 1000007

 */
public class Solution {
    public int coinchange2(ArrayList<Integer> A, int B) {
        if (A == null) return 0;

        int N = A.size();
        int[] dp = new int[B+1];

        // sort the coins array
        Collections.sort(A);

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            int coin = A.get(i);
//            System.out.println("coin = " + coin);
            for (int j = coin; j <= B; j++) {
                int idx = j-coin;
                dp[j] += dp[idx] % 1000007;
            }
            printDP(dp);
        }


        return dp[B] % 1000007;
    }

    private void printDP(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.coinchange2(new ArrayList<>(Arrays.asList(1, 2, 3)), 4));
        System.out.println(s.coinchange2(new ArrayList<>(Arrays.asList(1, 2, 6, 10)), 20));
        System.out.println(s.coinchange2(new ArrayList<>(Arrays.asList(2)), 412));
    }
}
