package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by dianafisher on 1/15/18.
 *
 * Given a set of distinct integers, S, return all possible subsets.

 Note:

 Elements in a subset must be in non-descending order.

 The solution set must not contain duplicate subsets.

 Also, the subsets should be sorted in ascending ( lexicographic ) order.

 The list is not necessarily sorted.

 Example :

 If S = [1,2,3], a solution is:

 [
    [],
    [1],
    [1, 2],
    [1, 2, 3],
    [1, 3],
    [2],
    [2, 3],
    [3],
 ]
 */

public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
//        System.out.println(A);
        ArrayList<Integer> subset = new ArrayList<>();
        backtrack(0, result, subset, A);
        return result;
    }

    private void backtrack(int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, ArrayList<Integer> A) {

        result.add(new ArrayList<>(subset));
//        System.out.println("result = " + result);
        for (int i = start; i < A.size(); i++) {

            int val = A.get(i);
            // include
            subset.add(val);
//            System.out.println("subset = " + subset);
            backtrack(i + 1, result, subset, A);
            // exclude
            subset.remove(subset.size() - 1);
        }
    }


    public static void main(String[] args) {
        Subset s = new Subset();
        ArrayList<Integer> nums = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println(s.subsets(nums));



    }
}
