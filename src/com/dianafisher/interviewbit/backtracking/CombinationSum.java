package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by dianafisher on 1/16/18.
 *
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.

 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

 The combinations themselves must be sorted in ascending order.

 CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2)
 OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)

 The solution set must not contain duplicate combinations.

 Example,
 Given candidate set 2,3,6,7 and target 7,
 A solution set is:

 [2, 2, 3]
 [7]
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        backtrack(result, new ArrayList(), A, B, 0);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combo, ArrayList<Integer> A, int target, int start) {
        if (target < 0) return;
        else if (target == 0) {
            // found sum
            if (!result.contains(combo)) {
                result.add(new ArrayList(combo));
            }

        } else {
            for (int i = start; i < A.size(); i++) {
                int val = A.get(i);
                combo.add(val);
                backtrack(result, combo, A, target-val, i);
                combo.remove(combo.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 3, 6, 7));
        System.out.println(cs.combinationSum(A, 7));

        A = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        System.out.println(cs.combinationSum(A, 28));
    }
}
