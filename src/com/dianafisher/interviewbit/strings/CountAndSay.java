package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/2/17.
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...
 1 is read off as 'one 1' or 11.
 11 is read off as 'two 1s' or 21.

 21 is read off as 'one 2, then one 1' or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 Example:

 if n = 2,
 the sequence is 11.

 1
 11 (one 1 -> 11)
 21 (two 1's -> 21)
 1211 (one 2, two 1's -> 1211)
 111221 (one 1, one 2, two 1's -> 111221)
 31221 (three 1's, two 2's, one 1 -> 31221)

 */
public class CountAndSay {

    public static String countAndSay(int a) {

        int n = 1;
        StringBuilder str = new StringBuilder("1");

        while (n < a) {
            int idx = 0;
            char ch = str.charAt(idx);
            int count = 0;
            StringBuilder saying = new StringBuilder();
            while (idx < str.length()) {
                if (str.charAt(idx) == ch) {
                    count++;
//                    System.out.println(count + " -> " + ch);
                } else {
                    saying.append(count);
                    saying.append(ch);
                    ch = str.charAt(idx);
                    count = 1;
                }
                idx++;
            }

            saying.append(count);
            saying.append(ch);
//            System.out.println("saying = " + saying);
            str = saying;
            n++;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(2));  // expect 11
        System.out.println(countAndSay(4));  // expect 1211
        System.out.println(countAndSay(5));  // expect 111221
        System.out.println(countAndSay(6));  // expect 111221
        System.out.println(countAndSay(19));  // expect 111221
    }
}
