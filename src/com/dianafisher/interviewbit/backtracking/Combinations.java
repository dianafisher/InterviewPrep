package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/20/18.
 *
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

 Make sure the combinations are sorted.

 To elaborate,

 Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 Entries should be sorted within themselves.
 Example :

 If n = 4 and k = 2, a solution is:

 [
 [1,2],
 [1,3],
 [1,4],
 [2,3],
 [2,4],
 [3,4],
 ]


 */

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        int n = A;
        int k = B;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> numbers = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            numbers.add(num);
            num++;
        }
        backtrack(result, numbers, k, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> numbers, int k, ArrayList<Integer> current, int start) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < numbers.size(); i++) {
            current.add(numbers.get(i));
            backtrack(result, numbers, k, current, i+1);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }
}
