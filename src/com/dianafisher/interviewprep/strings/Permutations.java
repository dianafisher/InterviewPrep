package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/21/17.
 *
 * Generate all permuations of a string.
 *
 * Realize that generating all permutations of a given string of size n will
 * always result in O(n!) time, both iteratively and recursively.
 */

public class Permutations {

    public static void permutations(String str) {
        // recursive approach
        permute("", str);
    }

    private static void permute(String left, String right) {
        int n = right.length();

        if (n == 0) {
            System.out.println(left);
        } else {
            for (int i = 0; i < n; i++) {
                String newLeft = left + right.charAt(i);
                String newRight = right.substring(0, i) + right.substring(i+1, n);
                permute(newLeft, newRight);
            }
        }
    }

    public static void main(String[] args) {
        permutations("abcd");
    }
}
