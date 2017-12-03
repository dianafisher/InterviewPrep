package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/2/17.
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Given s = "Hello World",

 return 5 as length("World") = 5.

 Please make sure you try to solve this problem without using library functions.
 Make sure you only traverse the string once.

 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(final String A) {
        int count = 0;
        boolean foundChar = false;

        for (int i = A.length() - 1; i > -1; i--) {
            if (A.charAt(i) != ' ') {
                foundChar = true;
                count++;
            } else {
                if (foundChar) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
    }
}
