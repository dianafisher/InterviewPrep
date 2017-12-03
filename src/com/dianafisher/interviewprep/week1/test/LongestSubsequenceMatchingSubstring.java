package com.dianafisher.interviewprep.week1.test;

import java.util.HashSet;

/**
 * Created by dianafisher on 12/2/17.
 */
public class LongestSubsequenceMatchingSubstring {

    static int longestSubsequence(String x, String y) {
        if (x.length() == 0 || y.length() == 0) return 0;

//        // characters a-z
//        int[] xChars = new int[26];
//        int[] yChars = new int[26];
//
//        for (int i = 0; i < x.length(); i++) {
//            char ch = x.charAt(i);
//            int index = ch - 'a';
//            System.out.println("ch = " + ch + ", index = " + index);
//            xChars[index] += 1;
//        }
//
//        for (int i = 0; i < y.length(); i++) {
//            char ch = y.charAt(i);
//            int index = ch - 'a';
//            System.out.println("ch = " + ch + ", index = " + index);
//            yChars[index] += 1;
//        }
//
//        // now count the number of characters that match
//        int len = 0;
//        for (int i = 0; i < 26; i++) {
//           len += Math.min(xChars[i], yChars[i]);
//        }

        // longest subsequence of x
        // that is a substring of y

        // generate subsequences of x
        // a subsequence is one or more characters of x

        System.out.println("------");


        HashSet<String> subsequences = new HashSet<String>();
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            StringBuilder seq = new StringBuilder();
            seq.append(ch);
            if (!subsequences.contains(seq.toString())) {
                subsequences.add(seq.toString());
            }
            for (int j = i+1; j < x.length(); j++) {
                char c = x.charAt(j);
                seq.append(c);
                if (!subsequences.contains(seq.toString())) {
                    subsequences.add(seq.toString());
                }
            }
        }

        // now see which ones are substrings of y.
        int longest = Integer.MIN_VALUE;
        for (String s : subsequences) {

            if (y.contains(s)) {
                System.out.println(s + " is a substring of " + y);
                longest = Math.max(longest, s.length());
            }
        }

       return longest;
    }



    public static void main(String[] args) {
        System.out.println(longestSubsequence("hackerranks", "hackers"));   // returns 7
        System.out.println(longestSubsequence("abc", "aedace"));  // returns 2
        System.out.println(longestSubsequence("cab", "aedace"));  // returns 1
    }
}
