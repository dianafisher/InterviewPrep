package com.dianafisher.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 11/28/17.
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 *
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 *
 * Example:
 *
 * Given the array as:
 * ["abcdefgh", "aefghijk", "abcefgh"]
 *
 * The answer would be “a”.
 */

public class LongestCommonPrefix {

    public static String longestCommonPrefix(ArrayList<String> a) {

        int N = a.size();
        if (N == 0) return "";
        if (N == 1) return a.get(0);

        // In case the strings do not have the same length, find the shortest length.
        int minLength = Integer.MAX_VALUE;
        for (String s : a) {
            minLength = Math.min(minLength, s.length());
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        boolean match = true;
        while (i < minLength && match) {
            char ch = a.get(0).charAt(i);
//            System.out.println("ch = " + ch);
            // Loop through each string in array a and check character at index i
            for (int n = 1; n < N; n++) {
                String str = a.get(n);
                char c = str.charAt(i);
//                System.out.println("comparing " + c + " with " + ch);
                if (str.charAt(i) != ch) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result.append(ch);
            }
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("abcdefgh", "aefghijk", "abcefgh"));
        System.out.println(longestCommonPrefix(A));

        A = new ArrayList<String>(Arrays.asList("abcdefgh", "abcefgh"));
        System.out.println(longestCommonPrefix(A));

        A = new ArrayList<String>(Arrays.asList("abcd", "abcd", "efgh"));
        System.out.println(longestCommonPrefix(A));


    }
}
