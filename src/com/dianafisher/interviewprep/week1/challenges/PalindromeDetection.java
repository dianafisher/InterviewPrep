package com.dianafisher.interviewprep.week1.challenges;

/**
 * Created by dianafisher on 11/30/17.
 *
 * A palindrome is a word, phrase, or sequence of characters that reads the same
 * backward as forward, e.g., madam or nurses run.
 *
 * Write a program which takes a String as input and returns a boolean value which is true
 * if the input is a palindrome and false if it is not, considering only alphanumeric characters and ignoring case.
 *
 * Example:
 *
 * "A man, a plan, a canal: Panama" is a palindrome and should return true
 * "race a car" is not a palindrome and should return false
 *
 */
public class PalindromeDetection {

    public static int isPalindrome(String a) {

        int n = a.length();

        if (n == 0) return 0;
        if (n == 1) return 1;

        /*
        * Solution approach:
        *
        * Use two pointers: one starting at the beginning of the string, the other starting at the end and
        * moving backwards until they meet.
        * Compare characters at each pointer and return false when the do not match.
        * Ignore any non-alphanumeric characters by skipping over them.
        * Ignore case by converting both characters to lowercase and then comparing them.
        * */
        int i = 0;
        int j = n-1;
        while (i < j) {
            char ch1 = a.charAt(i);
            if (!Character.isLetterOrDigit(ch1)) {
                // increment i
                i++;
            } else {
                char ch2 = a.charAt(j);
                if (!Character.isLetterOrDigit(ch2)) {
                    j--;
                } else {
                    // now both characters are alphanumeric so we can compare them.
                    if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
//                        System.out.println(ch1 + " != " + ch2);
                        return 0;
                    }

                    // characters are equal, so move to next pair
                    i++;
                    j--;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));  // expect 1
        System.out.println(isPalindrome("race a car"));  // expect 0
        System.out.println(isPalindrome("\""));  // expect 1
        System.out.println(isPalindrome(".,"));  // expect 1
    }
}
