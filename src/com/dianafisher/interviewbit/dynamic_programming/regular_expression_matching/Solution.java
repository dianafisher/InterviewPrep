package com.dianafisher.interviewbit.dynamic_programming.regular_expression_matching;

/**
 * Created by dianafisher on 1/29/18.
 *
 * Implement wildcard pattern matching with support for '?' and '*'.

 '?' : Matches any single character.
 '*' : Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 The function prototype should be:

 int isMatch(const char *s, const char *p)
 Examples :

 isMatch("aa","a") → 0
 isMatch("aa","aa") → 1
 isMatch("aaa","aa") → 0
 isMatch("aa", "*") → 1
 isMatch("aa", "a*") → 1
 isMatch("ab", "?*") → 1
 isMatch("aab", "c*a*b") → 0

 Return 1/0 for this problem.

 */
public class Solution {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int __isMatch(final String s, final String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else {
                return 0;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }

        return j == p.length() ? 1 : 0;
    }

    public int isMatch(final String A, final String B) {
        int a = 0;  // index in string A
        int b = 0;  // index in string B

        int starIdx = -1;
        int idx = -1;

        while (a < A.length()) {
            if (b < B.length() && (B.charAt(b) == '?' || A.charAt(a) == B.charAt(b))) {
                // characters match, so move both pointers forward
                a++;
                b++;
            }
            else if (b < B.length() && B.charAt(b) == '*') {
                // found a star, note the index
                starIdx = b;
                idx = a;
                b++;
            } else if (starIdx != -1) {
                b = starIdx + 1;
                a = idx + 1;
                idx++;
            } else {
                return 0;
            }
        }

        while (b < B.length() && B.charAt(b) == '*') {
            b++;
        }

        // return 'true' if we have reached the end of string B
        return (b == B.length() ? 1 : 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "aa"));
        System.out.println(s.isMatch("aaa", "aa"));
        System.out.println(s.isMatch("aaa", "*"));
        System.out.println(s.isMatch("aa", "a*"));
        System.out.println(s.isMatch("ab", "?*"));
        System.out.println(s.isMatch("aab", "c*a*b"));
        System.out.println(s.isMatch("bbbcbcb", "**b")); // 1
    }
}
