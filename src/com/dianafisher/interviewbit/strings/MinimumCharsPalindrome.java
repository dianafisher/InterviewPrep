package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/2/17.
 *
 * Minimum Characters required to make a String PalindromicBookmark Suggest Edit
 *
 * You are given a string. The only operation allowed is to insert characters in the
 * beginning of the string. How many minimum characters are needed to be inserted to
 * make the string a palindrome string

 Example:
 Input: ABC
 Output: 2

 Input: AACECAAAA
 Output: 2

 Clarifying questions:

 Q: Will the string have punctuation?
 */
public class MinimumCharsPalindrome {

    public static int solve(String A) {
        if (A == null || A.length() <= 1) return 0;

        if (isPalindrome(A)) {
            return 0;
        }
//        System.out.println("A = " + A);
        int count = 0;
        int N = A.length();
        int rightOffset = 0;
        int leftOffset = 0;
        StringBuilder builder = new StringBuilder(A);
        while (!isPalindrome(builder.toString()) && rightOffset < N) {
            char ch = A.charAt(N-1-rightOffset);
            builder.insert(leftOffset, ch);
            rightOffset++;
            leftOffset++;
            count++;
//            System.out.println(builder.toString());
        }
        return count;
    }

    public static boolean isPalindrome(String a) {

        int n = a.length();

        if (n == 0) return false;
        if (n == 1) return true;

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
                        return false;
                    }

                    // characters are equal, so move to next pair
                    i++;
                    j--;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve(""));  // expect 0
        System.out.println(solve("ABA"));  // expect 0
        System.out.println(solve("ABA"));  // expect 0
        System.out.println(solve("ABC"));  // expect 2
        System.out.println(solve("ABBC"));  // expect 3      ABBC -> CABBC -> CBABBC -> CBBABBC
        System.out.println(solve("AACECAAAA"));  // expect 2
        System.out.println(solve("zrzbmnmgqoo"));  // expect 8
        /* zrzbmnmgqoo
           ozrzbmnmgqoo
           oozrzbmnmgqoo
           oozrzbmnmgqoo
           ooqzrzbmnmgqoo
           ooqgzrzbmnmgqoo
           ooqgmzrzbmnmgqoo
           ooqgmnzrzbmnmgqoo
           ooqgmnbzrzbmnmgqoo
         */

    }
}
