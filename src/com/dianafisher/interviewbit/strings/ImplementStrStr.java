package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/2/17.
 *
 * Implement strStr();
 * strstr - locate a substring ( needle ) in a string ( haystack ).
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {

    public static int strStr(final String haystack, final String needle) {
        if (haystack == null || needle == null) return -1;

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int hIdx = 0;
        int nIdx = 0;
        int idx = -1;

        while (hIdx < haystack.length()) {
            if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
                if (nIdx == 0) {
                    idx = hIdx;
                }
                if (nIdx < needle.length()-1) {
                    nIdx++;
                } else {
                    // found entire needle
                    return idx;
                }
            } else {
                if (idx > -1) {
                    hIdx = idx;
                }
                nIdx = 0;
                idx = -1;
            }
            hIdx++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("haystack", "needle")); // expect -1
        System.out.println(strStr("", ""));  // expect -1
        System.out.println(strStr("b", "baba")); // expect -1
        System.out.println(strStr("johnny appleseed", "apple"));  // expect 7
        System.out.println(strStr("bbbbbbbbab", "baba"));  // expect -1
        System.out.println(strStr("babbbbabbbab", "baba"));  // expect - 1
        System.out.println(strStr("babbbbababbab", "baba"));  // expect 5
        System.out.println(strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));  // expect 48
    }
}
