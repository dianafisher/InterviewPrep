package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/21/17.
 *
 * Reverse the words in a string. For example, “coding for interviews” is reversed to “interviews for coding”.
 */
public class ReverseWords {

    public static String reverseWords(String sentence) {

        // reverse the entire sentence
        String reversed = reverseString(sentence);

        // break into individual words
        String[] words = reversed.split(" ");

        // reverse each word
        StringBuilder result = new StringBuilder();
        for (String word : words) {
//            System.out.println(word);
            result.append(reverseString(word)).append(" ");
        }

        return result.toString();
    }

    private static String reverseString(String s) {
        StringBuilder buffer = new StringBuilder();

        for (int i = s.length()-1; i > -1; i--) {
            buffer.append(s.charAt(i));
        }

        return buffer.toString();
    }

    public static String reverseWordsQuick(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = words.length-1; i > -1; i--) {
            result.append(words[i]).append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = reverseWords("coding for interviews");
        System.out.println(result);

        System.out.println(reverseWordsQuick("coding for interviews"));
    }
}
