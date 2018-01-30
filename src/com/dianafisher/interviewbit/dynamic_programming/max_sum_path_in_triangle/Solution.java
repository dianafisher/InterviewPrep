package com.dianafisher.interviewbit.dynamic_programming.max_sum_path_in_triangle;

import java.util.*;

/**
 * Created by dianafisher on 1/29/18.
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 */
public class Solution {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        if (a == null) return 0;
        if (a.size() == 0) return 0;


        List<Integer> previousRow = new ArrayList<>(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            List<Integer> currentRow = a.get(i);
//            System.out.println("currentRow = " + currentRow);
            // first element..
            currentRow.set(0, currentRow.get(0) + previousRow.get(0));

            for (int j = 1; j < currentRow.size()-1; ++j) {
                int val = currentRow.get(j) + Math.min(previousRow.get(j-1), previousRow.get(j));
                currentRow.set(j, val);
            }
            // last element..
            int lastIndex = currentRow.size()-1;
            currentRow.set(lastIndex, currentRow.get(lastIndex) + previousRow.get(previousRow.size() - 1));
            previousRow = currentRow;
//            System.out.println("previousRow = " + previousRow);
        }

        return Collections.min(previousRow);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(2)));
        a.add(new ArrayList<>(Arrays.asList(3, 4)));
        a.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        a.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        System.out.println(s.minimumTotal(a));
    }
}
