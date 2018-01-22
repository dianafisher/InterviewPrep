package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/22/18.
 *
 * Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses of length 2*n.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"

 Make sure the returned list of strings are sorted.


 */
public class GenerateAllParenthesesII {

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(result, "", A, A);

        return result;
    }

    private void backtrack(ArrayList<String> result, String current, int open, int closed) {

        if (open > closed) return;

        if (open == 0 && closed == 0) {
            result.add(current);
            return;
        }


        if (open > 0) {
            backtrack(result, current + "(", open-1, closed);
        }
        if (closed > 0) {
            backtrack(result, current + ")", open, closed-1);
        }
    }

    public static void main(String[] args) {
        GenerateAllParenthesesII gap = new GenerateAllParenthesesII();
        System.out.println(gap.generateParenthesis(3));

    }

}
