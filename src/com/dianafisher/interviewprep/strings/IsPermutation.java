package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/21/17.
 *
 * The brute-force method, and simplest, is to compute and store all possible string permutations
 * in an array, and iterate through, checking. However, as discussed above, this results in an
 * terrific O(n!) time – unacceptable.
 *
 * Instead, we can solve this problem by counting characters.
 *
 * Another acceptable approach is to sort both strings, comparing each entry of the sorted strings.
 * Since all permutations have the same number of characters, the sorted strings must be identical.
 * Sorting, however, is dependent on input sequence, and adds another layer of complexity to the code.
 * Counting characters is simple and direct.
 *
 */

public class IsPermutation {

    public static boolean isPermuation(String a, String b) {
        if (a.length() != b.length()) return false;

        // initialize an array as a counter.
        int[] count = new int[128];

        // count a's characters
        for (char ch : a.toCharArray()) {
            count[ch]++;
        }

        // check b's character count
        for (char ch : b.toCharArray()) {
            if (--count[ch] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermuation("cabd", "adcb"));
        System.out.println(isPermuation("cabd", "bdcb"));
        System.out.println(isPermuation("aabd", "adcb"));
        System.out.println(isPermuation("aaa", "bbb"));
    }
}
