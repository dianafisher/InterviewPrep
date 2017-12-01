package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/22/17.
 *
 * We consider two strings to be anagrams of each other if the first string's letters
 * can be rearranged to form the second string. In other words, both strings must contain
 * the same exact letters in the same exact frequency For example, bacdc and dcbac are
 * anagrams, but bacdc and dcbad are not.
 *
 * Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum
 * number of character deletions required to make the two strings anagrams. Can you help her find this number?
 *
 * Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character
 * deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.
 */

public class MakingAnagrams {

    public static int NUM_LETTERS = 26;

    private static int[] getCharCounts(String s) {
        int[] charCounts = new int[NUM_LETTERS];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int)'a';
            int code = c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }

    private static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length) return -1;

        int delta = 0;
        for (int i = 0; i < array1.length; i++) {
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }

    public static int numberNeeded(String first, String second) {

        int[] firstCounts = getCharCounts(first);
        int[] secondCounts = getCharCounts(second);

        return getDelta(firstCounts, secondCounts);
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.next();
//        String b = in.next();
        System.out.println(numberNeeded("cde", "abc"));
        System.out.println(numberNeeded("hello", "billion"));
        System.out.println(numberNeeded("glue", "legs"));
        System.out.println(numberNeeded("candy", "day"));
    }


}
