package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/15/18.
 *
 * Given a string s, partition s such that every string of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
    ["a","a","b"]
    ["aa","b"],
 ]

 Ordering the results in the answer : Entry i will come before Entry j if :
 len(Entryi[0]) < len(Entryj[0]) OR
 (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 *
 *
 *
 (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))

 In the given example,
 ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")

 */
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        backtrack(result, new ArrayList<>(), a, 0);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<String>> result, ArrayList<String> partitions, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(partitions));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    // include
                    partitions.add(s.substring(start, i+1));
                    backtrack(result, partitions, s, i+1);
                    // exclude
                    partitions.remove(partitions.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("aab"));
    }
}
