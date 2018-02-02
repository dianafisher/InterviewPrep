package com.dianafisher.interviewbit.dynamic_programming.word_break;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dianafisher on 1/31/18.
 *
 * Given a string s and a dictionary of words dict, determine if s can be segmented
 * into a space-separated sequence of one or more dictionary words.

 For example, given

 s = "myinterviewtrainer",
 dict = ["trainer", "my", "interview"].
 Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 */
public class Solution {

    public int wordBreak(String A, ArrayList<String> B) {

        Set<String> wordSet = new HashSet<>(B);

        int N = A.length();
        boolean[] dp = new boolean[N+1];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = i-1; j > -1; j--) {
                String s = A.substring(j, i);
//                System.out.println("s = " + s);
                if (dp[j] && wordSet.contains(s)) {
                    dp[i] = true;
                    break;
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
//        }

        return dp[N] ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("trainer", "my", "interview"));
        System.out.println(s.wordBreak("myinterviewtrainer", words));

        words = new ArrayList<>(Arrays.asList("abbbabaa", "baabaaaab", "babaaaaaba", "b", "b", "bbaaaab", "aaabbb", "aabbbbbab", "abbb", "abaa", "aaababaab", "aabbabaa", "bab", "bbbbaabbb"));
        System.out.println(s.wordBreak("abababababaaaabaabbbabbbabbababbb", words));


    }
}
