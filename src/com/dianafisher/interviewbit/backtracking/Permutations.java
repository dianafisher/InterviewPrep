package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 1/15/18.
 *
 * Given a collection of numbers, return all possible permutations.

 Example:

 [1,2,3] will have the following permutations:

 [1,2,3]
 [1,3,2]
 [2,1,3]
 [2,3,1]
 [3,1,2]
 [3,2,1]
 NOTE
 No two entries in the permutation sequence should be the same.
 For the purpose of this problem, assume that all the numbers in the collection are unique.

 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), A);

        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> permutation, ArrayList<Integer> A) {
        // if we have all N items, add permutation to result
        if (permutation.size() == A.size()) {
            result.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < A.size(); i++) {
                int val = A.get(i);
                // do not add duplicate items.
                if (!permutation.contains(val)) {
                    // include
                    permutation.add(val);
                    backtrack(result, permutation, A);
                    // exclude
                    permutation.remove(permutation.size()-1);
                }

            }
        }


    }

    public static void main(String[] args) {
        Permutations s = new Permutations();
        ArrayList<Integer> nums = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println(s.permute(nums));

    }
}
