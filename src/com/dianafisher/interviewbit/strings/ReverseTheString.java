package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/1/17.
 *
 * Given an input string, reverse the string word by word.

 Example:

 Given s = "the sky is blue",

 return "blue is sky the".

 A sequence of non-space characters constitutes a word.
 Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 If there are multiple spaces between words, reduce them to a single space in the reversed string.

 */
public class ReverseTheString {

    public static String reverseWords(String a) {

        char[] chars = a.toCharArray();

        // ignore leading spaces
        int i = 0;
        while (chars[i] == ' ' && i < chars.length) {
            i++;
        }

        StringBuilder builder = new StringBuilder();
        while (i < chars.length) {
            if (chars[i] != ' ') {
                builder.append(chars[i]);
            } else {
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
                if (i < chars.length) {
                    // add one space
                    builder.append(' ');
                    builder.append(chars[i]);
                }
            }
            i++;
        }

        System.out.println(builder.toString());
        String[] words = builder.toString().split(" ");
        int count = words.length;
        int mid = count / 2;

        for (int idx = 0; idx < mid; idx++) {
            int j = count - idx - 1;
            // swap words
            String temp = words[idx];
            words[idx] = words[j];
            words[j] = temp;
        }

        StringBuilder result = new StringBuilder();
        for (int idx = 0; idx < words.length; idx++) {
            result.append(words[idx]);
            if (idx < words.length-1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));        // expect "blue is sky the"
        System.out.println(reverseWords("    the sky is blue"));    // expect "blue is sky the"
        System.out.println(reverseWords("    the sky is blue     "));    // expect "blue is sky the"
        System.out.println(reverseWords("the    sky is blue"));    // expect "blue is sky the"
        System.out.println(reverseWords("the    sky is blue  "));    // expect "blue is sky the"
        System.out.println(reverseWords(" ankrqzzcel dyaiug y rkicv t"));    // expect "t rkicv y dyaiug ankrqzzcel"
        System.out.println(reverseWords("fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq"));    // expect "iwfcqq igjgip myq sn dqmy qfho sswz ouhsuhf kxorifrhubk jsx ulc osdt fwbpudnbrozzifml"
    }
}
