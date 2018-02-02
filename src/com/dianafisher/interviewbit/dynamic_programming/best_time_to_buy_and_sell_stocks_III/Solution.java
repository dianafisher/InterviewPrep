package com.dianafisher.interviewbit.dynamic_programming.best_time_to_buy_and_sell_stocks_III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dianafisher on 1/31/18.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Example :

 Input : [1 2 1 2]
 Output : 2

 Explanation :

 Day 1 : Buy
 Day 2 : Sell
 Day 3 : Buy
 Day 4 : Sell


 */
public class Solution {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit_prev(final List<Integer> A) {
        if (A == null) return 0;

        int N = A.size();
        int[] dp = new int[N];

        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            int current = A.get(i);
            int prev = A.get(i-1);

            if (current > prev) {
                int profit = current - prev;
                System.out.println("selling " + current + ", profit = " + profit);
                dp[i] = dp[i-1] + profit;
            } else {
                dp[i] = dp[i-1];
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return dp[N-1];
    }

    public int maxProfit(final List<Integer> A) {
        if (A == null) return 0;

        int N = A.size();

        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int i = 0; i < N; i++) {
            int price = A.get(i);
            System.out.println("price = " + price);
            sell2 = Math.max(sell2, buy2 + price);

            buy2 = Math.max(buy2, sell1 - price);

            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
            System.out.println(" first buy = " + buy1 + " first sell = " + sell1 + " second buy = " + buy2 + " second sell = " + sell2);
        }
        return sell2;
    }

    public int maxProfit_editorial(final List<Integer> prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
        System.out.println(s.maxProfit(A));

        A = new ArrayList<>(Arrays.asList(5, 3, 7, 1, 9, 16, 20));
        System.out.println(s.maxProfit(A));

        /*
        BUY     SELL    PROFIT
        5       7       2
                9       4
                16      11
                20      15

        3       7       4
                9       6
                16      13
                20      17

        7       9       2
                16      9
                20      13

        1       9       8
                16      15
                20      19

        9       16      7
                20      11

        16      20      4


        (3 -> 7) then (1 -> 20) = 4 + 19 = 23

         */


        A = new ArrayList<>(Arrays.asList(3, 5, 7, 1, 9, 16, 20));
        System.out.println(s.maxProfit(A));
    }
}
