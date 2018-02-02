package com.dianafisher.interviewbit.dynamic_programming.best_time_to_buy_and_sell_stocks_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dianafisher on 1/29/18.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

 Example :

 Input : [1 2]
 Return :  1

 */
public class Solution {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {

        if (A == null) return 0;
        if (A.size() == 0) return 0;

        int N = A.size();

        int[] costs = new int[N];
        int[] profits = new int[N];

        for (int i = 0; i < N; i++) {
            int price = A.get(i);
            if (i == 0) {
                profits[i] = 0;
                costs[i] = -price;
            } else {
                profits[i] = Math.max(profits[i-1], costs[i-1] + price);
                costs[i] = Math.max(costs[i-1], -price);
            }
        }

        return profits[N-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new ArrayList<>(Arrays.asList(1, 2))));  // 1
        System.out.println(s.maxProfit(new ArrayList<>(Arrays.asList(2, 1))));  // 0
    }

}
