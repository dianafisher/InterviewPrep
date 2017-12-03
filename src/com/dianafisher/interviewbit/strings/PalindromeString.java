package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/2/17.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Example:

 "A man, a plan, a canal: Panama" is a palindrome.

 "race a car" is not a palindrome.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 */
public class PalindromeString {

    public int isPalindrome(String a) {
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

}
