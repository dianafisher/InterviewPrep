package com.dianafisher.interviewprep.week1.challenges;

/* Longest Palindromic Substring

Write a program which takes a String as input and returns a String which is the longest
palindromic substring in the input, given the following assumptions about the input string:

its maximum length is 1000
it contains one unique, longest palindromic substring
Examples:

"abdbabbdba" should return "abdba"
"abdbbbbdba" should return "abdbbbbdba"
*
* */

public class LongestPalindromicSubstring {

    public String longestPalindromicSubstring(String text) {
        int N = text.length();
        if (N <= 1) return text;

        int max = Integer.MIN_VALUE;

        // Create a 2D table to hold whether or not substring[i..j] is a palindrome.
        boolean [][] table = new boolean[N][N];
        int i;

        // All substrigs of length 1 are palindromes, so initialize to true.
        for (i = 0; i < N; i++) {
            table[i][i] = true;
        }

        /* To calculate table[i][j], first check the value of table[i+1][j-1].
           If table[i+1][j-1] = true and text[i] == text[j], then set table[i][j] equal to true.

           g[eee]k is not a palindrome since g != k
           g[eee]g is a palindrome
        */

        for (int len = 2; len <= N; len++) {
            int j;

            for (i = 0; i < N - len + 1; i++) {
                j = i + len - 1;
                if (len == 2) {
                    if (text.charAt(i) == text.charAt(j)) {
                        table[i][j] = true;  // is palindrome
                    }
                } else {
                    if (text.charAt(i) == text.charAt(j) && table[i+1][j-1]) {
                        table[i][j] = true;
                    }
                }
            }
        }


        int start = -1;

        for (i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int len = j-i+1;
                if (table[i][j] && len > max) {
                    max = len;
                    start = i;
                }
            }
        }
        String substring = text.substring(start, start + max);
        return substring;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindromicSubstring("abdbabbdba"));  // abdba
        System.out.println(solution.longestPalindromicSubstring("abdbbbbdba"));  // abdbbbbdba
    }
}
